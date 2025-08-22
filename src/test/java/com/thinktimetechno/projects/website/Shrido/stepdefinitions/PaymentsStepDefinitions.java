package com.thinktimetechno.projects.website.Shrido.stepdefinitions;

import java.io.IOException;

import com.thinktimetechno.Shrido.endpoints.PaymentsEndpoints;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class PaymentsStepDefinitions {

	private PaymentsEndpoints payments;

	public PaymentsStepDefinitions(PaymentsEndpoints payments) {
		this.payments = payments;
	}
	
	@Given("The User sets the base URL as {string} for Payment")
	public void The_User_sets_the_base_URL_as_for_Payment(String baseUrl) {
    	RestAssured.baseURI = baseUrl;
    }

	@When("The User sends a POST request for Payments with the request body from {string} and captures the response body")
	public void the_user_sends_a_post_request_for_payments_with_the_request_body_from_and_captures_the_response_body(
			String jsonFile) throws IOException {
		payments.sendPostRequestWithPayload(jsonFile);

	}

	@Then("The response code for Payments should be {string}")
	public void the_response_code_for_payments_should_be(String statusCode) {
		payments.verifyResponseStatusValue(payments.result, Integer.parseInt(statusCode));
	}

	@Then("The response body for Payments should contain the following key-value pairs:")
	public void the_response_body_for_payments_should_contain_the_following_key_value_pairs(DataTable dataTable) {
		payments.verifyResponseKeyValues(dataTable, payments.result);
	}

}
