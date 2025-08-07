package com.thinktimetechno.projects.website.Shrido.stepdefinitions;

import java.io.IOException;

import com.thinktimetechno.Shrido.endpoints.SubscriptionsEndpoints;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SubscriptionsStepDefinitions {

	private SubscriptionsEndpoints subscriptions;

	public SubscriptionsStepDefinitions(SubscriptionsEndpoints subscriptions) {
		this.subscriptions = subscriptions;
	}


	@When("The User sends a POST request for Subscriptions with the request body from {string} and captures the response body")
	public void the_user_sends_a_post_request_for_subscriptions_with_the_request_body_from_and_captures_the_response_body(
			String jsonFile) throws IOException {
		subscriptions.sendPostRequestWithPayload(jsonFile);

	}

	@Then("The response code for Subscriptions should be {string}")
	public void the_response_code_for_subscriptions_should_be(String statusCode) {
		subscriptions.verifyResponseStatusValue(subscriptions.result, Integer.parseInt(statusCode));
	}

	@Then("The response body for Subscriptions should contain the following key-value pairs:")
	public void the_response_body_for_subscriptions_should_contain_the_following_key_value_pairs(DataTable dataTable) {
		subscriptions.verifyResponseKeyValues(dataTable, subscriptions.result);
	}

	@When("The User sends a GET request for Subscriptions API from {string} and captures the response body")
	public void the_user_sends_a_get_request_for_subscriptions_from_and_captures_the_response_body(String APIName) {
		subscriptions.sendGetRequest(APIName);

	}


	@When("The User sends a PUT request for Subscriptions with the request body from {string} and captures the response body")
	public void the_user_sends_a_put_request_for_subscriptions_with_the_request_body_from_and_captures_the_response_body(
			String jsonFile) throws IOException {
		subscriptions.sendPutRequestWithPayload(jsonFile, "UserPayloads");

	}
}
