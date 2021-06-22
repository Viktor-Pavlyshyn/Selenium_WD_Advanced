package ua.com.epam.stepDefs;

import io.cucumber.java.After;

import static ua.com.epam.driver.SingletonDriver.getDriver;

public class Hook {

    @After
    public void tearDown(){
        getDriver().quit();
    }
}
