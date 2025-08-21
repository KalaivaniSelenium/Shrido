package com.thinktimetechno.Shrido.endpoints;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import com.thinktimetechno.utils.FailedApiTracker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LiveTripTrackingEndpoints extends BaseEndpoints{

    private RequestSpecification requestSpecification;
    public Response result;
    public static String authToken;
    public static String dynamicMobile;
    
    

    public void sendPostRequestWithPayload(String jsonFileName) throws IOException {

    	try {
      
        switch (jsonFileName) {
            case "Update trip status.json":
                application_ENDPOINT_PATH = "/api/trip/change_trip_status/"+BaseEndpoints.tripId;
                break;
            case "End User Trip.json":
                application_ENDPOINT_PATH = "/api/trip/end_trip";
                break;
            
            default:
                throw new IllegalArgumentException("Endpoint not defined for file: " + jsonFileName);
        }
        this.apiNameIdentifier = jsonFileName.replace(".json", "");
        // Prepare request
        requestSpecification = getRequestWithJSONHeader(application_ENDPOINT_PATH);

        // Load payload file
        String filePath = System.getProperty("user.dir") + "/src/test/resources/Payloads/LiveTripTrackingPayloads/" + jsonFileName;
        String jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONObject jsonObject = new JSONObject(jsonContent);
       
        // updating driver trip id
        if (application_ENDPOINT_PATH.equals("/api/trip/end_trip")) {
            jsonObject.put("driver_trip_id", BaseEndpoints.tripId);
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
	        String filePath = System.getProperty("user.dir") + "/src/test/resources/Payloads/LiveTripTrackingPayloads/"+ jsonFile;
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