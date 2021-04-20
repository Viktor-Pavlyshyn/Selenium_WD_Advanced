package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static driver.SingletonDriver.getDriver;

public class SearchResultFragment extends AbstractFragment {

    @FindBy(xpath = "//div[@class=\"main-content search-page\"]/h1")
    private WebElement searchTitle;

    @FindBy(xpath = "//h3[@class=\"title\"]/a")
    private List<WebElement> bookTitles;

    @FindBy(xpath = "//a[@class=\"btn btn-primary pull-right continue-to-basket string-to-localize link-to-localize\"]")
    private WebElement basketCheckOutButton;

    public SearchResultFragment() {
        setRootElement(searchTitle);
    }

    public List<String> getBookTitleList() {
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
        basketCheckOutButton.click();
    }
}