package desktop.functionalActions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static webdriver.DriverManager.getDriver;

public class JavascriptActions {
    private static final JavascriptExecutor js = (JavascriptExecutor) getDriver();

    public static void elementHighlighter(WebElement element) {
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }

    public static void clickOnElementWithJS(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }
}
