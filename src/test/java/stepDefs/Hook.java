package stepDefs;

import io.cucumber.java.After;

import static webdriver.DriverManager.closeDriver;

public class Hook {

    @After
    public void tearDown() {
        closeDriver();
    }
}
