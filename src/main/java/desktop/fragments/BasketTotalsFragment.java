package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketTotalsFragment extends AbstractFragment {

    @FindBy(xpath = "//div[@class=\"basket-totals\"]")
    private WebElement basketTotals;

    public String getTextBasketTotals(){
        return basketTotals.getText();
    }
}
