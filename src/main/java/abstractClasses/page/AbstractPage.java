package abstractClasses.page;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;
import static webdriver.DriverManager.getDriver;

public abstract class AbstractPage {
    private String pageUrl;
    private String pageUrlPattern;

    protected void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    protected void setPageUrlPattern(String pageUrlPattern) {
        this.pageUrlPattern = pageUrlPattern;
    }

    public void checkUrl() {
        boolean result = pageUrl.equals(getDriver().getCurrentUrl());
        if (!result && isNotEmpty(pageUrlPattern)) {
            getDriver().getCurrentUrl();
        }
    }
}
