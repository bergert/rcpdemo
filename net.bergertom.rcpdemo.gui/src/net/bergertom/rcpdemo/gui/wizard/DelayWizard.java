package net.bergertom.rcpdemo.gui.wizard;

import org.eclipse.jface.wizard.Wizard;

public class DelayWizard extends Wizard {

	public DelayWizard() {
		super();
		System.out.println("DelayWizard()");
		setNeedsProgressMonitor(true);
	}

	@Override
	public void addPages() {

		//addPage(new DelayPage0(this));
		addPage(new DelayPage1(this));
	}


	@Override
	public boolean performFinish() {
		// Note: e4 does not dispose the wizard, do it manually
		//getShell().setVisible(false);
		dispose();
		
		return (true);	// finish request is accepted
	}
}