package com.thinktimetechno.projects.website.Shrido.stepdefinitions;

import java.io.IOException;

import com.thinktimetechno.Shrido.endpoints.MSG91Endpoints;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class MSG91StepDefinitions {

	private MSG91Endpoints msg91;

	public MSG91StepDefinitions(MSG91Endpoints msg91) {
		this.msg91 = msg91;
	}
	
	@Given("The User sets the base URL as {string} for msg91")
	public void the_user_sets_the_base_url_as_for_user_msg91(String baseUrl) {
    	RestAssured.baseURI = baseUrl;
	}
	

	@When("The User sends a POST request for MSG91 with the request body from {string} and captures the response body")
	public void the_user_sends_a_post_request_for_msg91_with_the_request_body_from_and_captures_the_response_body(
			String jsonFile) throws IOException {
		msg91.sendPostRequestWithPayload(jsonFile);

	}

	@Then("The response code for MSG91 should be {string}")
	public void the_response_code_for_msg91_should_be(String statusCode) {
		msg91.verifyResponseStatusValue(msg91.result, Integer.parseInt(statusCode));
	}

	@Then("The response body for MSG91 should contain the following key-value pairs:")
	public void the_response_body_for_msg91_should_contain_the_following_key_value_pairs(DataTable dataTable) {
		msg91.verifyResponseKeyValues(dataTable, msg91.result);
	}



}
