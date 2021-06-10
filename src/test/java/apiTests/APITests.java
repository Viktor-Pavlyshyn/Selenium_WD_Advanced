package apiTests;

import desktop.actions.actionskruidvat.ActionsRepository;
import frameworkapi.model.CartsBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static driver.SingletonDriver.getDriver;

public class APITests extends BaseTest {
    private final ActionsRepository actions = new ActionsRepository();

    @BeforeClass
    public static void setUp() {
        createCartAndSaveGuidCookie();

        addProductToCart(new CartsBuilder().addProduct("2876350").addQuantity(1).build());

        openWithCookie();
    }

    @Test
    public void test() {
        actions.getHomePageActions().acceptAllPopup();

        actions.getHomePageActions().clickOnBasket();

        actions.getBasketActions()
                .verifyThatBasketContainsProductWithName("Kruidvat Sensitive Handzeep Navulling");
    }

    @AfterClass
    public static void tearDown() {
        getDriver().quit();
    }
}
