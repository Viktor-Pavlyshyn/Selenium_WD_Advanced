package ua.com.epam.frameworkapi.client;

import io.restassured.response.Response;

import java.util.Map;

import static ua.com.epam.utils.DataPropLoader.getBrowserProperty;

public class REASTClient extends BaseClient {

    public <T> Response postMethod(String uri, T body, Map<String, String> headers, Map<String, String> params, Map<String, ?> cookies) {
        return getRequestSpecification(getBrowserProperty("base.url"))
                .body(body != null ? body : "")
                .params(params != null ? params : Map.of())
                .headers(headers != null ? headers : Map.of())
                .cookies(cookies != null ? cookies : Map.of())
                .when()
                .post(uri)
                .then()
                .extract()
                .response();

    }

    public <T> Response postMethod(String uri, T body) {

        return postMethod(uri, body, null, null, null);
    }

    public Response postMethod(String uri) {

        return postMethod(uri, null, null, null, null);
    }
}
