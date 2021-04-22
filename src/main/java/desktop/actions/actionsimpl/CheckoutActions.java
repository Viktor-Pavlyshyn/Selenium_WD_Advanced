package desktop.actions.actionsimpl;

import desktop.pages.CheckoutPage;
import dto.DeliveryAddressInformation;
import io.cucumber.datatable.DataTable;
import lombok.extern.log4j.Log4j2;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class CheckoutActions {
    private final CheckoutPage checkoutPage = new CheckoutPage();

    public CheckoutActions enterEmail(String email) {
        checkoutPage.getNewCustomerFillInFragment().enterEmail(email);

        log.info("Enter email - {}", email);
        return this;
    }

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

    public CheckoutActions fillDeliveryAddressInformation(DeliveryAddressInformation addressInf) {
        checkoutPage.getNewCustomerFillInFragment().enterFullName(addressInf.getFullName());
        checkoutPage.getNewCustomerFillInFragment().enterDeliveryCountry(addressInf.getDeliveryCountry());
        checkoutPage.getNewCustomerFillInFragment().clickOnManualEntryDeliveryAddress();
        checkoutPage.getNewCustomerFillInFragment().enterAddressLineOne(addressInf.getAddressLineOne());
        checkoutPage.getNewCustomerFillInFragment().enterAddressLineTwo(addressInf.getAddressLineTwo());
        checkoutPage.getNewCustomerFillInFragment().enterTownCity(addressInf.getTownCity());
        checkoutPage.getNewCustomerFillInFragment().enterCountyState(addressInf.getCountyState());
        checkoutPage.getNewCustomerFillInFragment().enterPostcode(addressInf.getPostcode());

        log.info("Fill delivery Address information - {}", addressInf);
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

    public CheckoutActions pressContinueToPayment() {
        checkoutPage.getCheckoutPaymentFragment().clickOnContinueToPayment();

        log.info("Press Continue To Payment");
        return this;
    }

    public CheckoutActions enterCardDetails(Map<String, String> cardDetails) {
        checkoutPage.getCheckoutPaymentFragment().switchToPaymentIframe();
        checkoutPage.getCheckoutPaymentFragment().selectCardType(cardDetails.get("Card Type"));
        checkoutPage.getCheckoutPaymentFragment().inputNameOnCard(cardDetails.get("Name On Card"));
        checkoutPage.getCheckoutPaymentFragment().inputCardNumber(cardDetails.get("cardNumber"));
        checkoutPage.getCheckoutPaymentFragment().selectExpiryYear(cardDetails.get("Expiry Year"));
        checkoutPage.getCheckoutPaymentFragment().selectExpiryMonth(cardDetails.get("Expiry Month"));
        checkoutPage.getCheckoutPaymentFragment().inputCvv(cardDetails.get("Cvv"));
        checkoutPage.getCheckoutPaymentFragment().switchToDefaultContent();

        log.info("Enter Card Details - {}", cardDetails);
        return this;
    }
}
