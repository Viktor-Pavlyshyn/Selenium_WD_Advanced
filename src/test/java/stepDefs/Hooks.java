package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static webdriver.DriverManager.closeDriver;
import static webdriver.DriverManager.initDriver;

public class Hooks {

    @Before
    public void setup(){
        initDriver(System.getProperty("browser", "chrome"));
    }

    @After
    public void tearDown() {
        closeDriver();
    }
}