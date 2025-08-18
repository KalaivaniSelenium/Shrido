package com.thinktimetechno.projects.website.Shrido.stepdefinitions;

import java.io.IOException;

import com.thinktimetechno.Shrido.endpoints.RequestEndpoints;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class RequestStepDefinitions {

	private RequestEndpoints request;

	public RequestStepDefinitions(RequestEndpoints request) {
		this.request = request;
	}
	
	@Given("The User sets the base URL as {string} for Request")
	public void The_User_sets_the_base_URL_as_for_Request(String baseUrl) {
    	RestAssured.baseURI = baseUrl;
    }

	@When("The User sends a POST request for Request API with the request body from {string} and captures the response body")
	public void the_user_sends_a_post_request_for_request_with_the_request_body_from_and_captures_the_response_body(
			String jsonFile) throws IOException {
		request.sendPostRequestWithPayload(jsonFile);

	}

	@Then("The response code for Request API should be {string}")
	public void the_response_code_for_request_should_be(String statusCode) {
		request.verifyResponseStatusValue(request.result, Integer.parseInt(statusCode));
	}

	@Then("The response body for Request API should contain the following key-value pairs:")
	public void the_response_body_for_request_should_contain_the_following_key_value_pairs(DataTable dataTable) {
		request.verifyResponseKeyValues(dataTable, request.result);
	}

}
