package desktop.fragments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.WaitUtils.fWaitUtil;
import static webdriver.DriverManager.getDriver;

public class BookTableFragment {

    private WebElement bookTable;

    public BookTableFragment(String rootTable) {
        this.bookTable = fWaitUtil(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("//div[@class=\"block-wrap  \"]" +
                "[descendant::h2[text()=\"" + rootTable + "\"]]/div[@class=\"block \"]"))));
    }

    public BookElement getBookByName(String name) {
        return new BookElement(bookTable, name);
    }

}
