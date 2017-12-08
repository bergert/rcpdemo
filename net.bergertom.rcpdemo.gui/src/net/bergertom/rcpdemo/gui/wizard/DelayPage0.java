package net.bergertom.rcpdemo.gui.wizard;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.PlatformUI;

public class DelayPage0 extends WizardPage {
	final public static String ID = "net.bergertom.rcpdemo.gui.wizard.delaypage0";
	private Label lblFileName;

	public DelayPage0(DelayWizard wizard) {
		super(ID);
		System.out.println("DelayPage0()");
		setTitle("RCPdemo delay test");
		setDescription("Please select a file (*.java))");
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.marginHeight = 3;
		layout.marginWidth = 3;
		layout.horizontalSpacing = 3;
		layout.verticalSpacing = 3;
		layout.numColumns = 3;
		container.setLayout(layout);
		
		Label lblSelectFile = new Label(container, SWT.NULL);
		lblSelectFile.setText("select file");
		GridData gd_lblSelectFile = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblSelectFile.widthHint = 70;
		lblSelectFile.setLayoutData(gd_lblSelectFile);
		
		lblFileName = new Label(container, SWT.NULL);
		GridData gd_lblFileName = new GridData(GridData.VERTICAL_ALIGN_END);
		gd_lblFileName.horizontalSpan = 3;
		gd_lblFileName.widthHint = 600;
		lblFileName.setLayoutData(gd_lblFileName);
		lblFileName.setText("");
		
		setControl(container);
		System.out.println("setPageComplete(false);");
		setPageComplete(false);
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			FileDialog fileDialog = new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
			fileDialog.setFilterExtensions(new String[]{"*.java"});
			fileDialog.setFilterPath("~/Desktop");
			fileDialog.setText("please select a file");
			String res = fileDialog.open();
			if (res != null) {
				lblFileName.setText(res);
				setPageComplete(true);
				setMessage("A workspace file is selected", INFORMATION );
		        getContainer().updateButtons();
			}
		}
	}
	
	@Override
    public IWizardPage getPreviousPage() {
		// the back button is disabled
		return null;
    }
}
