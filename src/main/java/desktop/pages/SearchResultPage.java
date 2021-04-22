package desktop.pages;

import abstractClasses.page.AbstractPage;
import desktop.fragments.FilterFragment;
import desktop.fragments.SearchResultFragment;
import lombok.Getter;

import static utils.DataPropLoader.getBrowserProperty;

@Getter
public class SearchResultPage extends AbstractPage {
    private static final String pageUrl = getBrowserProperty("base.url") + "search";
    private static final String pageUrlPattern = pageUrl + ".*";
    private final SearchResultFragment searchResultFragment;
    private final FilterFragment filterFragment;

    public SearchResultPage() {
        setPageUrl(pageUrl);
        setPageUrlPattern(pageUrlPattern);
        searchResultFragment = new SearchResultFragment();
        filterFragment = new FilterFragment();
    }
}