package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderSummeryCheckoutFragment extends AbstractFragment {

    @FindBy(xpath = "//div[@class=\"sidebar right\"]")
    private WebElement orderSummery;

    public String getTextOrderSummary(){
        return orderSummery.getText();
    }
}
