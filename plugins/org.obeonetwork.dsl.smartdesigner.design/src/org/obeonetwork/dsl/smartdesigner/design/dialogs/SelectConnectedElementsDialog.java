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

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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
import org.obeonetwork.dsl.smartdesigner.design.util.BasicDiagramUtil;
import org.obeonetwork.dsl.smartdesigner.design.util.EMFUtil;

/**
 * 
 * @author Stephane Drapeau - Obeo
 * 
 */
public class SelectConnectedElementsDialog extends AbstractTreeDialog {

	private Map<EObject, Map<EClass, Set<EObject>>> model;

	private final Set<EObject> selectedEObjects;

	public SelectConnectedElementsDialog(Shell parent,
			Map<EObject, Map<EClass, Set<EObject>>> model,
			Set<EObject> selectedEObjects, String title, Image image,
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
					Set<EObject> l = (Set<EObject>) entry.getValue();
					for (EObject ge : l) {
						selectedEObjects.add(ge);
					}
				} else if (entry.getValue() instanceof Map) {
					Map<EClass, Set<EObject>> map = (Map<EClass, Set<EObject>>) entry
							.getValue();
					for (Entry entry2 : map.entrySet()) {
						Set<EObject> l = (Set<EObject>) entry2.getValue();
						for (EObject ge : l) {
							selectedEObjects.add(ge);
						}
					}
				}
			} else if (element instanceof EObject) {
				selectedEObjects.add((EObject) element);
			}

		} else {
			if (element instanceof Entry) {
				Entry entry = (Entry) element;
				if (entry.getValue() instanceof Set) {
					Set<EObject> l = (Set<EObject>) entry.getValue();
					for (EObject ge : l) {
						selectedEObjects.remove(ge);
					}
				} else if (entry.getValue() instanceof Map) {
					Map<EClass, Set<EObject>> map = (Map<EClass, Set<EObject>>) entry
							.getValue();
					for (Entry entry2 : map.entrySet()) {
						Set<EObject> l = (Set<EObject>) entry2.getValue();
						for (EObject ge : l) {
							selectedEObjects.remove(ge);
						}
					}
				}
			} else if (element instanceof EObject) {
				selectedEObjects.remove((EObject) element);
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
				if ((element instanceof Entry) || (element instanceof Map)
						|| (element instanceof Set)) {
					return true;
				}
				return false;
			}

			@Override
			public Object getParent(Object element) {
				throw new IllegalAccessError();
			}

			@Override
			public Object[] getElements(Object inputElement) {
				return model.entrySet().toArray();
			}

			@Override
			public Object[] getChildren(Object parentElement) {
				if (parentElement instanceof Entry) {
					Entry entry = (Entry) parentElement;
					if (entry.getValue() instanceof Map) {
						return ((Map) entry.getValue()).entrySet().toArray();
					} else if (entry.getValue() instanceof Set) {
						return ((Set) entry.getValue()).toArray();
					}
				} else if (parentElement instanceof EObject) {
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
						for (EObject ge : (Set<EObject>) entry.getValue()) {
							if (selectedEObjects.contains(ge)) {
								numberOfSelectedElement++;
							}
						}
						return (numberOfSelectedElement > 0 && numberOfSelectedElement < totalSize);
					} else if (entry.getValue() instanceof Map) {
						Map<EClass, Set<EObject>> map = (Map<EClass, Set<EObject>>) entry
								.getValue();
						int totalSize = 0;
						int numberOfSelectedElement = 0;
						for (Entry<EClass, Set<EObject>> entry2 : map
								.entrySet()) {
							Set<EObject> set = entry2.getValue();
							totalSize = totalSize + set.size();
							for (EObject ge : set) {
								if (selectedEObjects.contains(ge)) {
									numberOfSelectedElement++;
								}
							}
						}
						return (numberOfSelectedElement > 0 && numberOfSelectedElement < totalSize);
					}
				}
				// Leaf nodes
				else if (element instanceof EObject) {
					return false;
				}
				return false;
			}

			public boolean isChecked(Object element) {
				if (element instanceof Entry) {
					Entry entry = (Entry) element;
					if (entry.getValue() instanceof Set) {
						int numberOfSelectedElement = 0;
						for (EObject ge : (Set<EObject>) entry.getValue()) {
							if (selectedEObjects.contains(ge)) {
								numberOfSelectedElement++;
							}
						}
						return numberOfSelectedElement > 0;
					} else {
						if (entry.getValue() instanceof Map) {
							Map<EClass, Set<EObject>> map = (Map<EClass, Set<EObject>>) entry
									.getValue();
							int numberOfSelectedElement = 0;
							for (Entry<EClass, Set<EObject>> entry2 : map
									.entrySet()) {
								Set<EObject> set = entry2.getValue();
								for (EObject ge : set) {
									if (selectedEObjects.contains(ge)) {
										numberOfSelectedElement++;
									}
								}
							}
							return numberOfSelectedElement > 0;
						}
					}
				} else if (element instanceof EObject) {
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
					Object key = ((Entry) element).getKey();
					if (key instanceof EClass) {
						return BasicDiagramUtil.splitCamelCase(((EClass) key).getName());
					}
				} else if (element instanceof EObject) {
					return EMFUtil.retrieveNameFrom((EObject) element);
				}
				return null;
			}

			@Override
			public Image getImage(Object element) {
				if (element instanceof Entry) {
					Entry entry = (Entry) element;
					if (entry.getKey() instanceof EClass) {
						EClass eClass = (EClass) entry.getKey();
						EObject o = EcoreUtil.create(eClass);
						return EMFUtil.getImage(o);
					}
				} else if (element instanceof EObject) {
					return EMFUtil.getImage((EObject) element);
				}
				return null;
			}
		};
	}

}
