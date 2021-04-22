package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import lombok.SneakyThrows;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static desktop.functionalActions.BuilderActions.inputAndPressEnter;
import static desktop.functionalActions.JavascriptActions.elementHighlighter;

public class SearchFragment extends AbstractFragment {
    @FindBy(xpath = "//input[@class=\"text-input\"]")
    private WebElement searchInput;

    @SneakyThrows
    public void inputValue(String value){
        elementHighlighter(searchInput);
        inputAndPressEnter(searchInput, value);
    }
}