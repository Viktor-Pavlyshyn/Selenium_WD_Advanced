package desktop.actions;

import desktop.actions.verificationActions.BasketActions;
import desktop.actions.verificationActions.CheckoutActions;
import desktop.actions.verificationActions.HomeActions;
import desktop.actions.verificationActions.SearchResultActions;

public class VerificationActionsRepository extends Repository {

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
