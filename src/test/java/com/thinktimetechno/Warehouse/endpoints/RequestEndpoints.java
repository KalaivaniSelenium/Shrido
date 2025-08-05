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

public class RequestEndpoints extends BaseEndpoints{

    private RequestSpecification requestSpecification;
    public Response result;
    public static String authToken;  
    public static String dynamicMobile; 
    
    public void sendPostRequestWithPayload(String jsonFileName) throws IOException {

    	try {
      
        switch (jsonFileName) {
            case "Send trip Request.json":
                application_ENDPOINT_PATH = "/api/trip/trips/207/send_request";
                break;
            case "Request accepted.json":
                application_ENDPOINT_PATH = "/api/request/48/request_accept";
                break;
            case "Request Reject.json":
                application_ENDPOINT_PATH = "/api/request/55/request_reject";
                break;
            case "All request.json":
                application_ENDPOINT_PATH = "/api/request/get_trips_with_filter";
                break;
            case "All Confirmed Request of User.json":
                application_ENDPOINT_PATH = "/api/request/all_confirmed_requests";
                break;
                
                
            default:
                throw new IllegalArgumentException("Endpoint not defined for file: " + jsonFileName);
        }

        // Prepare request
        requestSpecification = getRequestWithJSONHeader(application_ENDPOINT_PATH);

            String filePath = System.getProperty("user.dir") + "/src/test/resources/Payloads/RequestPayloads/"+ jsonFileName;
            String jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject jsonObject = new JSONObject(jsonContent);

            // Send request with body
            result = requestSpecification
                    .body(jsonObject.toString())
                    .post(application_ENDPOINT_PATH);
    	
    	}catch (Exception e) {
    		    String exceptionName = e.getClass().getSimpleName();
    		    FailedApiTracker.logFailure(application_ENDPOINT_PATH, exceptionName);
    		    System.err.println("Error occurred while sending POST request for: " + jsonFileName);
    		    throw e;
        }
    }
}