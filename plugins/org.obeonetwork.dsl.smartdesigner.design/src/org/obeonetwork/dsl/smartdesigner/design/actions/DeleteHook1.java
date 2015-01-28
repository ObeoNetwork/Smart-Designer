package org.obeonetwork.dsl.smartdesigner.design.actions;

import java.util.Collection;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.PlatformUI;
import org.obeonetwork.dsl.smartdesigner.design.Activator;

import fr.obeo.dsl.viewpoint.DSemanticDecorator;
import fr.obeo.dsl.viewpoint.business.api.delete.IDeleteHook;

public class DeleteHook1 implements IDeleteHook {

	public static int deleteCode = -1;

	public DeleteHook1() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IStatus beforeDeleteCommandExecution(
			Collection<DSemanticDecorator> selections,
			Map<String, Object> parameters) {
		deleteCode = -1;
		Menu menu = new Menu(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell());

		MenuItem item = new MenuItem(menu, SWT.CASCADE);
		item.setText("Delete from diagram");
		ImageDescriptor imageDescriptor = Activator.imageDescriptorFromPlugin(
				Activator.PLUGIN_ID, "icons/delete.gif");
		item.setImage(imageDescriptor.createImage());
		item.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				deleteCode = 1;
			}
		});

		item = new MenuItem(menu, SWT.CASCADE);
		item.setText("Delete from model");
		imageDescriptor = Activator.imageDescriptorFromPlugin(
				Activator.PLUGIN_ID, "icons/deleteModel.gif");
		item.setImage(imageDescriptor.createImage());
		item.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				deleteCode = 0;
			}
		});

		menu.setVisible(true);
		Display display = menu.getDisplay();
		while (!menu.isDisposed() && menu.isVisible()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		if (!menu.isDisposed()) {
			menu.dispose();
		}
		if (deleteCode == -1) {
			return new Status(IStatus.CANCEL,
					"fr.obeo.smartea.dsl.smartdesigner.delete", "");
		} else {
			return new Status(IStatus.OK,
					"fr.obeo.smartea.dsl.smartdesigner.delete", "");
		}
	}

}
