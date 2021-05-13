package webdriver.driverfactory.remote;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import webdriver.WebDriverFactory;

import java.net.URL;

import static utils.DataPropLoader.getNodeCapabilityProperty;

public class RemoteDriverFactory extends WebDriverFactory {
    private String browser;

    public RemoteDriverFactory(String browser) {
        this.browser = browser;
    }

    @SneakyThrows
    @Override
    protected WebDriver createDriver() {
        WebDriver driver = new RemoteWebDriver(new URL(getNodeCapabilityProperty("node.url") + "/wd/hub"), getCapabilities());
        driver.manage().window().maximize();
        return driver;
    }

    private DesiredCapabilities getCapabilities() {
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability("platform", getNodeCapabilityProperty("LINUX"));
        capability.setCapability("browserName", browser);
        return capability;
    }
}