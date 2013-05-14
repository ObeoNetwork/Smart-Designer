/**
 * Copyright (c) 2013 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 * 
 */
package org.obeonetwork.dsl.smartdesigner.design.dialogs;

import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ICheckStateProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;

/**
 * Abstract class for the dialogs implemented in Basic Diagram.
 * 
 * @author Stephane Drapeau - Obeo
 * 
 */
public abstract class AbstractTreeDialog extends Dialog {

	private boolean isCanceled;

	protected String title;

	protected Image image;

	protected int width;

	protected int height;

	protected CheckboxTreeViewer choosedViewer;

	protected ITreeContentProvider contentProvider;

	public AbstractTreeDialog(Shell parent, String title, Image image,
			int width, int height) {
		super(parent);
		this.title = title;
		this.image = image;
		this.width = width;
		this.height = height;
	}

	public int open() {
		Shell parent = getParent();
		final Shell shell = new Shell(parent, SWT.TITLE | SWT.BORDER
				| SWT.APPLICATION_MODAL | SWT.SHEET | SWT.RESIZE);
		shell.setSize(this.width, this.height);

		shell.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		shell.setLayout(new GridLayout(1, true));

		shell.setText(title);
		shell.setImage(image);

		org.eclipse.swt.widgets.Composite container = new Composite(shell,
				SWT.NONE);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		container.setLayout(new GridLayout(1, true));
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory
				.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new EcoreItemProviderAdapterFactory());
		adapterFactory
				.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		choosedViewer = new CheckboxTreeViewer(container, SWT.BORDER);

		Tree tree = choosedViewer.getTree();
		choosedViewer.setLabelProvider(createLabelProvider());
		contentProvider = createAdapterFactoryContentProvider(adapterFactory);
		choosedViewer.setContentProvider(contentProvider);
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		// tree.setBounds(5, 5, this.width-25, this.height-100);

		choosedViewer.setCheckStateProvider(createCheckStateProvider());
		choosedViewer.addCheckStateListener(new ICheckStateListener() {
			public void checkStateChanged(CheckStateChangedEvent event) {
				setSelected(event.getElement(), event.getChecked());
				choosedViewer.refresh();
			}
		});

		choosedViewer.setInput(getModel());

		Composite composite = new Composite(shell, 0);
		composite.setLayout(new GridLayout(2, true));

		final Button okButton = new Button(composite, SWT.PUSH | SWT.NONE);
		okButton.setText("Finish");

		GridData data = new GridData();
		data.heightHint = 30;
		data.widthHint = 75;
		data.horizontalAlignment = SWT.END;
		okButton.setLayoutData(data);

		Button cancelButton = new Button(composite, SWT.PUSH | SWT.NONE);
		cancelButton.setText("Cancel");

		data = new GridData();
		data.heightHint = 30;
		data.widthHint = 75;
		data.horizontalAlignment = SWT.END;
		cancelButton.setLayoutData(data);

		okButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				shell.dispose();
			}
		});

		cancelButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				isCanceled = true;
				shell.dispose();
			}
		});

		shell.getShell().addListener(SWT.Close, new Listener() {
			public void handleEvent(Event event) {
				shell.dispose();
			}
		});

		shell.addListener(SWT.Traverse, new Listener() {
			public void handleEvent(Event event) {
				if (event.detail == SWT.TRAVERSE_ESCAPE)
					event.doit = false;
				isCanceled = true;
				shell.dispose();
			}
		});

		shell.open();

		Display display = parent.getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		return SWT.OK;
	}

	public boolean isCanceled() {
		return isCanceled;
	}

	public abstract Object getModel();

	public abstract ICheckStateProvider createCheckStateProvider();

	public abstract ITreeContentProvider createAdapterFactoryContentProvider(
			ComposedAdapterFactory adapterFactory);

	public abstract IBaseLabelProvider createLabelProvider();

	public abstract void setSelected(Object element, boolean checked);

}
