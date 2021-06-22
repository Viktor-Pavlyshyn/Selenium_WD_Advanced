package ua.com.epam.desktop.actions.actionsimpl;

import ua.com.epam.desktop.fragments.CheckoutPaymentFragment;
import ua.com.epam.desktop.fragments.NewCustomerFillInFragment;
import ua.com.epam.desktop.fragments.OrderSummeryCheckoutFragment;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckoutBasketActions {
    private final NewCustomerFillInFragment newCustomerFillInFragment = new NewCustomerFillInFragment();
    private final OrderSummeryCheckoutFragment orderSummeryCheckoutFragment = new OrderSummeryCheckoutFragment();
    private final CheckoutPaymentFragment checkoutPaymentFragment = new CheckoutPaymentFragment();

    public void enterEmail(String email){
        newCustomerFillInFragment.enterEmail(email);
    }

    public String getTextFromOrderSummary() {
        return orderSummeryCheckoutFragment.getTextOrderSummary();
    }

    public void fillDeliveryAddressInformation(List<Map<String, String>> information) {
        newCustomerFillInFragment.enterFullName(information.get(0).get("Full name"));
        newCustomerFillInFragment.enterDeliveryCountry(information.get(0).get("Delivery country"));
        newCustomerFillInFragment.clickOnManualEntryDeliveryAddress();
        newCustomerFillInFragment.enterAddressLineOne(information.get(0).get("Address line 1"));
        newCustomerFillInFragment.enterAddressLineTwo(information.get(0).get("Address line 2"));
        newCustomerFillInFragment.enterTownCity(information.get(0).get("Town/City"));
        newCustomerFillInFragment.enterCountyState(information.get(0).get("County/State"));
        newCustomerFillInFragment.enterPostcode(information.get(0).get("Postcode"));
    }

    public void verifyPaymentDisabledContainer() {
        assertThat(checkoutPaymentFragment.getPaymentDisabledContainer().isDisplayed())
        .as("Payment DisabledContainer is not displayed.")
        .isTrue();
    }

    public void pressContinueToPayment() {
        checkoutPaymentFragment.clickOnContinueToPayment();
    }

    public void enterCardDetails(Map<String, String> cardDetails) {
        checkoutPaymentFragment.switchToPaymentIframe();
        checkoutPaymentFragment.selectCardType(cardDetails.get("Card Type"));
        checkoutPaymentFragment.inputNameOnCard(cardDetails.get("Name On Card"));
        checkoutPaymentFragment.inputCardNumber(cardDetails.get("cardNumber"));
        checkoutPaymentFragment.selectExpiryYear(cardDetails.get("Expiry Year"));
        checkoutPaymentFragment.selectExpiryMonth(cardDetails.get("Expiry Month"));
        checkoutPaymentFragment.inputCvv(cardDetails.get("Cvv"));
        checkoutPaymentFragment.switchToDefaultContent();
    }
}
