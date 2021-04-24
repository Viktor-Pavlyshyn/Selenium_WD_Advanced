package desktop.actions.verificationActions;

import desktop.pages.CheckoutPage;
import io.cucumber.datatable.DataTable;
import lombok.extern.log4j.Log4j2;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class CheckoutActions {
    private final CheckoutPage checkoutPage = new CheckoutPage();

    public CheckoutActions verifyThatCheckoutOrderSummaryContains(DataTable dataTable) {
        String text = checkoutPage.getOrderSummeryCheckoutFragment().getTextOrderSummary();

        dataTable.asList()
                .forEach(date -> assertThat(text.contains(date))
                        .as("Order summery does not contains - {}", date)
                        .isTrue()
                );

        log.info("Verify hat Checkout order summary contains - {}", dataTable);
        return this;
    }

    public CheckoutActions verifyPaymentDisabledContainer() {
        assertThat(checkoutPage.getCheckoutPaymentFragment()
                .getPaymentDisabledContainer().isDisplayed())
                .as("Payment DisabledContainer is not displayed.")
                .isTrue();

        log.info("Verify that Payment DisabledContainer is displayed");
        return this;
    }

    public void verifyCurrentUrl(){
        assertThat(checkoutPage.isPageOpen())
                .as("Wrong current Url.")
                .isTrue();
    }
}
