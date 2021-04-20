package desktop.actions;

import desktop.actions.actionsimpl.*;

public class ActionsRepository extends Repository {

    public SearchActions getSearchActions() {
        return get(SearchActions.class);
    }

    public SearchResultActions getResultSearchActions() {
        return get(SearchResultActions.class);
    }

    public FilterActions getFilterActions() {
        return get(FilterActions.class);
    }

    public BasketActions getBasketActions() {
        return get(BasketActions.class);
    }

    public CheckoutBasketActions getCheckoutBasketActions() {
        return get(CheckoutBasketActions.class);
    }
}