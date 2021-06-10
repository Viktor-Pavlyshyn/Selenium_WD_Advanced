package desktop.actions.actionskruidvat;

import desktop.pages.kruidvat.BasketPage;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class BasketActions {
    private final BasketPage basket = new BasketPage();

    public void verifyThatBasketContainsProductWithName(String productName){
        assertThat(basket.getAllProductNames().contains(productName))
                .as("Basket does not contain product - %s.", productName)
                .isTrue();
    }
}
