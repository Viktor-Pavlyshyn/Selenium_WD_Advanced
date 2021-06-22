package ua.com.epam.desktop.pages;

import ua.com.epam.abstractClasses.page.AbstractPage;

import static ua.com.epam.utils.DataPropLoader.getBrowserProperty;

public class BasketPage extends AbstractPage {

    private static final String pageUrl = getBrowserProperty("base.url") + "/basket";

    public BasketPage() {
        setPageUrl(pageUrl);
    }
}