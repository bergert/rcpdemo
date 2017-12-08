package net.bergertom.rcpdemo.gui.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;

public class EmptyView extends ViewPart {

	public final static String ID = "net.bergertom.rcpdemo.gui.display.views.emptyview";
	private Label label;

	public EmptyView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new FillLayout(SWT.HORIZONTAL));
		label = new Label(parent, SWT.NONE);
		label.setAlignment(SWT.CENTER);
		//label.setImage(Activator.getImage("icons/actions/FAOlogo.png"));
	}

	@Override
	public void setFocus() {
	}

}
