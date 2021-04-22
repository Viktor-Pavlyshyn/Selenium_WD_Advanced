package webdriver.driverfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import webdriver.WebDriverFactory;

import static webdriver.CapabilitiesHelper.getChromeOptions;

public class ChromeDriverFactory extends WebDriverFactory {

    @Override
    protected WebDriver createDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(getChromeOptions());
        driver.manage().window().maximize();
        return driver;
    }
}
