package ua.com.epam.desktop.pages;

import ua.com.epam.abstractClasses.page.AbstractPage;

import static ua.com.epam.utils.DataPropLoader.getBrowserProperty;

public class HomePage extends AbstractPage {

    private static final String pageUrl = getBrowserProperty("base.url");

    public HomePage() {
        setPageUrl(pageUrl);
    }
}
