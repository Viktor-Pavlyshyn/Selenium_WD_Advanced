package desktop.actions.actionsimpl;

import desktop.pages.BasketPage;
import io.cucumber.datatable.DataTable;
import lombok.extern.log4j.Log4j2;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class BasketActions {
    private final BasketPage basketPage = new BasketPage();

    public BasketActions verifyThatTextFromCheckoutOrderSummaryContains(DataTable dataTable){
        String textOrderSummery = basketPage.getBasketTotalsFragment()
                .getTextBasketTotals();
        log.info("Get text from Checkout order summary");

        dataTable.asList()
                .forEach(date -> assertThat(textOrderSummery.contains(date))
                        .as("Order summery does not contains - %s", date)
                        .isTrue()
                );
        log.info("Verify that text from Checkout order summary contains - {}", dataTable);
        return this;
    }

    public BasketActions clickOnButtonCheckout(){
        basketPage.getCheckoutHeadFragment().clickCheckout();

        log.info("Click on button 'Checkout'");
        return this;
    }
}
