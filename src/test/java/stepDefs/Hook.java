package stepDefs;

import io.cucumber.java.After;

import static driver.SingletonDriver.getDriver;

public class Hook {

    @After
    public void tearDown(){
        getDriver().quit();
    }
}
