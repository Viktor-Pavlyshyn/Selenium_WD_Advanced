package desktop.functionalActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectActions {

    public static void selectByText(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }
}
