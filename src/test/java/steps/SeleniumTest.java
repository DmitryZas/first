package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;


public class SeleniumTest {
private WebDriver driver;

    @Given("Load page google.com")
    public void loadGoogle() {
        WebDriverManager manager = WebDriverManager.chromedriver();
        manager.setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://www.google.com/");
    }

    @When("I search for {string}")
    public void searchInGoogle(String value) {
        driver.findElement(By.name("q")).sendKeys(value);
        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
        /*WebElement element = driver.findElement(By.name("btnK"));
        element.click();*/
    }

    @Then("I see {string} in search results")
    public void validateSearch(String value) {
        List<WebElement> searchHeaders = driver.findElements(By.xpath("//h3"));
        assertFalse(searchHeaders.isEmpty());
        System.out.println(searchHeaders.get(0).getText());
        System.out.println(value);
        assertThat(searchHeaders.get(0).getText(), is(value));
        driver.quit();
    }
}
