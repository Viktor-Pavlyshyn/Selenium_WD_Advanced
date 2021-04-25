package desktop.fragments;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.WaitUtils.fWaitUtil;
import static webdriver.DriverManager.getDriver;

public class BookTableFragment {
    private String rootTable;
    private String bookName;
    private String table;
    private String bookTitle;
    private String author;
    private String addButton;

    public BookTableFragment(String rootTable, String bookName) {
        this.rootTable = rootTable;
        this.bookName = bookName;
        this.table = "//div[@class=\"block-wrap  \"][descendant::h2[text()='%s']]";
        this.bookTitle = "a[contains(text(),'%s')]";
        this.author = table + "//div[@class=\"book-item\"][descendant-or-self::" + bookTitle + "]//p[@class=\"author\"]";
        this.addButton = table + "//div[@class=\"book-item\"][descendant-or-self::" + bookTitle + "]//a[@rel=\"nofollow\"]";
    }

    public void clickAddButton() {

        fWaitUtil(ExpectedConditions.visibilityOf(getDriver()
                .findElement(By.xpath(String.format(addButton, rootTable, bookName))))).click();
    }

    public String getAuthorText() {
        return getDriver().findElement(By.xpath(String.format(author, rootTable, bookName))).getText();
    }
}
