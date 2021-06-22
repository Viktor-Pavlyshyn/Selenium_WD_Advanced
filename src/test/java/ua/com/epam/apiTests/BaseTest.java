package ua.com.epam.apiTests;

import ua.com.epam.frameworkapi.service.CartService;
import org.openqa.selenium.Cookie;

import static ua.com.epam.driver.SingletonDriver.getDriver;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.is;
import static ua.com.epam.utils.DataPropLoader.getBrowserProperty;

public class BaseTest {

    protected static CartService cartService = new CartService();
    protected static String sessionStorage;

    public static void createCartAndSaveGuidCookie(){
        sessionStorage = cartService.createCart()
                .validateStatusCode(SC_CREATED)
                .getStringFieldByPath("guid");
    }

    public static <T> void addProductToCart(T body){
        cartService.addProductToCart(sessionStorage, body)
                .validateStatusCode(SC_OK)
                .validateJsonSchema("schema/schemaCards.json")
                .validateBodyField("entry.product.baseOptions.selected.code[0]", is("2876350"))
                .validateBodyField("entry.quantity", is(1));

    }

    public static void openWithCookie(){
        getDriver().get(getBrowserProperty("base.url"));
        getDriver().manage().deleteAllCookies();
        getDriver().manage().addCookie(new Cookie("kvn-cart", sessionStorage));
        getDriver().navigate().refresh();
    }
}
