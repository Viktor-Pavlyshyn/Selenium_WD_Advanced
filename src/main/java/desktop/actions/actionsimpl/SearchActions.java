package desktop.actions.actionsimpl;

import desktop.fragments.SearchFragment;

public class SearchActions {
    private final SearchFragment searchFragment = new SearchFragment();

    public SearchActions inputTextAndPressEnter(String searchData) {
        searchFragment.inputValue(searchData);
        return this;
    }
}
