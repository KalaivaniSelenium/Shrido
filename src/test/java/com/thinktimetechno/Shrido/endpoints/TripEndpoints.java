package com.thinktimetechno.Shrido.endpoints;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import com.thinktimetechno.utils.FailedApiTracker;

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
    public static String tripStartDate;
    

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
                application_ENDPOINT_PATH = "/api/trip/change_trip_status/"+BaseEndpoints.tripId;
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
        this.apiNameIdentifier = jsonFileName.replace(".json", "");
        // Prepare request
        requestSpecification = getRequestWithJSONHeader(application_ENDPOINT_PATH);

        // Load payload file
        String filePath = System.getProperty("user.dir") + "/src/test/resources/Payloads/TripPayloads/" + jsonFileName;
        String jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONObject jsonObject = new JSONObject(jsonContent);
        
        // Creating dynamic start date
        if (application_ENDPOINT_PATH.equals("/api/trip/create_trip")) {
        tripStartDate = LocalDateTime.now().plusDays(3)
                               .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            jsonObject.put("start_date", tripStartDate);
        }
        
        // updating driver trip id
        if (application_ENDPOINT_PATH.equals("/api/trip/end_trip")) {
            jsonObject.put("driver_trip_id", BaseEndpoints.tripId);
		}
        
        // Getting History of trips
        if (application_ENDPOINT_PATH.equals("/api/trip/trip_history")) {
            jsonObject.put("trip_date", tripStartDate);
		}
        
        // Send POST request
        result = requestSpecification.body(jsonObject.toString())
                                     .post(application_ENDPOINT_PATH);

        // Print response
        System.out.println("Response: " + result.getBody().asPrettyString());

        // --- Extract and store trip_id ---
        if (application_ENDPOINT_PATH.equals("/api/trip/create_trip")) {
        JSONObject jsonResponse = new JSONObject(result.getBody().asPrettyString());
        if (jsonResponse.has("data")) {
	            BaseEndpoints.tripId = jsonResponse.getJSONObject("data").optInt("id");
	            System.out.println("Saved Trip ID: " + BaseEndpoints.tripId);
        }
            }
    	}
    	catch (Exception e) {
            String exceptionName = e.getClass().getSimpleName();
            FailedApiTracker.logFailure(apiNameIdentifier != null ? apiNameIdentifier : application_ENDPOINT_PATH,
                                        exceptionName);
            throw e;
        }
    }
    
    
    public Response sendGetRequest(String APIName) throws Exception {
    	try {
    	 requestSpecification = getRequestWithJSONHeader(application_ENDPOINT_PATH);
	   
	    switch (APIName) {
	        case "Get All Dates of Trips":
	            application_ENDPOINT_PATH = "/api/trip/trip_dates";
	            break;  
	    }
	    this.apiNameIdentifier = APIName;
	    return result = requestSpecification
	    		       .get(application_ENDPOINT_PATH);
    	}
	    
	    catch (Exception e) {
		    String exceptionName = e.getClass().getSimpleName();
		    FailedApiTracker.logFailure(application_ENDPOINT_PATH, exceptionName);
		    System.err.println("Error occurred while sending POST request for: " + APIName);
		    throw e;
    }}
    	
    	
    	
    	public Response sendPatchRequestWithPayload(String jsonFileName) throws IOException {
    	    try {
    	        switch (jsonFileName) {
    	            case "Re-Schedule trip time.json":
    	                application_ENDPOINT_PATH = "/api/trip/re_schedule_trip_time";
    	                break;
    	            default:
    	                throw new IllegalArgumentException("PATCH endpoint not defined for file: " + jsonFileName);
    	        }

    	        this.apiNameIdentifier = jsonFileName.replace(".json", "");
    	        // Prepare request
    	        requestSpecification = getRequestWithJSONHeader(application_ENDPOINT_PATH);

    	        // Load JSON payload
    	        String filePath = System.getProperty("user.dir") + "/src/test/resources/Payloads/TripPayloads/" + jsonFileName;
    	        String jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));
    	        JSONObject jsonObject = new JSONObject(jsonContent);

    	        if (application_ENDPOINT_PATH.equals("/api/trip/re_schedule_trip_time")) {
    	        jsonObject.put("trip_id", BaseEndpoints.tripId);
    	        jsonObject.put("start_date", tripStartDate);

    	        // Dynamic start time (current time + 1 hour)
    	        String futureTime = LocalDateTime.now().plusHours(1)
    	                             .format(DateTimeFormatter.ofPattern("hh:mma"));
    	        jsonObject.put("start_desired_time", futureTime);
    	        jsonObject.put("start_latest_time", futureTime);
    	        }
    	        
    	        // Send PATCH request
    	        result = requestSpecification
    	        		.body(jsonObject.toString())
    	                .patch(application_ENDPOINT_PATH);

    	        // Print response
    	        System.out.println("Response: " + result.getBody().asPrettyString());
    	        return result;
    	    }
    	    catch (Exception e) {
                String exceptionName = e.getClass().getSimpleName();
                FailedApiTracker.logFailure(apiNameIdentifier != null ? apiNameIdentifier : application_ENDPOINT_PATH,
                                            exceptionName);
                throw e;
            }
	}
    
    	
    public Response sendDeleteRequest(String APIName ) {
    	try {
        requestSpecification = getRequestWithJSONHeader(application_ENDPOINT_PATH);
		switch (APIName){
		case "Delete trip":
			application_ENDPOINT_PATH="/api/trip/"+BaseEndpoints.tripId;
			 break;
		}
		this.apiNameIdentifier = APIName;
			result = requestSpecification
					.delete(application_ENDPOINT_PATH);
	     	return result;
            }
    	catch (Exception e) {
            String exceptionName = e.getClass().getSimpleName();
            FailedApiTracker.logFailure(apiNameIdentifier != null ? apiNameIdentifier : application_ENDPOINT_PATH,
                                        exceptionName);
            throw e;
        }
    }


	public void sendGetRequestwithJsonPayload(String jsonFile) throws Exception {
		
		try {
	        switch (jsonFile) {
	            case "Get next trip.json":
	                application_ENDPOINT_PATH = "/api/trip/next_trip";
	                break;
	            default:
	                throw new IllegalArgumentException("PUT endpoint not defined for file: " + jsonFile);
	        }
	        this.apiNameIdentifier = jsonFile.replace(".json", "");
	        // Prepare request
	        requestSpecification = getRequestWithJSONHeader(application_ENDPOINT_PATH);

	        	
	        // Read JSON payload file
	        String filePath = System.getProperty("user.dir") + "/src/test/resources/Payloads/TripPayloads/"+ jsonFile;
	        String jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));
	        JSONObject jsonObject = new JSONObject(jsonContent);
	        
	        // Send PUT request
	        result = requestSpecification
	                .body(jsonObject.toString())
	                .get(application_ENDPOINT_PATH);
	        
	        System.out.println("Response: " + result.getBody().asPrettyString());
	        }
	      
		catch (Exception e) {
            String exceptionName = e.getClass().getSimpleName();
            FailedApiTracker.logFailure(apiNameIdentifier != null ? apiNameIdentifier : application_ENDPOINT_PATH,
                                        exceptionName);
            throw e;
        }
	}}