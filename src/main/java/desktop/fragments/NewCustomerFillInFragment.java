package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static desktop.functionalActions.SelectActions.selectByText;

public class NewCustomerFillInFragment extends AbstractFragment {

    @FindBy(xpath = "//input[@name=\"emailAddress\"]")
    private WebElement inputEmail;
    @FindBy(xpath = "//input[@name=\"delivery-fullName\"]")
    private WebElement inputFullName;
    @FindBy(xpath = "//button[@id=\"manualEntryDeliveryAddress\"]")
    private WebElement manualEntryDeliveryAddress;
    @FindBy(xpath = "//select[@id=\"deliveryCountryDropdown\"]")
    private WebElement inputDeliveryCountry;
    @FindBy(xpath = "//input[@name=\"delivery-addressLine1\"]")
    private WebElement inputAddressLineOne;
    @FindBy(xpath = "//input[@name=\"delivery-addressLine2\"]")
    private WebElement inputAddressLineTwo;
    @FindBy(xpath = "//input[@name=\"delivery-city\"]")
    private WebElement inputTownCity;
    @FindBy(xpath = "//input[@name=\"delivery-county\"]")
    private WebElement inputCountyStates;
    @FindBy(xpath = "//input[@name=\"delivery-postCode\"]")
    private WebElement inputPostcode;

    public void enterEmail(String email){
        inputEmail.sendKeys(email);
    }

    public void enterFullName(String fullName) {
        inputFullName.sendKeys(fullName);
    }

    public void enterDeliveryCountry(String deliveryCountry) {
        selectByText(inputDeliveryCountry, deliveryCountry);
    }

    public void enterAddressLineOne(String addressLineOne) {
        inputAddressLineOne.sendKeys(addressLineOne);
    }

    public void enterAddressLineTwo(String addressLineTwo) {
        inputAddressLineTwo.sendKeys(addressLineTwo);
    }

    public void enterTownCity(String townCity) {
        inputTownCity.sendKeys(townCity);
    }

    public void enterCountyState(String countyStates) {
        inputCountyStates.sendKeys(countyStates);
    }

    public void enterPostcode(String postcode){
        inputPostcode.sendKeys(postcode);
    }

    public void clickOnManualEntryDeliveryAddress() {
        manualEntryDeliveryAddress.click();
    }
}