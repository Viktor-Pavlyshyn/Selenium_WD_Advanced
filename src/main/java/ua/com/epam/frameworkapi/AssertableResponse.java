package ua.com.epam.frameworkapi;

import ua.com.epam.frameworkapi.conditions.Condition;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import org.hamcrest.Matcher;

import static ua.com.epam.frameworkapi.conditions.Conditions.bodyField;
import static ua.com.epam.frameworkapi.conditions.Conditions.statusCode;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@AllArgsConstructor
public class AssertableResponse {
    private Response response;

    public AssertableResponse shouldHave(Condition condition) {
        condition.check(response);
        return this;
    }

    public AssertableResponse shouldHave(Condition... conditions) {
        for (Condition condition : conditions) {
            condition.check(response);
        }
        return this;
    }

    public Response getResponse() {
        return response;
    }

    public <T> T responseAs(Class<T> clazz) {
        return response.as(clazz);
    }

    public String getStringFieldByPath(String path) {
        return response.getBody().jsonPath().getString(path);
    }

    public AssertableResponse validateStatusCode(int statusCode) {
        shouldHave(statusCode(statusCode));
        return this;
    }

    public AssertableResponse validateBodyField(String jsonPath, Matcher matcher) {
        return shouldHave(bodyField(jsonPath, matcher));
    }

    public AssertableResponse validateJsonSchema(String jsonSchema) {
        getResponse()
                .then()
                .log()
                .body()
                .body(matchesJsonSchemaInClasspath(jsonSchema));
        return this;
    }
}
