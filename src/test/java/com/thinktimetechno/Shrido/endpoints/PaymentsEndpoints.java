package com.thinktimetechno.Shrido.endpoints;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import com.thinktimetechno.utils.FailedApiTracker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PaymentsEndpoints extends BaseEndpoints{

    private RequestSpecification requestSpecification;
    public Response result;
    public static String authToken;  
    
    public void sendPostRequestWithPayload(String jsonFileName) throws IOException {

        try {

            switch (jsonFileName) {
                case "Create Payment.json":
                    application_ENDPOINT_PATH = "/api/payment";
                    break;
                case "Verify receipt.json":
                    application_ENDPOINT_PATH = "/api/payment/receipt/verify";
                    break;
                case "Verify Subscription.json":
                    application_ENDPOINT_PATH = "/api/payment/verify/subscription";
                    break;

                default:
                    throw new IllegalArgumentException("Endpoint not defined for file: " + jsonFileName);
            }

            this.apiNameIdentifier = jsonFileName.replace(".json", "");
            // Prepare request
            requestSpecification = getRequestWithJSONHeader(application_ENDPOINT_PATH);

                String filePath = System.getProperty("user.dir") + "/src/test/resources/Payloads/PaymentsPayloads/" + jsonFileName;
                String jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));
                JSONObject jsonObject = new JSONObject(jsonContent);

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
          

        } catch (Exception e) {
            String exceptionName = e.getClass().getSimpleName();
            FailedApiTracker.logFailure(apiNameIdentifier != null ? apiNameIdentifier : application_ENDPOINT_PATH,
                                        exceptionName);
            throw e;
        }
    }

}