package utils;

import java.util.Arrays;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;
import static utils.DataPropLoader.getBrowserProperty;

public enum PageUrl {
    SEARCH_PAGE("Search page", "search", "search.*"),
    BASKET_PAGE("Basket page", "basket", null);

    private final String name;
    private final String url;
    private final String pattern;

    PageUrl(String name, String url, String pattern) {
        this.name = name;
        this.url = getBrowserProperty("base.url") + url;
        this.pattern = getBrowserProperty("base.url") + pattern;
    }

    public boolean checkUrl(String currentUrl) {
        boolean result = url.equals(currentUrl);
        if (!result && isNotEmpty(pattern)) {
            return currentUrl.matches(pattern);
        }
        return result;
    }

    public static PageUrl getPageByName(String name) {
        return Arrays.stream(values())
                .filter(pageUrl -> pageUrl.name.equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Incorrect page name."));
    }
}
