package ua.com.epam.desktop.actions.actionsimpl;

import ua.com.epam.desktop.fragments.BasketTotalsFragment;
import ua.com.epam.desktop.fragments.CheckoutHeadFragment;

public class BasketActions {
    private final BasketTotalsFragment basketTotalsFragment = new BasketTotalsFragment();
    private final CheckoutHeadFragment checkoutHeadFragment = new CheckoutHeadFragment();

    public String getTextFromCheckoutOrderSummary(){
        return  basketTotalsFragment.getTextBasketTotals();
    }

    public void clickOnButtonCheckout(){
        checkoutHeadFragment.clickCheckout();
    }
}
