package webdriver;

import org.openqa.selenium.WebDriver;
import webdriver.driverfactory.ChromeDriverFactory;
import webdriver.driverfactory.FirefoxDriverFactory;
import webdriver.driverfactory.remote.RemoteDriverFactory;

import static org.apache.commons.lang3.StringUtils.equalsIgnoreCase;
import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;
import static utils.DataPropLoader.getBrowserProperty;

public abstract class WebDriverFactory {

    protected abstract WebDriver createDriver();

    public static WebDriverFactory getDriverFactory(String browser) {
        String placeLaunch = System.getProperty("placeLaunch", getBrowserProperty("placeLaunch"));

        if (equalsIgnoreCase(placeLaunch, "localLaunch")) {
            if (equalsIgnoreCase(browser, CHROME)) {
                return new ChromeDriverFactory();
            } else if (equalsIgnoreCase(browser, FIREFOX)) {
                return new FirefoxDriverFactory();
            } else {
                throw new RuntimeException(String.format("%s are not supported.", browser));
            }
        } else if (equalsIgnoreCase(placeLaunch, "remoteLaunch")) {
            return new RemoteDriverFactory(browser);
        } else {
            throw new RuntimeException();
        }
    }

}
