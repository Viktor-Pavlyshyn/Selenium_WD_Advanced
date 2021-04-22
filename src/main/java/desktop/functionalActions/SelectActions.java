package desktop.functionalActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectActions {
    private static Select select;

    public static void selectByText(WebElement element, String value) {
        select = new Select(element);
        select.selectByVisibleText(value);
    }
}
