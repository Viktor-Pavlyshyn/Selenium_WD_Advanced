package abstractClasses.fragment;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.WebDriverWaiter;

import static driver.SingletonDriver.getDriver;

public abstract class AbstractFragment extends WebDriverWaiter {
    private WebElement rootElement;
    private Select select;
    private Actions actions;
    private JavascriptExecutor js;

    public AbstractFragment() {
        PageFactory.initElements(getDriver(), this);
        actions = new Actions(getDriver());
        js = (JavascriptExecutor)getDriver();
    }

    public void setRootElement(WebElement element) {
        this.rootElement = element;
    }

    public WebElement getRootElement() {
        return rootElement;
    }

    public void selectByText(WebElement element, String value) {
        select = new Select(element);
        select.selectByVisibleText(value);
    }

    public void switchToFrame(WebElement element) {
        getDriver().switchTo().frame(element);
    }

    public void switchToDefaultContent() {
        getDriver().switchTo().defaultContent();
    }

    public void moveToElementAndClick(WebElement element){
        actions.moveToElement(element)
                .click()
                .perform();
    }

    public void inputAndPressEnter(WebElement element, String text){
        actions.moveToElement(element)
                .sendKeys(element, text)
                .sendKeys(Keys.ENTER)
                .perform();
    }

    public void elementHighlighter(WebElement element) {
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }

    public void clickOnElementWithJS(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }

}

