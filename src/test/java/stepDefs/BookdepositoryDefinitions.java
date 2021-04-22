package stepDefs;

import desktop.actions.ActionsRepository;
import desktop.pages.BasketPage;
import desktop.pages.HomePage;
import desktop.pages.SearchResultPage;
import dto.DeliveryAddressInformation;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static webdriver.DriverManager.getDriver;

public class BookdepositoryDefinitions {
    private final ActionsRepository actions = new ActionsRepository();

    @Given("I am an anonymous customer with clear cookies")
    public void iAmAnAnonymousCustomerWithClearCookies() {
        getDriver().manage().deleteAllCookies();
    }

    @And("I open the \"Initial home page\"")
    public void iOpenThe() {
        HomePage homePage = new HomePage();
        homePage.checkUrl();

        getDriver().get(homePage.getPageUrl());
    }

    @And("I search for {string}")
    public void iSearchFor(String value) {
        actions.getHomeActions().inputTextAndPressEnter(value);
    }

    @And("I am redirected to a Search page")
    public void iAmRedirectedToASearchPage() {
        new SearchResultPage().checkUrl();
    }

    @And("Search results contain the following products")
    public void searchResultsContainTheFollowingProducts(List<String> searchParam) {
        actions.getResultSearchActions()
                .verifyThatResultContainsValue(searchParam);
    }

    @And("I apply the following search filters")
    public void iApplyTheFollowingSearchFilters(Map<String, String> filterParam) {
        actions.getResultSearchActions()
                .selectAllOptionAndApply(filterParam);
    }

    @And("Search results contain only the following products")
    public void searchResultsContainOnlyTheFollowingProducts(List<String> searchParam) {
        actions.getResultSearchActions()
                .verifyThatResultContainsValue(searchParam);
    }

    @And("I click 'Add to basket' button for product with name {string}")
    public void iClickAddToBasketButtonForProductWithName(String bookName) {
        actions.getResultSearchActions()
                .clickOnAddToBasketByBookName(bookName);
    }

    @And("I select {string} in basket pop-up")
    public void iSelectBasketCheckoutInBasketPopUp(String value) {
        actions.getResultSearchActions()
                .clickOnBasketCheckOutButton();
    }

    @And("I am redirected to a Basket page")
    public void iAmRedirectedToABasketPage() {
        new BasketPage().checkUrl();
    }

    @And("Basket order summary is as following:")
    public void basketOrderSummaryIsAsFollowing(DataTable dataTable) {
        actions.getBasketActions()
                .verifyThatTextFromCheckoutOrderSummaryContains(dataTable);
    }

    @And("I click 'Checkout' button on 'Basket' page")
    public void iClickCheckoutButtonOnBasketPage() {
        actions.getBasketActions()
                .clickOnButtonCheckout();
    }


    @And("I checkout as a new customer with email {string}")
    public void iCheckoutAsANewCustomerWithEmail(String email) {
        actions.getCheckoutActions().enterEmail(email);
    }

    @And("Checkout order summary is as following:")
    public void checkoutOrderSummaryIsAsFollowing(DataTable dataTable) {
        actions.getCheckoutActions()
                .verifyThatCheckoutOrderSummaryContains(dataTable);
    }

    @And("I fill delivery address information manually:")
    public void iFillDeliveryAddressInformationManually(DeliveryAddressInformation addressInf) {
        actions.getCheckoutActions()
                .fillDeliveryAddressInformation(addressInf);
    }

    @And("'Payment' section is disabled for editing")
    public void paymentSectionIsDisabledForEditing() {
        actions.getCheckoutActions()
                .verifyPaymentDisabledContainer();
    }

    @When("I press 'Continue to payment' button on checkout")
    public void iPressContinueToPaymentButtonOnCheckout() {
        actions.getCheckoutActions()
                .pressContinueToPayment();
    }

    @And("'Delivery Address' and 'Billing Address' sections are disabled for editing")
    public void deliveryAddressAndBillingAddressSectionsAreDisabledForEditing() {
        //can't check
    }

    @And("I enter my card details")
    public void iEnterMyCardDetails(DataTable dataTable) {
        actions.getCheckoutActions()
                .enterCardDetails(dataTable.asMap(String.class, String.class));
    }
}