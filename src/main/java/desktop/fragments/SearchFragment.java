package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import lombok.SneakyThrows;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchFragment extends AbstractFragment {

    @FindBy(xpath = "//input[@class=\"text-input\"]")
    private WebElement searchInput;

    public SearchFragment() {
        setRootElement(searchInput);
    }

    @SneakyThrows
    public void inputValue(String value){
        elementHighlighter(searchInput);
        searchInput.sendKeys(value);
    }

    public void pressEnter(){
        searchInput.sendKeys(Keys.ENTER);
    }
}