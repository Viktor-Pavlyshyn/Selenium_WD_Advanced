package ua.com.epam.desktop.pages.kruidvat;

import ua.com.epam.abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class BasketPage  extends AbstractFragment {

    @FindBy(xpath = "//div[@class=\"product-summary__description-name\"]")
    private List<WebElement> productNames;

    public List<String> getAllProductNames() {
        return productNames.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
