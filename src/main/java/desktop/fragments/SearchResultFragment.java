package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

import static utils.WaitUtils.*;
import static webdriver.DriverManager.getDriver;

public class SearchResultFragment extends AbstractFragment {

    @FindBy(xpath = "//div[@class=\"main-content search-page\"]/h1")
    private WebElement searchTitle;

    @FindBy(xpath = "//h3[@class=\"title\"]/a")
    private List<WebElement> bookTitles;

    @FindBy(xpath = "//a[@data-localizer-string-id=\"bd_js_basket_checkout\"]")
    private WebElement basketCheckOutButton;

    public List<String> getBookTitleList() {
        fWaitElementsUtil(ExpectedConditions.visibilityOfAllElements(bookTitles));
        return bookTitles.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void clickOnAddToBasketByBookName(String bookName){
        getDriver().findElement(By.xpath(String.format("//div[@class=\"btn-wrap\"]" +
                "[parent::div[preceding-sibling::div//a[contains(text(),\"%s\")]]]", bookName)))
                .click();
    }

    public void clickOnBasketCheckOutButton(){
        fWaitUtil(ExpectedConditions.elementToBeClickable(basketCheckOutButton)).click();
    }
}