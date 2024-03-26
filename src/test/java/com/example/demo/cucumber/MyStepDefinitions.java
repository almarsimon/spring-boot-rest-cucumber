package com.example.demo.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.MatcherAssert.assertThat;

public class MyStepDefinitions extends SpringIntegrationTestConfig {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    String port;
    private ResponseEntity<String> response;

    @When("the client calls {string}")
    public void whenClientCalls(String url) {
        response  = this.restTemplate.getForEntity("http://localhost:" + port + url, String.class);
    }

    @Then("the client receives status code of {int}")
    public void thenStatusCode(int expectedStatusCode) {
        HttpStatusCode httpStatusCode = response.getStatusCode();
        System.out.println("Status code: " + httpStatusCode.value());
        assertThat("status code is : " + expectedStatusCode,
                httpStatusCode.value() == expectedStatusCode);
    }

    @And("the client receives a string response of {string}")
    public void thenStringResultIs(String stringResult) {
        Assertions.assertEquals(response.getBody(), stringResult);
    }

}
