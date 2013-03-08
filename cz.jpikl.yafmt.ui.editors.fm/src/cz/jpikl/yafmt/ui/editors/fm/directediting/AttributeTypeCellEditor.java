package cz.jpikl.yafmt.ui.editors.fm.directediting;

import org.eclipse.emf.common.ui.celleditor.ExtendedComboBoxCellEditor;
import org.eclipse.swt.widgets.Composite;

import cz.jpikl.yafmt.model.fm.AttributeType;
import cz.jpikl.yafmt.model.fm.provider.util.FeatureModelProviderUtil;

public class AttributeTypeCellEditor extends ExtendedComboBoxCellEditor {

    public AttributeTypeCellEditor(Composite composite) {
        super(composite, AttributeType.VALUES, FeatureModelProviderUtil.getLabelProvider());
    }

}
