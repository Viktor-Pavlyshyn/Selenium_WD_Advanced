package desktop.actions.actionsimpl;

import desktop.pages.BasketPage;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class BasketActions {
    private final BasketPage basketPage = new BasketPage();

    public BasketActions clickOnButtonCheckout(){
        basketPage.getCheckoutHeadFragment().clickCheckout();

        log.info("Click on button 'Checkout'");
        return this;
    }
}
