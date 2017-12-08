package net.bergertom.rcpdemo.gui.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;

import net.bergertom.rcpdemo.gui.wizard.DelayWizard;

public class FileOpen extends AbstractHandler {

	public static final String ID = "net.bergertom.rcpdemo.gui.command.file.open";
	
	@Override
	public Object execute(ExecutionEvent arg0) throws ExecutionException {

		System.out.println("File -> Open");

		DelayWizard wizard = new DelayWizard();
		WizardDialog dialog = new WizardDialog(Display.getDefault().getActiveShell(), wizard);
		dialog.open();
		
		return null;
	}	
}
