package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutHeadFragment extends AbstractFragment {

    @FindBy(xpath = "//div[@class=\"basketHeaderButtons\"]//a[@class=\"checkout-btn btn\"]")
    private WebElement buttonCheckout;

    public CheckoutHeadFragment() {
        setRootElement(buttonCheckout);
    }

    public void clickCheckout(){
        moveToElementAndClick(buttonCheckout);
    }
}
