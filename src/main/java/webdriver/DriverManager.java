package webdriver;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

import static webdriver.WebDriverFactory.getDriverFactory;

@Log4j2
public class DriverManager {
    private static WebDriverFactory driverFactory = getDriverFactory();

    private static final ThreadLocal<WebDriver> DRIVER_POOL = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        if (DRIVER_POOL.get() == null) {
            synchronized (DriverManager.class) {
                if (DRIVER_POOL.get() == null) {
                    log.info("Setting WebDriver to DRIVER_POOL.");
                    DRIVER_POOL.set(driverFactory.createDriver());
                }
            }
        }
        log.info("Getting WebDriver from DRIVER_POOL.");
        return DRIVER_POOL.get();
    }

    public static void closeDriver() {
        log.info("Try to close WebDriver.");
        if (DRIVER_POOL.get() != null) {
            DRIVER_POOL.get().quit();
            DRIVER_POOL.remove();
            log.info("WebDriver was closed.");
        }
    }
}