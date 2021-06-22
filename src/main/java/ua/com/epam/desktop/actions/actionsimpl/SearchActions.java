package ua.com.epam.desktop.actions.actionsimpl;

import ua.com.epam.desktop.fragments.SearchFragment;

public class SearchActions {
    private final SearchFragment searchFragment = new SearchFragment();

    public SearchActions inputTextAndPressEnter(String searchData) {
        searchFragment.inputValue(searchData);
        searchFragment.pressEnter();
        return this;
    }
}
