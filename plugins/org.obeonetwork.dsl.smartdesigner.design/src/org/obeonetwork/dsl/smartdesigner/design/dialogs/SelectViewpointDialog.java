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

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ICheckStateProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.obeonetwork.dsl.smartdesigner.design.Activator;
import org.obeonetwork.dsl.smartdesigner.design.util.BasicDiagramUtil;
import org.obeonetwork.dsl.smartdesigner.design.util.EMFUtil;

/**
 * 
 * @author Stephane Drapeau - Obeo
 * 
 */
public class SelectViewpointDialog extends AbstractTreeDialog {

	private Map<String, Set<ViewpointID>> model;

	private Set<ViewpointID> selectedEObjects;

	public SelectViewpointDialog(Shell parent, Map<String, Set<ViewpointID>> model,
			Set<ViewpointID> selectedEObjects, String title, Image image,
			int width, int height) {
		super(parent, title, image, width, height);
		this.model = model;
		this.selectedEObjects = selectedEObjects;
	}

	public void setSelected(Object element, boolean selected) {
		if (selected) {
			if (element instanceof Entry) {
				Entry entry = (Entry) element;
				if (entry.getValue() instanceof Set) {
					Set<ViewpointID> l = (Set<ViewpointID>) entry.getValue();
					for (ViewpointID ge : l) {
						selectedEObjects.add(ge);
					}
				} 
			} else if (element instanceof ViewpointID) {
				selectedEObjects.add((ViewpointID) element);
			}

		} else {
			if (element instanceof Entry) {
				Entry entry = (Entry) element;
				if (entry.getValue() instanceof Set) {
					Set<ViewpointID> l = (Set<ViewpointID>) entry.getValue();
					for (ViewpointID ge : l) {
						selectedEObjects.remove(ge);
					}
				} 
			} else if (element instanceof ViewpointID) {
				selectedEObjects.remove((ViewpointID) element);
			}
		}
	}

	public ITreeContentProvider createAdapterFactoryContentProvider(
			ComposedAdapterFactory adapterFactory) {
		return new ITreeContentProvider() {

			@Override
			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {
				// Nada
			}

			@Override
			public void dispose() {
				// Nada
			}

			@Override
			public boolean hasChildren(Object element) {
				if (element instanceof ViewpointID) {
					return false;
				}
				return true;
			}

			@Override
			public Object getParent(Object element) {
				throw new IllegalAccessError();
			}

			@Override
			public Object[] getElements(Object inputElement) {
				Set<Entry<String, Set<ViewpointID>>> set = model.entrySet();
	
				return set.toArray();
			}

			@Override
			public Object[] getChildren(Object parentElement) {
				if (parentElement instanceof Entry) {
					Entry entry = (Entry) parentElement;
					  if (entry.getValue() instanceof Set) {
						return ((Set) entry.getValue()).toArray();
					}
				} else if (parentElement instanceof ViewpointID) {
					return null;
				}
				return null;
			}
		};
	}

	public ICheckStateProvider createCheckStateProvider() {
		return new ICheckStateProvider() {
			public boolean isGrayed(Object element) {
				// Non leaf nodes
				if (element instanceof Entry) {
					Entry entry = (Entry) element;
					if (entry.getValue() instanceof Set) {
						int totalSize = ((Set) entry.getValue()).size();
						int numberOfSelectedElement = 0;
						for (ViewpointID ge : (Set<ViewpointID>) entry.getValue()) {
							if (selectedEObjects.contains(ge)) {
								numberOfSelectedElement++;
							}
						}
						return (numberOfSelectedElement > 0 && numberOfSelectedElement < totalSize);
					}
				}
				// Leaf nodes
				else if (element instanceof ViewpointID) {
					return false;
				}
				return false;
			}

			public boolean isChecked(Object element) {
				if (element instanceof Entry) {
					Entry entry = (Entry) element;
					if (entry.getValue() instanceof Set) {
						int numberOfSelectedElement = 0;
						for (ViewpointID ge : (Set<ViewpointID>) entry.getValue()) {
							if (selectedEObjects.contains(ge)) {
								numberOfSelectedElement++;
							}
						}
						return numberOfSelectedElement > 0;
					}
				} else if (element instanceof ViewpointID) {
					return selectedEObjects.contains(element);
				}
				return false;
			}

		};
	}

	@Override
	public Object getModel() {
		return this.model;
	}

	@Override
	public IBaseLabelProvider createLabelProvider() {
		return new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof Entry) {
					String key = ((Entry<String,?>) element).getKey();
						return key;
				} else if (element instanceof ViewpointID) {
					return ((ViewpointID) element).getViewpointName();
				}
				return null;
			}

			@Override
			public Image getImage(Object element) {
				return Activator.getViewpointImage();
			}
		};
	}

}
