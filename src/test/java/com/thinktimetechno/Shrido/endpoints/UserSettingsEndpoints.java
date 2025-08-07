package com.thinktimetechno.Shrido.endpoints;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import com.thinktimetechno.utils.FailedApiTracker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UserSettingsEndpoints extends BaseEndpoints{

    private RequestSpecification requestSpecification;
    public Response result;
    public static String authToken;  
    
    public void sendPostRequestWithPayload(String jsonFileName) throws IOException {

    	try {
      
        switch (jsonFileName) {
            case "Update Auto Refill and Renew Settings.json":
                application_ENDPOINT_PATH = "/api/user_settings/auto_refill_and_subscription";
                break;
            case "Driver Settings.json":
                application_ENDPOINT_PATH = "/api/user_settings/driver";
                break;
            case "Passenger Settings.json":
                application_ENDPOINT_PATH = "/api/user_settings/passenger";
                break;
            case "Notification Settings.json":
                application_ENDPOINT_PATH = "/api/user_settings/notification";
                break;
            
            default:
                throw new IllegalArgumentException("Endpoint not defined for file: " + jsonFileName);
        }

	        // Prepare request
	        requestSpecification = getRequestWithJSONHeader(application_ENDPOINT_PATH);


            String filePath = System.getProperty("user.dir") + "/src/test/resources/Payloads/UserSettingsPayloads/"+ jsonFileName;
            String jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject jsonObject = new JSONObject(jsonContent);

            // Send request with body
            result = requestSpecification
                    .body(jsonObject.toString())
                    .post(application_ENDPOINT_PATH);

        // Print response
        System.out.println("Response: " + result.getBody().asPrettyString());

    	}catch (Exception e) {
    		    String exceptionName = e.getClass().getSimpleName();
    		    FailedApiTracker.logFailure(application_ENDPOINT_PATH, exceptionName);
    		    System.err.println("Error occurred while sending POST request for: " + jsonFileName);
    		    throw e;
        }
    }}
    
   