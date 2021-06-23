package ua.com.epam.apiTests;

import lombok.extern.log4j.Log4j;
import org.testng.annotations.Listeners;
import ua.com.epam.desktop.actions.actionskruidvat.ActionsRepository;
import ua.com.epam.frameworkapi.model.CartsBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ua.com.epam.listener.ReportPortalListener;

import static ua.com.epam.driver.SingletonDriver.getDriver;

@Log4j
@Listeners(ReportPortalListener.class)
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
        log.trace("TRACE.");
        log.debug("DEBUG.");
        log.info("INFO.");
        log.warn("WARN");
        log.error("ERROR");
        log.fatal("FATAL");

        actions.getHomePageActions().acceptAllPopup();

        actions.getHomePageActions().clickOnBasket();

        actions.getBasketActions()
                .verifyThatBasketContainsProductWithName("Kruidvat Sensitive Handzeep Navullin");
    }

    @AfterClass
    public static void tearDown() {
        getDriver().quit();
        log.info("Close driver.");
    }
}
