package cz.jpikl.yafmt.ui.util;

import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;

public class DynamicContributionItem extends ActionContributionItem {

    public DynamicContributionItem(IAction action) {
        super(action);
    }

    @Override
    public boolean isDynamic() {
        return true;
    }

}
