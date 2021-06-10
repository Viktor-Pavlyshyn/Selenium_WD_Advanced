package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.WaitUtils.fWaitUntil;

public class FilterFragment extends AbstractFragment {

    @FindBy(xpath = "//div[@class=\"sidebar-section search-filter\"]")
    private WebElement titleSearchFilter;
    @FindBy(xpath = "//select[@name=\"price\"]")
    private WebElement priceRange;
    @FindBy(xpath = "//select[@name=\"availability\"]")
    private WebElement availability;
    @FindBy(xpath = "//select[@name=\"searchLang\"]")
    private WebElement language;
    @FindBy(xpath = "//select[@name=\"format\"]")
    private WebElement format;
    @FindBy(xpath = "//button[@class=\"btn btn-primary\"][parent::div[@class=\"form-group padded-btn-wrap\"]]")
    private WebElement buttonRefineResult;
    @FindBy(xpath = "//div[@class=\"corner-content\"]//i[@class=\"icon-close\"]")
    private WebElement closeButtonCornerContent;

    public FilterFragment() {
        setRootElement(titleSearchFilter);
    }

    public void selectPrice(String text) {
        selectByText(priceRange, text);
    }

    public void selectAvailability(String text) {
        selectByText(availability, text);
    }

    public void selectLanguage(String text) {
        selectByText(language, text);
    }

    public void selectFormat(String text) {
        selectByText(format, text);
    }

    public void clickRefineResult() {
        closeButtonCornerContent.click();
       fWaitUntil(ExpectedConditions.elementToBeClickable(buttonRefineResult)).click();
    }
}
