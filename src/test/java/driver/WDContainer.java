package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WDContainer {
    public final WebDriver driver;
    private final static WDContainer container = new WDContainer();

    private WDContainer() {
        WebDriverManager manager = WebDriverManager.chromedriver();
        manager.setup();
        driver = new ChromeDriver();
    }

    public static WDContainer getContainer() {
        return container;
    }
}
