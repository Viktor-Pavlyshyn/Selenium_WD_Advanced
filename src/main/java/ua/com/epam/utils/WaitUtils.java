package ua.com.epam.utils;



import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static ua.com.epam.driver.SingletonDriver.getDriver;
import static ua.com.epam.utils.DataPropLoader.getBrowserProperty;

public class WaitUtils {

    public static WebElement fWaitUntil(ExpectedCondition<WebElement> condition) {
        return new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(Long.parseLong(getBrowserProperty("wait.timeout"))))
                .pollingEvery(Duration.ofSeconds(Long.parseLong(getBrowserProperty("wait.polling.every.time"))))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class).until(condition);
    }
}