package ua.com.epam.frameworkapi.client;

import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.specification.RequestSpecification;
import lombok.extern.log4j.Log4j;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

@Log4j
public class BaseClient {

    protected RequestSpecification getRequestSpecification(String baseUri){
        log.info("Setup RequestSpecification");
        return given().baseUri(baseUri)
                .relaxedHTTPSValidation()
                .contentType(JSON)
                .redirects()
                .follow(true)
                .filters(new ErrorLoggingFilter(),
                        new RequestLoggingFilter(),
                        new RequestLoggingFilter());
    }
}
