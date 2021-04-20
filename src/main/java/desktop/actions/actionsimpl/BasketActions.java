package desktop.actions.actionsimpl;

import desktop.fragments.BasketTotalsFragment;
import desktop.fragments.CheckoutHeadFragment;

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
