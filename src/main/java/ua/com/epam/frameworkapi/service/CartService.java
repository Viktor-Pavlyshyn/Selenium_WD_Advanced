package ua.com.epam.frameworkapi.service;

import lombok.extern.log4j.Log4j;
import ua.com.epam.frameworkapi.AssertableResponse;
import ua.com.epam.frameworkapi.client.REASTClient;

import static ua.com.epam.frameworkapi.config.URI.ADD_PRODUCT_TO_CART;
import static ua.com.epam.frameworkapi.config.URI.CREATE_CART;

@Log4j
public class CartService extends REASTClient{

    public AssertableResponse createCart() {
        return new AssertableResponse(postMethod(CREATE_CART));
    }

    public <T> AssertableResponse addProductToCart (String session, T body) {
        log.info("Add product to cart.");

        return new AssertableResponse(postMethod(String.format(ADD_PRODUCT_TO_CART, session), body));
    }
}