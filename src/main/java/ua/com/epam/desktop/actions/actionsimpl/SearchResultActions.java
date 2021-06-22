package ua.com.epam.desktop.actions.actionsimpl;

import ua.com.epam.desktop.fragments.SearchResultFragment;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultActions {
    private final SearchResultFragment searchResultFragment = new SearchResultFragment();

    public SearchResultActions searchResultPageIsOpened() {
        assertThat(searchResultFragment.getRootElement().isDisplayed())
                .as(searchResultFragment.getClass().getSimpleName() + " is not displayed.")
                .isTrue();
        return this;
    }

    public void verifyIfResultTitleContainsValue(List<String> searchParam){
        List<String> books = searchResultFragment.getBookTitleList();
        searchParam.forEach(param ->
                assertThat(books.stream().anyMatch(book -> book.contains(param)))
                        .as("Search result does not contains - " + param + ".")
                        .isTrue()
        );
    }

    public void clickOnAddToBasketByBookName(String bookName){
        searchResultFragment.clickOnAddToBasketByBookName(bookName);
    }

    public void clickOnBasketCheckOutButton(){
        searchResultFragment.clickOnBasketCheckOutButton();
    }
}
