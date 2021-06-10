package frameworkapi.client;

import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;

import java.util.Map;

import static utils.DataPropLoader.getBrowserProperty;

@Log4j2
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
        log.info("Perform POST request to: '{}' with body: '{}'.", uri, body);

        return postMethod(uri, body, null, null, null);
    }

    public Response postMethod(String uri) {
        log.info("Perform POST request to: '{}'.", uri);

        return postMethod(uri, null, null, null, null);
    }
}
