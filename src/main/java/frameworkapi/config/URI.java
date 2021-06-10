package frameworkapi.config;

public interface URI {

    String CREATE_CART = "/api/v2/kvn/users/anonymous/carts";
    String ADD_PRODUCT_TO_CART = "/api/v2/kvn/users/anonymous/carts/%s/entries?lang=nl";
}
