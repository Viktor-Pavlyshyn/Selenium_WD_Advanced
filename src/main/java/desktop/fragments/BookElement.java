package desktop.fragments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.WaitUtils.fWaitUtil;

public class BookElement {

    private WebElement book;

    public BookElement(WebElement bookTable, String bookName) {
        this.book = fWaitUtil(ExpectedConditions.visibilityOf(bookTable
                .findElement(By.xpath(".//div[@class=\"book-item\"]" +
                        "[descendant::a[contains(text(),\"" + bookName + "\")]]"))));
    }

    public void clickAddButton() {
        fWaitUtil(ExpectedConditions.visibilityOf(book
                .findElement(By.xpath(".//div[@class=\"btn-wrap\"]"))))
                .click();
    }

    public String getAuthorText() {
        return fWaitUtil(ExpectedConditions.visibilityOf(book
                .findElement(By.xpath(".//span[@itemprop=\"name\"]"))))
                .getText();
    }
}