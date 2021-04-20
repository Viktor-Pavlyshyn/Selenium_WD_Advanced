package desktop.pages;

import abstractClasses.page.AbstractPage;

import static utils.DataPropLoader.getBrowserProperty;

public class BasketPage extends AbstractPage {

    private static final String pageUrl = getBrowserProperty("base.url") + "/basket";

    public BasketPage() {
        setPageUrl(pageUrl);
    }
}