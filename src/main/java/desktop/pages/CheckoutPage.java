package desktop.pages;

import abstractClasses.page.AbstractPage;
import desktop.fragments.CheckoutPaymentFragment;
import desktop.fragments.NewCustomerFillInFragment;
import desktop.fragments.OrderSummeryCheckoutFragment;
import lombok.Getter;

import static utils.DataPropLoader.getBrowserProperty;

@Getter
public class CheckoutPage extends AbstractPage {
    private static final String pageUrl = getBrowserProperty("base.url") + "checkout/guest";
    private final NewCustomerFillInFragment newCustomerFillInFragment;
    private final OrderSummeryCheckoutFragment orderSummeryCheckoutFragment;
    private final CheckoutPaymentFragment checkoutPaymentFragment;

    public CheckoutPage() {
        setPageUrl(pageUrl);
        newCustomerFillInFragment = new NewCustomerFillInFragment();
        orderSummeryCheckoutFragment = new OrderSummeryCheckoutFragment();
        checkoutPaymentFragment = new CheckoutPaymentFragment();
    }
}
