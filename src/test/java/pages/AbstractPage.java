package pages;


import driver.WDContainer;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    private final String pageUrl;

    protected WebDriver driver = WDContainer.getContainer().driver;

    public AbstractPage(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public void loadPage() {
        driver.get(pageUrl);
    }

    public void quit() {
        driver.quit();
    }

}
