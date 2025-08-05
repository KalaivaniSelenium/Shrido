package com.thinktimetechno.projects.website.Shrido.stepdefinitions;

import java.io.IOException;

import com.thinktimetechno.Warehouse.endpoints.TripEndpoints;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TripStepDefinitions {

	private TripEndpoints trip;

	public TripStepDefinitions(TripEndpoints trip) {
		this.trip = trip;
	}

	@When("The User sends a POST request for Trip with the request body from {string} and captures the response body")
	public void the_user_sends_a_post_request_for_trip_with_the_request_body_from_and_captures_the_response_body(
			String jsonFile) throws IOException {
		trip.sendPostRequestWithPayload(jsonFile);

	}

	@Then("The response code for Trip should be {string}")
	public void the_response_code_for_trip_should_be(String statusCode) {
		trip.verifyResponseStatusValue(trip.result, Integer.parseInt(statusCode));
	}

	@Then("The response body for Trip should contain the following key-value pairs:")
	public void the_response_body_for_trip_should_contain_the_following_key_value_pairs(DataTable dataTable) {
		trip.verifyResponseKeyValues(dataTable, trip.result);
	}

	@When("The User sends a GET request for Trip from {string} and captures the response body")
	public void the_user_sends_a_get_request_for_trip_from_and_captures_the_response_body(String jsonFile)
			throws Exception {
		trip.sendGetRequestWithJson(jsonFile);

	}

	@When("The User sends a GET request for Trip API from {string} and captures the response body")
	public void the_user_sends_a_get_request_for_trips_from_and_captures_the_response_body(String APIName) {
		trip.sendGetRequest(APIName);

	}

	@When("The User sends a DELETE request for Trip from {string} and captures the response body")
	public void the_user_sends_a_delete_request_for_trip_from_and_captures_the_response_body(String APIName) {
		trip.applicationSalesDeletePayload(APIName);

	}

	@When("The User sends a PUT request for Trip with the request body from {string} and captures the response body")
	public void the_user_sends_a_put_request_for_trip_with_the_request_body_from_and_captures_the_response_body(
			String jsonFile) throws IOException {
		trip.sendPutRequestWithPayload(jsonFile, "UserPayloads");

	}

	@When("The User sends a PATCH request for Trip with the request body from {string} and captures the response body")
	public void the_user_sends_a_patch_request_for_trip_with_the_request_body_from_and_captures_the_response_body(
			String jsonFile) throws IOException {

	}

}
