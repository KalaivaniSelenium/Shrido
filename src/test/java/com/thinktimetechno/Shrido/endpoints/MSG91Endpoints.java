package com.thinktimetechno.Shrido.endpoints;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;

import com.thinktimetechno.utils.FailedApiTracker;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class MSG91Endpoints extends BaseEndpoints {

	private RequestSpecification requestSpecification;
	public Response result;
	public static String authToken;



	public void sendPostRequestWithPayload(String jsonFileName) throws IOException {
		
		try {

			switch (jsonFileName) {
			case "msg91 send sms.json":
				application_ENDPOINT_PATH = "/api/v5/flow/";
				break;
			case "Add Sms Template.json":
				application_ENDPOINT_PATH = "/api/v5/sms/addTemplate";
				break;

			default:
				throw new IllegalArgumentException("Endpoint not defined for file: " + jsonFileName);
			}
			 this.apiNameIdentifier = jsonFileName.replace(".json", "");
		// Prepare request
		requestSpecification = getRequestWithJSONHeader(application_ENDPOINT_PATH,jsonFileName);

			
		  if (application_ENDPOINT_PATH.equals("/api/v5/sms/addTemplate")) {
		    result = requestSpecification
		            .multiPart("template", "Your OTP for sharido application is :")
		            .multiPart("sender_id", "Sender ID")
		            .multiPart("template_name", "Type Template Name")
		            .multiPart("dlt_template_id", "")
		            .multiPart("smsType", "NORMAL")
		            .post(application_ENDPOINT_PATH);
		}

		  else {
			String filePath = System.getProperty("user.dir") + "/src/test/resources/Payloads/MSG91Payloads/"
					+ jsonFileName;
			String jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));
			JSONObject jsonObject = new JSONObject(jsonContent);
			result = requestSpecification
					.body(jsonObject.toString())
					.post(application_ENDPOINT_PATH);
		  }

		} catch (Exception e) {
            String exceptionName = e.getClass().getSimpleName();
            FailedApiTracker.logFailure(apiNameIdentifier != null ? apiNameIdentifier : application_ENDPOINT_PATH,
                                        exceptionName);
            throw e;
        }
	}
}