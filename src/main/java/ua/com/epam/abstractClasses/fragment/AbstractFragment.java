package ua.com.epam.abstractClasses.fragment;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import ua.com.epam.utils.WebDriverWaiter;

import static ua.com.epam.driver.SingletonDriver.getDriver;

public abstract class AbstractFragment extends WebDriverWaiter {
    private WebElement rootElement;
    private Select select;
    private Actions builder;
    private Action action;
    private JavascriptExecutor js;

    public AbstractFragment() {
        PageFactory.initElements(getDriver(), this);
        builder = new Actions(getDriver());
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
        action = builder.moveToElement(element)
                .click()
                .build();
        action.perform();
    }

    public void elementHighlighter(WebElement element) {
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }
}

