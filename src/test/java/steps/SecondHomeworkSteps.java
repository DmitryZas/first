package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GooglePage;
import pages.RandomUserPage;


import static org.junit.Assert.assertTrue;

public class SecondHomeworkSteps {

    private GooglePage googlePage = new GooglePage();
    public RandomUserPage userPage = new RandomUserPage();

    @Given("Load the page google.com")
    public void loadGoogle() {
        googlePage.loadPage();
    }

    @When("I search facebook account by search button")
    public void searchInGoogle() {
        userPage.makeRequest();
        googlePage.fillSearchForm(RandomUserPage.responseName + " " + RandomUserPage.responseLastName);
        googlePage.pressSearchButton();
    }

    @When("Open Google menu")
    public void openMenu() {
        googlePage.openMenu();
        googlePage.selectMenuItem();
    }

    @Then("Validate string in search values")
    public void validateSearch() {
        assertTrue(googlePage.validateSearchResults(RandomUserPage.responseName + " " + RandomUserPage.responseLastName + " Profiles | Facebook"));
    }

    @Then("Check that opened page was Google Maps")
    public void validatePage() {
        assertTrue(googlePage.currentUrl());
        googlePage.quit();
    }
}
