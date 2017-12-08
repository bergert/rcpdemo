package net.bergertom.rcpdemo.gui;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class EmptyPerspective implements IPerspectiveFactory {

	public static final String ID = "org.fao.fi.fishstat.gui.perspective.empty";
	
	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(false);
		layout.setFixed(true);
		layout.addStandaloneView(EmptyView.ID, false, IPageLayout.TOP, 1.0f, editorArea);
	}
}