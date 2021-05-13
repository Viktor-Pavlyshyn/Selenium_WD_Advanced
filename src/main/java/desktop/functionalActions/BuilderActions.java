package desktop.functionalActions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static webdriver.DriverManager.getDriver;

public class BuilderActions {

    public static void moveToElementAndClick(WebElement element) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element)
                .click()
                .perform();
    }

    public static void inputAndPressEnter(WebElement element, String text) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element)
                .sendKeys(element, text)
                .sendKeys(Keys.ENTER)
                .perform();
    }
}
