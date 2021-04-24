package desktop.actions.verificationActions;

import desktop.pages.SearchResultPage;
import lombok.extern.log4j.Log4j2;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class SearchResultActions {
    private final SearchResultPage searchResultPage = new SearchResultPage();

    public void verifyThatResultContainsValue(List<String> searchParam){
        List<String> books = searchResultPage.getSearchResultFragment()
                .getBookTitleList();
        searchParam.forEach(param ->
                assertThat(books.stream().anyMatch(book -> book.contains(param)))
                        .as("Search result does not contains - " + param + ".")
                        .isTrue()
        );
        log.info("Verify that search results contain the following products {}", searchParam);
    }

    public void verifyCurrentUrl(){
        assertThat(searchResultPage.isPageOpen())
                .as("Wrong current Url.")
                .isTrue();
    }
}
