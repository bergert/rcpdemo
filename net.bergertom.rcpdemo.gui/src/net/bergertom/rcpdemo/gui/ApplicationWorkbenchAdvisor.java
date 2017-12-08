package net.bergertom.rcpdemo.gui;

import org.eclipse.ui.application.WorkbenchAdvisor;

public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {
	  private static final String PERSPECTIVE_ID = "net.bergertom.rcpdemo.gui.perspective.main";

	  public String getInitialWindowPerspectiveId() {
	    return PERSPECTIVE_ID;
	  }
}
