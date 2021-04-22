package desktop.actions.actionsimpl;

import desktop.pages.HomePage;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class HomeActions {
    private final HomePage homePage = new HomePage();

    public HomeActions inputTextAndPressEnter(String searchData) {
        homePage.getSearchFragment().inputValue(searchData);
        log.info("Input text - {} and press enter.", searchData);
        return this;
    }
}
