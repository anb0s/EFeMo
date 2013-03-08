package cz.jpikl.yafmt.ui.editors.fc;

import java.util.List;

import cz.jpikl.yafmt.model.fc.Selection;

public interface IFeatureConfigurationListener {

    public void featuresSelected(List<Selection> selections);

    public void featuresDeselected(List<Selection> selections);

}
