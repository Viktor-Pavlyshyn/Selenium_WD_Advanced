package ua.com.epam.frameworkapi.conditions;

import io.restassured.response.Response;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StatusCodeCondition implements Condition{
    private  int statusCode;

    @Override
    public void check(Response response) {
        response.then().assertThat().statusCode(statusCode);
    }
}
