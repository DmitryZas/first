package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.assertj.core.api.SoftAssertions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CucumberStepsDefs {
    private final static String URL = "https://randomuser.me/api/";
    private String responseName;
    private String responseLastName;
    private List<String> seedValues = new ArrayList<>();

    public void makeRequest(HashMap<String, List<String>> params) {
        Response response = RestAssured.given().queryParams(params).get(URL);
        responseName = response.jsonPath().getString("results[0].name.first");
        responseLastName = response.jsonPath().getString("results[0].name.last");
        System.out.println(responseName + " " + responseLastName);
    }

    @Given("A rest api request with parameters: {string}")
    public HashMap<String, List<String>> requestParams (String seedValue) {
        seedValues.add(seedValue);
        HashMap<String, List<String>> map = new HashMap<>();
        map.put("seed", seedValues);
        return map;
    }

    @When("I make request with specified seed")
    public void makeRequestWithSpecifiedSeed() {
        makeRequest(requestParams(seedValues.get(0)));
    }

    @Then("I receive response with name: {string}")
    public void checkNameFromResponse(String name) {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(responseName).isEqualTo(name);
        softAssertions.assertAll();
    }

    @And("I receive response with last name: {string}")
    public void checkLastNameFromResponse(String secondName) {

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(responseLastName).isEqualTo(secondName);
        softAssertions.assertAll();
    }
}
