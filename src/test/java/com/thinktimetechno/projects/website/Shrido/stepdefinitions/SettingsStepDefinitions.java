package com.thinktimetechno.projects.website.Shrido.stepdefinitions;

import java.io.IOException;

import com.thinktimetechno.Shrido.endpoints.SettingsEndpoints;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SettingsStepDefinitions {

	private SettingsEndpoints settings;

	public SettingsStepDefinitions(SettingsEndpoints settings) {
		this.settings = settings;
	}

	@When("The User sends a POST request for Settings with the request body from {string} and captures the response body")
	public void the_user_sends_a_post_request_for_settings_with_the_request_body_from_and_captures_the_response_body(
			String jsonFile) throws IOException {
		settings.sendPostRequestWithPayload(jsonFile);

	}

	@Then("The response code for Settings should be {string}")
	public void the_response_code_for_settings_should_be(String statusCode) {
		settings.verifyResponseStatusValue(settings.result, Integer.parseInt(statusCode));
	}

	@Then("The response body for Settings should contain the following key-value pairs:")
	public void the_response_body_for_settings_should_contain_the_following_key_value_pairs(DataTable dataTable) {
		settings.verifyResponseKeyValues(dataTable, settings.result);
	}

	@When("The User sends a GET request for Settings from {string} and captures the response body")
	public void the_user_sends_a_get_request_for_settings_from_and_captures_the_response_body(String APIName) {
		settings.sendGetRequest(APIName);

	}

	@When("The User sends a PUT request for Settings with the request body from {string} and captures the response body")
	public void the_user_sends_a_put_request_for_settings_with_the_request_body_from_and_captures_the_response_body(
			String jsonFile) throws IOException {
		settings.sendPutRequestWithPayload(jsonFile, "UserPayloads");

	}
}
