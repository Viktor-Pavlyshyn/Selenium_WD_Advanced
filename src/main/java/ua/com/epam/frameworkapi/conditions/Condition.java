package ua.com.epam.frameworkapi.conditions;

import io.restassured.response.Response;

public interface Condition {
    void check(Response response);
}
