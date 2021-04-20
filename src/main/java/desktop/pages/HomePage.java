package desktop.pages;

import abstractClasses.page.AbstractPage;

import static utils.DataPropLoader.getBrowserProperty;

public class HomePage extends AbstractPage {

    private static final String pageUrl = getBrowserProperty("base.url");

    public HomePage() {
        setPageUrl(pageUrl);
    }
}
