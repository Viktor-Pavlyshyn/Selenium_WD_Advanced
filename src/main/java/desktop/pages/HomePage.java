package desktop.pages;

import abstractClasses.page.AbstractPage;
import desktop.fragments.SearchFragment;
import lombok.Getter;

import static utils.DataPropLoader.getBrowserProperty;

@Getter
public class HomePage extends AbstractPage {
    private static final String pageUrl = getBrowserProperty("base.url");
    private final SearchFragment searchFragment;

    public HomePage() {
        setPageUrl(pageUrl);
        searchFragment = new SearchFragment();
    }
}
