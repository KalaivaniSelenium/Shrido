package com.thinktimetechno.Shrido.endpoints;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import com.thinktimetechno.utils.FailedApiTracker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MerchantwarriorEndpoints extends BaseEndpoints {

    private RequestSpecification requestSpecification;
    public Response result;
    

    /**
     * Sends POST requests for Merchant Warrior APIs.
     * Handles both multipart/form-data and raw JSON requests.
     */
    public void sendPostRequestWithPayload(String jsonFileName) throws IOException {

  
       

        try {
            // Map file name to API endpoint
            switch (jsonFileName) {
                case "Verify_Card.json":
                    application_ENDPOINT_PATH = "/post/";
                    break;
                case "Change Expiry Of Card.json":
                    application_ENDPOINT_PATH = "/post/";
                    break;
                case "Remove Card Merchant warrior.json":
                    application_ENDPOINT_PATH = "/post/";
                    break;
                case "Get Card Info.json":
                    application_ENDPOINT_PATH = "/token/";
                    break;
                case "Verify card.json":
                    application_ENDPOINT_PATH = "/post/";
                    break;
                case "New Request.json":
                    application_ENDPOINT_PATH = "/post/";
                    break;
                default:
                    throw new IllegalArgumentException("Endpoint not defined for file: " + jsonFileName);
            }
           
            this.apiNameIdentifier = jsonFileName.replace(".json", "");

          
            requestSpecification = getRequestWithJSONHeader(application_ENDPOINT_PATH, jsonFileName);

            // Handle multipart APIs
            if (application_ENDPOINT_PATH.equals("/post/") && jsonFileName.equals("Verify_Card.json")) {
                result = requestSpecification
                        .multiPart("method", "verifyCard")
                        .multiPart("merchantUUID", "64c9a16c84b56")
                        .multiPart("apiKey", "335mkacw")
                        .multiPart("transactionCurrency", "AUD")
                        .multiPart("transactionProduct", "Test Product")
                        .multiPart("paymentCardNumber", "5456789012345670")
                        .multiPart("paymentCardExpiry", "1024")
                        .multiPart("paymentCardName", "Bob Jones")
                        .multiPart("customerCountry", "AU")
                        .multiPart("customerState", "NA")
                        .multiPart("customerPostCode", "NA")
                        .multiPart("customerCity", "NA")
                        .multiPart("customerAddress", "123 Street")
                        .multiPart("paymentCardCSC", "123")
                        .post(application_ENDPOINT_PATH);

            } else if (application_ENDPOINT_PATH.equals("/token/") && jsonFileName.equals("Get Card INfo.json")) {
                result = requestSpecification
                        .multiPart("method", "cardInfo")
                        .multiPart("merchantUUID", "64c9a16c84b56")
                        .multiPart("apiKey", "335mkacw")
                        .multiPart("cardID", "KPNZ39774269")
                        .post(application_ENDPOINT_PATH);

            } else if (application_ENDPOINT_PATH.equals("/post/") && jsonFileName.equals("New Request.json")) {
                result = requestSpecification
                        .multiPart("method", "processCard")
                        .multiPart("merchantUUID", "{merchantUUID}")
                        .multiPart("apiKey", "{apiKey}")
                        .multiPart("transactionAmount", "10.00")
                        .multiPart("transactionCurrency", "AUD")
                        .multiPart("transactionProduct", "Inv #3598")
                        .multiPart("customerName", "Tony Stark")
                        .multiPart("customerCountry", "Australia")
                        .multiPart("customerState", "Qld")
                        .multiPart("customerCity", "Brisbane")
                        .multiPart("customerAddress", "345 Ann St")
                        .multiPart("customerPostCode", "4000")
                        .multiPart("paymentCardNumber", "4564710000000004")
                        .multiPart("paymentCardExpiry", "0229")
                        .multiPart("paymentCardName", "Tony Stark")
                        .post(application_ENDPOINT_PATH);
            } else {
                // Normal JSON/raw request for other APIs
            	 String filePath = System.getProperty("user.dir") + "/src/test/resources/Payloads/MerchantwarriorPayloads/"+ jsonFileName;
                 String jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));
                 JSONObject jsonObject = new JSONObject(jsonContent);

                result = requestSpecification
                        .body(jsonObject.toString())
                        .post(application_ENDPOINT_PATH);
            }

            // Always try to parse and log after execution
            try {
                System.out.println("Response: " + result.getBody().asPrettyString());
                // Optional: Force parse to catch JsonPathException inside same try block
                result.jsonPath().toString();
            } catch (Exception parseEx) {
                FailedApiTracker.logFailure(apiNameIdentifier, parseEx.getClass().getSimpleName());
                throw parseEx; // rethrow so test fails normally
            }

        } catch (Exception e) {
            String exceptionName = e.getClass().getSimpleName();
            FailedApiTracker.logFailure(apiNameIdentifier != null ? apiNameIdentifier : application_ENDPOINT_PATH,
                                        exceptionName);
            throw e;
        }
    }
}
