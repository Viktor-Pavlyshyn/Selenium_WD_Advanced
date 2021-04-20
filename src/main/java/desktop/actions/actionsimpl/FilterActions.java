package desktop.actions.actionsimpl;

import desktop.fragments.FilterFragment;

import java.util.Map;

public class FilterActions {
    private FilterFragment filterFragment = new FilterFragment();

    public FilterActions selectAllOptionAndApply(Map<String, String> filterParam) {
        filterFragment.selectPrice(filterParam.get("Price range"));
        filterFragment.selectAvailability(filterParam.get("Availability"));
        filterFragment.selectLanguage(filterParam.get("Language"));
        filterFragment.selectFormat(filterParam.get("Format"));
        filterFragment.clickRefineResult();
        return this;
    }
}
