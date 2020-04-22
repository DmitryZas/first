package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;

public class GooglePage extends AbstractPage {
    public static String mapsUrl;

    private final static String URL = "https://google.com";

    public GooglePage() {
        super(URL);
    }

    public void fillSearchForm(String name) {
        driver.findElement(By.name("q")).sendKeys(name);
    }

    public void pressSearchButton() {
        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
    }

    public void openMenu() {
        driver.findElement(By.xpath("//a[@title='Приложения Google']")).click();
    }

    public void selectMenuItem() {
        WebElement ele=driver.findElement(By.xpath("//iframe[contains(@id,'I0')]"));
        driver.switchTo().frame(ele);
        driver.findElement(By.xpath("//*[text()='Карты']")).click();
        //driver.findElement(By.xpath("//*[@id='yDmH0d']/c-wiz/div/div/c-wiz/div/div/ul[1]/li[3]/a")).click();
        //new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='yDmH0d']/c-wiz/div/div/c-wiz/div/div/ul[1]/li[3]/a"))).click();
    }

    public boolean validateSearchResults(String value) {
        return driver.findElements(By.partialLinkText(value)).size() != 0 && driver.findElements(By.partialLinkText(value)).size() != 0;
    }

    public boolean currentUrl () {
        mapsUrl = driver.getCurrentUrl();
        return mapsUrl.contains("/maps");
    }
}
