package com.thinktimetechno.projects.website.Shrido.stepdefinitions;

import java.io.IOException;

import com.thinktimetechno.Shrido.endpoints.FeedBackEndpoints;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FeedBackStepDefinitions {

	private  FeedBackEndpoints feedback;

	public FeedBackStepDefinitions( FeedBackEndpoints feedback) {
		this.feedback = feedback;
	}

	@When("The User sends a POST request for FeedBack with the request body from {string} and captures the response body")
	public void the_user_sends_a_post_request_for_feedback_with_the_request_body_from_and_captures_the_response_body(
			String jsonFile) throws IOException {
		feedback.sendPostRequestWithPayload(jsonFile);

	}

	@Then("The response code for FeedBack should be {string}")
	public void the_response_code_for_feedback_should_be(String statusCode) {
		feedback.verifyResponseStatusValue(feedback.result, Integer.parseInt(statusCode));
	}

	@Then("The response body for FeedBack should contain the following key-value pairs:")
	public void the_response_body_for_feedback_should_contain_the_following_key_value_pairs(DataTable dataTable) {
		feedback.verifyResponseKeyValues(dataTable, feedback.result);
	}



}
