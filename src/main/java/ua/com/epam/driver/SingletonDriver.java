package ua.com.epam.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import ua.com.epam.driver.driverlisener.HighLighterEventListener;

import static ua.com.epam.driver.CapabilitiesHelper.getChromeOptions;

public class SingletonDriver {

    private static EventFiringWebDriver  instance;

    public static WebDriver getDriver() {
        if (instance == null) {
            WebDriverManager.chromedriver().setup();
            WebDriver webDriver = new ChromeDriver(getChromeOptions());
            webDriver.manage().window().maximize();
            instance = new EventFiringWebDriver(webDriver);
            instance.manage().window().maximize();
            instance.register(new HighLighterEventListener());
        }
        return instance;
    }
}
