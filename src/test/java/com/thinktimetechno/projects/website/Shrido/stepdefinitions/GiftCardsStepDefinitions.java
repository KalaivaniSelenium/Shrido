package com.thinktimetechno.projects.website.Shrido.stepdefinitions;

import java.io.IOException;

import com.thinktimetechno.Shrido.endpoints.GiftCardsEndpoints;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GiftCardsStepDefinitions {

	private GiftCardsEndpoints giftcards;

	public GiftCardsStepDefinitions(GiftCardsEndpoints giftcards) {
		this.giftcards = giftcards;
	}

	@When("The User sends a POST request for GiftCards with the request body from {string} and captures the response body")
	public void the_user_sends_a_post_request_for_giftcards_with_the_request_body_from_and_captures_the_response_body(
			String jsonFile) throws IOException {
		giftcards.sendPostRequestWithPayload(jsonFile);

	}

	@Then("The response code for GiftCards should be {string}")
	public void the_response_code_for_giftcards_should_be(String statusCode) {
		giftcards.verifyResponseStatusValue(giftcards.result, Integer.parseInt(statusCode));
	}

	@Then("The response body for GiftCards should contain the following key-value pairs:")
	public void the_response_body_for_giftcards_should_contain_the_following_key_value_pairs(DataTable dataTable) {
		giftcards.verifyResponseKeyValues(dataTable, giftcards.result);
	}

	@When("The User sends a GET request for GiftCards API from {string} and captures the response body")
	public void the_user_sends_a_get_request_for_giftcards_from_and_captures_the_response_body(String APIName) {
		giftcards.sendGetRequest(APIName);

	}

}
