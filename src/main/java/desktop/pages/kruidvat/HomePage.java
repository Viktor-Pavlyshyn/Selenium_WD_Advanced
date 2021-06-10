package desktop.pages.kruidvat;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.WaitUtils.fWaitUntil;

public class HomePage extends AbstractFragment {

    @FindBy(xpath = "//i[@class=\"icon icon-basket\"]")
    private WebElement basket;

    @FindBy(xpath = "//button[@id=\"onetrust-accept-btn-handler\"]")
    private WebElement popupCookie;

    @FindBy(xpath = "//e2-action-button[@button-label=\"Naar Kruidvat.nl\"]//span[@class=\"button__text \"]")
    private WebElement popupLanguage;

    public void clickOnBasket() {
        fWaitUntil(ExpectedConditions.elementToBeClickable(basket)).click();
    }

    public void acceptAllPopup() {
        try {
            fWaitUntil(ExpectedConditions.elementToBeClickable(popupCookie)).click();
            fWaitUntil(ExpectedConditions.elementToBeClickable(popupLanguage)).click();
        } catch (Exception ignored) {}
    }
}
