package com.thinktimetechno.Shrido.endpoints;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import com.thinktimetechno.utils.FailedApiTracker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SettingsEndpoints extends BaseEndpoints{

    private RequestSpecification requestSpecification;
    public Response result;
    public static String authToken;  
    public static String dynamicMobile; 
    
    public void sendPostRequestWithPayload(String jsonFileName) throws IOException {

    	try {
      
        switch (jsonFileName) {
            case "Add PreDefine messages.json":
                application_ENDPOINT_PATH = "/api/settings/predefine_message";
                break;
            case "Add App price value.json":
                application_ENDPOINT_PATH = "/api/settings/app_price_suggest_value";
                break;
            case "Add Email Templates.json":
                application_ENDPOINT_PATH = "/api/settings/add-email-templates";
                break;
            case "Add Threshold Values Limit.json":
                application_ENDPOINT_PATH = "/api/settings/threshold-limit";
                break;
            case "Email Testing.json":
                application_ENDPOINT_PATH = "/api/settings/email-test";
                break;
            case "Add Email Us.json":
                application_ENDPOINT_PATH = "/api/settings/email-us";
                break;
                
            default:
                throw new IllegalArgumentException("Endpoint not defined for file: " + jsonFileName);
        }

	        // Prepare request
	        requestSpecification = getRequestWithJSONHeader(application_ENDPOINT_PATH);

            //Read payload and modify if needed
        	
            String filePath = System.getProperty("user.dir") + "/src/test/resources/Payloads/SettingsPayloads/"+ jsonFileName;
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
    }
    
    public Response sendGetRequest(String APIName) {
    	try {
    	 requestSpecification = getRequestWithJSONHeader(application_ENDPOINT_PATH);
	   
	    switch (APIName) {
	        case "All settings":
	            application_ENDPOINT_PATH = "/api/settings";
	            break;       
	    }

	    return result = requestSpecification
	    		       .get(application_ENDPOINT_PATH);
    	}
	    
	    catch (Exception e) {
		    String exceptionName = e.getClass().getSimpleName();
		    FailedApiTracker.logFailure(application_ENDPOINT_PATH, exceptionName);
		    System.err.println("Error occurred while sending POST request for: " + APIName);
		    throw e;
    }
	}
    
    public void sendPutRequestWithPayload(String jsonFileName, String PayloadFolderName) throws IOException {
    	
    	try {
        switch (jsonFileName) {
            case "Update Email Template.json":
                application_ENDPOINT_PATH = "/api/settings/update-email-templates";
                break;
            default:
                throw new IllegalArgumentException("PUT endpoint not defined for file: " + jsonFileName);
        }

        // Prepare request
        requestSpecification = getRequestWithJSONHeader(application_ENDPOINT_PATH);

        	
        // Read JSON payload file
        String filePath = System.getProperty("user.dir") + "/src/test/resources/Payloads/SettingsPayloads/"+ jsonFileName;
        String jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONObject jsonObject = new JSONObject(jsonContent);
        
        // Send PUT request
        result = requestSpecification
                .body(jsonObject.toString())
                .put(application_ENDPOINT_PATH);
        
        System.out.println("Response: " + result.getBody().asPrettyString());}
	    catch (Exception e) {
		    String exceptionName = e.getClass().getSimpleName();
		    FailedApiTracker.logFailure(application_ENDPOINT_PATH, exceptionName);
		    System.err.println("Error occurred while sending POST request for: " + jsonFileName);
		    throw e;
    }}
    	
}