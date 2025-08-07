package com.thinktimetechno.projects.website.Shrido.stepdefinitions;

import java.io.IOException;

import com.thinktimetechno.Shrido.endpoints.UserCardsEndpoints;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class UserCardsStepDefinfitions {

	private UserCardsEndpoints userCards;

	public UserCardsStepDefinfitions(UserCardsEndpoints userCards) {
		this.userCards = userCards;
	}


	@Given("The User sets the base URL as {string} for User Cards")
	public void the_user_sets_the_base_url_as_for_user_cards(String baseUrl) {
		RestAssured.baseURI = baseUrl;
	}
	@When("The User sends a GET request for User Cards with the endpoint {string} and captures the response body")
	public void the_user_sends_a_get_request_for_user_cards_with_the_endpoint_and_captures_the_response_body(String APIName) {
		userCards.sendGetRequest(APIName);
	}
	@When("The User sends a POST request for User Cards with the request body from {string} and captures the response body")
	public void the_user_sends_a_post_request_for_user_cards_with_the_request_body_from_and_captures_the_response_body(String jsonFileName) throws IOException {
	    userCards.sendPostRequestWithPayload(jsonFileName);
	}
	@Then("The response code for User Cards should be {string}")
	public void the_response_code_for_user_cards_should_be(String statusCode) {
	    userCards.verifyResponseStatusValue(userCards.result, Integer.parseInt(statusCode));
	}
	@Then("The response body for User Cards should contain the following key-value pairs:")
	public void the_response_body_for_user_cards_should_contain_the_following_key_value_pairs(io.cucumber.datatable.DataTable dataTable) {
		userCards.verifyResponseKeyValues(dataTable, userCards.result);
	}

}