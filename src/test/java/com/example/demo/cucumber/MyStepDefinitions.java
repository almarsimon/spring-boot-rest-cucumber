package com.example.demo.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.MatcherAssert.assertThat;

public class MyStepDefinitions extends SpringIntegrationTestConfig {

    private final TestRestTemplate restTemplate;
    @LocalServerPort
    String port;
    private ResponseEntity<String> stringResponse;

    public MyStepDefinitions(TestRestTemplate testRestTemplate) {
        this.restTemplate = testRestTemplate;
    }

    @When("the client calls the URL {string}")
    public void whenClientCalls(String url) {
        stringResponse = this.restTemplate.getForEntity("http://localhost:" + port + url, String.class);
    }

    @Then("the client receives status code of {int}")
    public void thenStatusCode(int expectedStatusCode) {
        HttpStatusCode httpStatusCode = stringResponse.getStatusCode();
        assertThat("status code is : " + expectedStatusCode, httpStatusCode.value() == expectedStatusCode);
    }

    @And("the client receives a string response of {string}")
    public void thenStringResultIs(String stringResult) {
        Assertions.assertEquals(stringResponse.getBody(), stringResult);
    }

}
