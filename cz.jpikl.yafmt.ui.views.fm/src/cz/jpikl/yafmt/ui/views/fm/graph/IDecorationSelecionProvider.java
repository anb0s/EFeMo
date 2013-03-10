package cz.jpikl.yafmt.ui.views.fm.graph;

import org.eclipse.jface.viewers.ISelection;

import cz.jpikl.yafmt.ui.views.fm.decorations.IDecoration;


public interface IDecorationSelecionProvider {
    
    ISelection getSelectionForDecoration(IDecoration decoration);

}