package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static desktop.functionalActions.BuilderActions.moveToElementAndClick;

public class CheckoutHeadFragment extends AbstractFragment {

    @FindBy(xpath = "//div[@class=\"basketHeaderButtons\"]//a[@class=\"checkout-btn btn\"]")
    private WebElement buttonCheckout;

    public void clickCheckout(){
        moveToElementAndClick(buttonCheckout);
    }
}
