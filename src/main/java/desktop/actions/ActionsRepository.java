package desktop.actions;

import desktop.actions.actionsimpl.BasketActions;
import desktop.actions.actionsimpl.CheckoutActions;
import desktop.actions.actionsimpl.HomeActions;
import desktop.actions.actionsimpl.SearchResultActions;

public class ActionsRepository extends Repository{

    public HomeActions getHomeActions() {
        return get(HomeActions.class);
    }

    public SearchResultActions getResultSearchActions() {
        return get(SearchResultActions.class);
    }

    public BasketActions getBasketActions() {
        return get(BasketActions.class);
    }

    public CheckoutActions getCheckoutActions() {
        return get(CheckoutActions.class);
    }
}
