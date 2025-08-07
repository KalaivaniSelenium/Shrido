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

			// Prepare request
			requestSpecification = getRequestWithJSONHeader(application_ENDPOINT_PATH);

			String filePath = System.getProperty("user.dir") + "/src/test/resources/Payloads/MSG91Payloads/"
					+ jsonFileName;
			String jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));
			JSONObject jsonObject = new JSONObject(jsonContent);
			result = requestSpecification
					.body(jsonObject.toString())
					.post(application_ENDPOINT_PATH);

		} catch (Exception e) {
			String exceptionName = e.getClass().getSimpleName();
			FailedApiTracker.logFailure(application_ENDPOINT_PATH, exceptionName);
			System.err.println("Error occurred while sending POST request for: " + jsonFileName);
			throw e;
		}
	}
}