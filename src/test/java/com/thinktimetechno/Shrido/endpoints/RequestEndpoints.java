package com.thinktimetechno.Shrido.endpoints;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import com.thinktimetechno.utils.FailedApiTracker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RequestEndpoints extends BaseEndpoints{

    private RequestSpecification requestSpecification;
    public Response result;
    public static String authToken;  
    
    public void sendPostRequestWithPayload(String jsonFileName) throws IOException {

        try {

            switch (jsonFileName) {
                case "Send trip Request.json":
                    application_ENDPOINT_PATH = "/api/trip/trips/" + BaseEndpoints.tripId + "/send_request";
                    break;
                case "Request accepted.json":
                    application_ENDPOINT_PATH = "/api/request/" + BaseEndpoints.request_tripId + "/request_accept";
                    break;
                case "Request Reject.json":
                    application_ENDPOINT_PATH = "/api/request/" + BaseEndpoints.request_tripId + "/request_reject";
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

            // ---- CASE 1: No body required for Request Reject ----
            if (application_ENDPOINT_PATH.equals("/api/request/" + BaseEndpoints.request_tripId + "/request_reject")) {
                result = requestSpecification.post(application_ENDPOINT_PATH);
            }

            // ---- CASE 2: Handle APIs with body ----
            else {
                String filePath = System.getProperty("user.dir") + "/src/test/resources/Payloads/RequestPayloads/" + jsonFileName;
                String jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));
                JSONObject jsonObject = new JSONObject(jsonContent);

                // Updating trip date for filter endpoints
                if (application_ENDPOINT_PATH.equals("/api/request/get_trips_with_filter")) {
                    jsonObject.put("date", TripEndpoints.tripStartDate);
                }
                if (application_ENDPOINT_PATH.equals("/api/request/all_confirmed_requests")) {
                    jsonObject.put("date", TripEndpoints.tripStartDate);
                }

                // Send request with body
                result = requestSpecification
                        .body(jsonObject.toString())
                        .post(application_ENDPOINT_PATH);

                // --- Extract and store request trip_id ---
                if (application_ENDPOINT_PATH.equals("/api/trip/trips/" + BaseEndpoints.tripId + "/send_request")) {
                    JSONObject jsonResponse = new JSONObject(result.getBody().asPrettyString());
                    if (jsonResponse.has("data")) {
                        BaseEndpoints.request_tripId = jsonResponse.getJSONObject("data").optInt("id");
                        System.out.println("Saved Request Trip ID: " + BaseEndpoints.request_tripId);
                    }
                }
            }

        } catch (Exception e) {
            String exceptionName = e.getClass().getSimpleName();
            FailedApiTracker.logFailure(application_ENDPOINT_PATH, exceptionName);
            System.err.println("Error occurred while sending POST request for: " + jsonFileName);
            throw e;
        }
    }

}