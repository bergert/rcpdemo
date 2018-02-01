package net.bergertom.rcpdemo.gui.wizard;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class DelayPage1 extends WizardPage {

	final public static String ID = "net.bergertom.rcpdemo.gui.wizard.delaypage1";
	private Composite container;
	private Label lblFileName;
	private DelayWizard wizard = null;

	public DelayPage1(DelayWizard wizard) {
		super(ID);
		System.out.println("DelayPage1()");
		
		this.wizard  = wizard;
		//setImageDescriptor(ResourceManager.getPluginImageDescriptor("net.bergertom.rcpdemo.gui", "icons/wizard-icon.png"));
		setTitle("RCPdemo file download");
		setDescription("downloading file now");
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);
		container.setLayout(new FormLayout());

		Label lblURLtext = new Label(container, SWT.LEFT);
		lblURLtext.setText("some text");
		FormData fd_lblURLtext = new FormData();
		fd_lblURLtext.top      = new FormAttachment(0, 10);
		fd_lblURLtext.left     = new FormAttachment(0, 5);
		fd_lblURLtext.right    = new FormAttachment(100, -10);
		lblURLtext.setLayoutData(fd_lblURLtext);
		
		Label lblFileText = new Label(container, SWT.LEFT);
		FormData fd_lblFileText = new FormData();
		fd_lblFileText.left     = new FormAttachment(0, 5);
		fd_lblFileText.top      = new FormAttachment(lblURLtext, 10);
		lblFileText.setLayoutData(fd_lblFileText);
		lblFileText.setText("Download location:");
		
		lblFileName = new Label(container, SWT.LEFT);
		FormData fd_lblFileName = new FormData();
		fd_lblFileName.left     = new FormAttachment(0, 5);
		fd_lblFileName.top = new FormAttachment(lblFileText, 10);
		fd_lblFileName.right    = new FormAttachment(100, -10);
		lblFileName.setLayoutData(fd_lblFileName);
		
		setControl(container);
		//setPageComplete(false);
		System.out.println("setPageComplete(false);");
	}

	@Override
    public IWizardPage getPreviousPage() {
		// the back button is disabled
		return null;
    }

	@Override
	public void setVisible(boolean visible) {
		System.out.println("DelayPage1.setVisible()");
		super.setVisible(visible);
		if (visible) {
	        getControl().getDisplay().asyncExec(new Runnable() {
	            @Override
	            public void run() {
	    				doHTTPdownload();
	            }
			});
		}
	}
	
	/**
	 * download the workspace file, with progress bar
	 */
	private void doHTTPdownload() {
		try {
			getContainer().run(false, false, new IRunnableWithProgress()  {
				@Override
				public void run(final IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {

					monitor.beginTask("Downloading workspace", 5);
					for (int i=0; i< 15; i++) {
						System.out.println(" counting ... "+i);
						monitor.worked(1);
						try {
							TimeUnit.MILLISECONDS.sleep(1500);
						} catch (Exception e2) { };
					}
					monitor.done();
					System.out.println(" counting done");
			        getControl().getDisplay().asyncExec(new Runnable() {
			            @Override
			            public void run() {
							downloadCompleted();
			            }
					});
				}
			});
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	private void downloadCompleted() {

		lblFileName.setText("downloaded from http://www.fao.org");
		lblFileName.redraw();

		setPageComplete(true);
		setMessage("The download is complete", INFORMATION );

		System.out.println("wizard.canFinish()="+wizard.canFinish());
		System.out.println("isPageComplete()="+this.isPageComplete());
        getContainer().updateButtons();
		container.update();
		container.redraw();
        
	}
}
