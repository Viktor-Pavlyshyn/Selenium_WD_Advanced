package ua.com.epam.driver.driverlisener;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class HighLighterEventListener extends AbstractWebDriverEventListener {

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='40px solid green'", element);
    }
}
