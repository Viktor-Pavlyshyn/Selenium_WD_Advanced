package frameworkapi.service;

import frameworkapi.AssertableResponse;
import frameworkapi.client.REASTClient;
import lombok.extern.log4j.Log4j2;

import static frameworkapi.config.URI.ADD_PRODUCT_TO_CART;
import static frameworkapi.config.URI.CREATE_CART;

@Log4j2
public class CartService extends REASTClient{

    public AssertableResponse createCart() {
        return new AssertableResponse(postMethod(CREATE_CART));
    }

    public <T> AssertableResponse addProductToCart (String session, T body) {
        return new AssertableResponse(postMethod(String.format(ADD_PRODUCT_TO_CART, session), body));
    }
}