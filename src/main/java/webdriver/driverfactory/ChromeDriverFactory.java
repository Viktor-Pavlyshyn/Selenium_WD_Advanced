package webdriver.driverfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import webdriver.WebDriverFactory;

public class ChromeDriverFactory extends WebDriverFactory {

    @Override
    protected WebDriver createDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(getChromeOptions());
        driver.manage().window().maximize();
        return driver;
    }

    public ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--test-type");
        chromeOptions.addArguments("--ignore-certificate-errors");
        return chromeOptions;
    }
}
