package ua.com.epam.utils;

import org.openqa.selenium.support.ui.WebDriverWait;

import static ua.com.epam.driver.SingletonDriver.getDriver;

public class WebDriverWaiter {

    protected WebDriverWait wait;

    public WebDriverWaiter() {
        wait = new WebDriverWait(getDriver(), 5);
    }
}
