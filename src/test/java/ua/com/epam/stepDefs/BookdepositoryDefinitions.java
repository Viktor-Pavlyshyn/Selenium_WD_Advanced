package ua.com.epam.stepDefs;

import ua.com.epam.desktop.actions.ActionsRepository;
import ua.com.epam.desktop.pages.HomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.Map;

import static ua.com.epam.driver.SingletonDriver.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class BookdepositoryDefinitions {
    private final ActionsRepository actions = new ActionsRepository();

    @Given("I am an anonymous customer with clear cookies")
    public void iAmAnAnonymousCustomerWithClearCookies() {
        getDriver().manage().deleteAllCookies();
    }

    @And("I open the {string}")
    public void iOpenThe(String value) {
        final HomePage homePage = new HomePage();

        getDriver().get(homePage.getPageUrl());
        homePage.verifyIsPageUrlCorrect();
        log.info("{} is opened.", value);
    }

    @And("I search for {string}")
    public void iSearchFor(String value) {
        actions.getSearchActions().inputTextAndPressEnter(value);
    }

    @And("I am redirected to a {string}")
    public void iAmRedirectedToA(String value) {

        log.info("{} is opened.", value);
    }

    @And("Search results contain the following products")
    public void searchResultsContainTheFollowingProducts(List<String> searchParam) {
        actions.getResultSearchActions()
                .verifyIfResultTitleContainsValue(searchParam);

    }

    @And("I apply the following search filters")
    public void iApplyTheFollowingSearchFilters(Map<String,String> filterParam) {
        actions.getFilterActions()
                .selectAllOptionAndApply(filterParam);
    }

    @And("Search results contain only the following products")
    public void searchResultsContainOnlyTheFollowingProducts(List<String> searchParam) {
        actions.getResultSearchActions()
                .verifyIfResultTitleContainsValue(searchParam);
    }

    @And("I click {string} button for product with name {string}")
    public void iClickAddToBasketButtonForProductWithName(String value, String bookName) {
        actions.getResultSearchActions()
                .clickOnAddToBasketByBookName(bookName);

        log.info("Click {} button for product with name {}", value, bookName);
    }

    @And("I select {string} in basket pop-up")
    public void iSelectBasketCheckoutInBasketPopUp(String value) {
        actions.getResultSearchActions().clickOnBasketCheckOutButton();
        log.info("Select {} in basket pop-up", value);
    }

    @And("Basket order summary is as following:")
    public void basketOrderSummaryIsAsFollowing(DataTable dataTable) {
        String textOrderSummery = actions.getBasketActions()
                .getTextFromCheckoutOrderSummary();

        dataTable.asList()
                .forEach(date -> assertThat(textOrderSummery.contains(date))
                        .as("Order summery does not contains - {}", date)
                        .isTrue()
                );
    }

    @And("I click {string} button on {string} page")
    public void iClickCheckoutButtonOnBasketPage(String button, String page) {
        actions.getBasketActions().clickOnButtonCheckout();

        log.info("click {} button on {} page", button, page);
    }

    @And("I checkout as a new customer with email {string}")
    public void iCheckoutAsANewCustomerWithEmail(String email) {
        actions.getCheckoutBasketActions().enterEmail(email);
    }

    @And("Checkout order summary is as following:")
    public void checkoutOrderSummaryIsAsFollowing(DataTable dataTable) {
        String textOrderSummery = actions.getCheckoutBasketActions()
                .getTextFromOrderSummary();

        dataTable.asList()
                .forEach(date -> assertThat(textOrderSummery.contains(date))
                        .as("Order summery does not contains - {}", date)
                        .isTrue()
                );
    }

    @And("I fill delivery address information manually:")
    public void iFillDeliveryAddressInformationManually(DataTable dataTable) {
        actions.getCheckoutBasketActions()
                .fillDeliveryAddressInformation(dataTable.asMaps());
    }

    @And("{string} section is disabled for editing")
    public void paymentSectionIsDisabledForEditing(String value) {
        actions.getCheckoutBasketActions().verifyPaymentDisabledContainer();

        log.info("{} section is disabled for editing", value);
    }

    @When("I press {string} button on checkout")
    public void iPressContinueToPaymentButtonOnCheckout(String value) {
        actions.getCheckoutBasketActions().pressContinueToPayment();

        log.info("Press {} button on checkout", value);
    }

    @And("{string} and {string} sections are disabled for editing")
    public void deliveryAddressAndBillingAddressSectionsAreDisabledForEditing(String value, String value2) {
//        actions.getCheckoutBasketActions().
        log.info("{} and {} sections are disabled for editing", value, value2);
    }

    @And("I enter my card details")
    public void iEnterMyCardDetails(DataTable dataTable) {
        actions.getCheckoutBasketActions()
                .enterCardDetails(dataTable.asMap(String.class, String.class));
    }
}