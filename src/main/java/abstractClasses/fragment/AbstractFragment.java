package abstractClasses.fragment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static webdriver.DriverManager.getDriver;

public abstract class AbstractFragment {

    public AbstractFragment() {
        PageFactory.initElements(getDriver(), this);
    }

    public void switchToFrame(WebElement element) {
        getDriver().switchTo().frame(element);
    }

    public void switchToDefaultContent() {
        getDriver().switchTo().defaultContent();
    }
}