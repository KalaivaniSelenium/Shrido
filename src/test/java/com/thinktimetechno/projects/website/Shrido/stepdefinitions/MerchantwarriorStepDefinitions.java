package com.thinktimetechno.projects.website.Shrido.stepdefinitions;

import java.io.IOException;

import com.thinktimetechno.Shrido.endpoints.MerchantwarriorEndpoints;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class MerchantwarriorStepDefinitions {

	private MerchantwarriorEndpoints merchantwarrior;

	public MerchantwarriorStepDefinitions(MerchantwarriorEndpoints merchantwarrior) {
		this.merchantwarrior = merchantwarrior;
	}
	
	@Given("The User sets the base URL as {string} for Merchant")
	public void the_user_sets_the_base_url_as_for_Merchant(String baseUrl) {
    	RestAssured.baseURI = baseUrl;
	}

	@When("The User sends a POST request for Merchantwarrior with the request body from {string} and captures the response body")
	public void the_user_sends_a_post_request_for_merchantwarrior_with_the_request_body_from_and_captures_the_response_body(
			String jsonFile) throws IOException {
		merchantwarrior.sendPostRequestWithPayload(jsonFile);

	}

	@Then("The response code for Merchantwarrior should be {string}")
	public void the_response_code_for_merchantwarrior_should_be(String statusCode) {
		merchantwarrior.verifyResponseStatusValue(merchantwarrior.result, Integer.parseInt(statusCode));
	}

	@Then("The response body for Merchantwarrior should contain the following key-value pairs:")
	public void the_response_body_for_merchantwarrior_should_contain_the_following_key_value_pairs(DataTable dataTable) {
		merchantwarrior.verifyResponseKeyValues(dataTable, merchantwarrior.result);
	}



}
