package desktop.actions.actionsimpl;

import desktop.pages.SearchResultPage;
import lombok.extern.log4j.Log4j2;

import java.util.Map;

@Log4j2
public class SearchResultActions {
    private final SearchResultPage searchResultPage = new SearchResultPage();

    public SearchResultActions clickOnAddToBasketByBookName(String bookName){
        searchResultPage.getSearchResultFragment()
                .clickOnAddToBasketByBookName(bookName);

        log.info("Click 'Add to basket' button for product with name {}", bookName);
        return this;
    }

    public SearchResultActions clickOnBasketCheckOutButton(){
        searchResultPage.getSearchResultFragment()
                .clickOnBasketCheckOutButton();

        log.info("Select 'Basket/Checkout' in basket pop-up");
        return this;
    }

    public SearchResultActions selectAllOptionAndApply(Map<String, String> filterParam) {
        searchResultPage.getFilterFragment().selectPrice(filterParam.get("Price range"));
        searchResultPage.getFilterFragment().selectAvailability(filterParam.get("Availability"));
        searchResultPage.getFilterFragment().selectLanguage(filterParam.get("Language"));
        searchResultPage.getFilterFragment().selectFormat(filterParam.get("Format"));
        searchResultPage.getFilterFragment().clickRefineResult();

        log.info("Apply the following search filters {}", filterParam);
        return this;
    }
}
