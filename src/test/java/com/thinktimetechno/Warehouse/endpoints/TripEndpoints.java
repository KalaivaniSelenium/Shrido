package com.thinktimetechno.Warehouse.endpoints;

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

public class TripEndpoints extends BaseEndpoints{

    private RequestSpecification requestSpecification;
    public Response result;
    public static String authToken;
    public static String dynamicMobile;
    
    

    public void sendPostRequestWithPayload(String jsonFileName) throws IOException {

    	try {
      
        switch (jsonFileName) {
            case "Create Trip.json":
                application_ENDPOINT_PATH = "/api/trip/create_trip";
                break;
            case "Search all trip.json":
                application_ENDPOINT_PATH = "/api/trip/search";
                break;
            case "Update trip status.json":
                application_ENDPOINT_PATH = "/api/trip/change_trip_status/208";
                break;
            case "End User Trip.json":
                application_ENDPOINT_PATH = "/api/trip/end_trip";
                break;
            case "History of Trips.json":
                application_ENDPOINT_PATH = "/api/trip/trip_history";
                break;
            default:
                throw new IllegalArgumentException("Endpoint not defined for file: " + jsonFileName);
        }

        requestSpecification = getRequestWithJSONHeader(application_ENDPOINT_PATH);

            String filePath = System.getProperty("user.dir") + "/src/test/resources/Payloads/TripPayloads/"+ jsonFileName;
            String jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject jsonObject = new JSONObject(jsonContent);

            result = requestSpecification
                    .body(jsonObject.toString())
                    .post(application_ENDPOINT_PATH);
            }
        
catch (Exception e) {
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
	        case "Get All Dates of Trips":
	            application_ENDPOINT_PATH = "/api/trip/trip_dates";
	            break;
	            
	    }

	    return result = requestSpecification.get(application_ENDPOINT_PATH);
    	}
    	
    	
	    catch (Exception e) {
		    String exceptionName = e.getClass().getSimpleName();
		    FailedApiTracker.logFailure(application_ENDPOINT_PATH, exceptionName);
		    System.err.println("Error occurred while sending GET request for: " + APIName);
		    throw e;
    }
	}
    
    public Response sendGetRequestWithJson(String jsonFileName) throws Exception {
    	try {
    	 requestSpecification = getRequestWithJSONHeader(application_ENDPOINT_PATH);
	   
	    switch (jsonFileName) {
	        case "Get next trip.json":
	            application_ENDPOINT_PATH = "/api/trip/next_trip";
	            break;

	            
	    }

        String filePath = System.getProperty("user.dir") + "/src/test/resources/Payloads/TripPayloads/"+ jsonFileName;
        String jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONObject jsonObject = new JSONObject(jsonContent);

       return result = requestSpecification
                .body(jsonObject.toString())
                .put(application_ENDPOINT_PATH);
        }
    
    	
    	
	    catch (Exception e) {
		    String exceptionName = e.getClass().getSimpleName();
		    FailedApiTracker.logFailure(application_ENDPOINT_PATH, exceptionName);
		    System.err.println("Error occurred while sending GET request for: " + jsonFileName);
		    throw e;
    }
	}
    
    public void sendPutRequestWithPayload(String jsonFileName, String PayloadFolderName) throws IOException {
    	
    	try {
        switch (jsonFileName) {
            case "Update Profile.json":
                application_ENDPOINT_PATH = "/api/user/profile_update";
                break;
            default:
                throw new IllegalArgumentException("PUT endpoint not defined for file: " + jsonFileName);
        }

        // Prepare request
        requestSpecification = getRequestWithJSONHeader(application_ENDPOINT_PATH);

        if (application_ENDPOINT_PATH.equals("/api/user/profile_update")) {
            String dynamicEmail = BaseEndpoints.email;
            result = requestSpecification
                    .multiPart("email", dynamicEmail)
                    .put(application_ENDPOINT_PATH);
        }
        else {
        	
        // Read JSON payload file
        String filePath = System.getProperty("user.dir") + "/src/test/resources/Payloads/" + PayloadFolderName + "/" + jsonFileName;
        String jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONObject jsonObject = new JSONObject(jsonContent);
        
        // Send PUT request
        result = requestSpecification
                .body(jsonObject.toString())
                .put(application_ENDPOINT_PATH);
        }
        System.out.println("Response: " + result.getBody().asPrettyString());}
	    catch (Exception e) {
		    String exceptionName = e.getClass().getSimpleName();
		    FailedApiTracker.logFailure(application_ENDPOINT_PATH, exceptionName);
		    System.err.println("Error occurred while sending POST request for: " + jsonFileName);
		    throw e;
    }}
    	
    public Response applicationSalesDeletePayload(String APIName ) {
    	try {
        requestSpecification = getRequestWithJSONHeader(application_ENDPOINT_PATH);
		switch (APIName){
		case "Delete trip":
			application_ENDPOINT_PATH="/api/trip/202";
			System.out.println(application_ENDPOINT_PATH);
			break;

		}
			result=requestSpecification.delete(application_ENDPOINT_PATH);
	     	return result;
            }
    catch (Exception e) {
	    String exceptionName = e.getClass().getSimpleName();
	    FailedApiTracker.logFailure(application_ENDPOINT_PATH, exceptionName);
	    System.err.println("Error occurred while sending POST request for: " + APIName);
	    throw e;
}
    }}