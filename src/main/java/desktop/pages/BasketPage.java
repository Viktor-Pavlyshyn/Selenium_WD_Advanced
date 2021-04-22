package desktop.pages;

import abstractClasses.page.AbstractPage;
import desktop.fragments.BasketTotalsFragment;
import desktop.fragments.CheckoutHeadFragment;
import lombok.Getter;

import static utils.DataPropLoader.getBrowserProperty;

@Getter
public class BasketPage extends AbstractPage {
    private static final String pageUrl = getBrowserProperty("base.url") + "basket";
    private final BasketTotalsFragment basketTotalsFragment;
    private final CheckoutHeadFragment checkoutHeadFragment;

    public BasketPage() {
        setPageUrl(pageUrl);
        basketTotalsFragment = new BasketTotalsFragment();
        checkoutHeadFragment = new CheckoutHeadFragment();
    }
}