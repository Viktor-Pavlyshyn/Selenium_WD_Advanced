package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;

import static webdriver.DriverManager.*;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = "stepDefs")
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser){
            initDriver(browser);
    }

    @AfterMethod
    public void tearDown() {
        closeDriver();
    }
}
