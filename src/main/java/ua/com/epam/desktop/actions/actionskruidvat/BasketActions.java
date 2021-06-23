package ua.com.epam.desktop.actions.actionskruidvat;

import lombok.extern.log4j.Log4j;
import ua.com.epam.desktop.pages.kruidvat.BasketPage;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@Log4j
public class BasketActions {
    private final BasketPage basket = new BasketPage();

    public void verifyThatBasketContainsProductWithName(String productName){
        log.info(String.format("Verify that basket contains product with name - %s", productName));
        assertThat(basket.getAllProductNames().contains(productName))
                .as("Basket does not contain product - %s.", productName)
                .isTrue();
    }
}
