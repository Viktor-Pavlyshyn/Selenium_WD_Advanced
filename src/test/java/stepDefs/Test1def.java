package stepDefs;

import io.cucumber.java.en.Given;
import lombok.SneakyThrows;


public class Test1def {

    @SneakyThrows
    @Given("steps print text {string}")
    public void iAmAnAnonymousCustomerWithClearCookies(String t) {
        System.out.println(t);
        Thread.sleep(1000);
    }
}
