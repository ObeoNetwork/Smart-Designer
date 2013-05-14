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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
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

	/**
	 * A Node class used in the
	 * 
	 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
	 */
	private static final class Node {

		/**
		 * The targeted {@link Object}. It basically comes from
		 * {@link SelectConnectedElementsDialog#model}.
		 */
		private final Object target;

		/**
		 * The parent {@link Node}.
		 */
		private final Node parent;

		/**
		 * The relation that connect the {@link Node#parent parent} to its
		 * {@link Node#children}. For instance an {@link EReference}.
		 */
		private final EObject parentRelation;

		/**
		 * Children {@link Node}.
		 */
		private Set<Node> children;

		/**
		 * Constructor.
		 * 
		 * @param parent
		 *            the parent {@link Node}
		 * @param target
		 *            the targeted {@link Object}. It basically comes from
		 *            {@link SelectConnectedElementsDialog#model}
		 */
		public Node(Node parent, EObject parentRelation, Object target) {
			this.parent = parent;
			this.parentRelation = parentRelation;
			this.target = target;
		}

		/**
		 * Tells if the given {@link Object} is a {@link Node#target target} of
		 * the {@link Node#parent parent} path.
		 * 
		 * @param obj
		 *            the {@link Object} to check
		 * @return <code>true</code> if the given {@link Object} is a
		 *         {@link Node#target target} of the {@link Node#parent parent}
		 *         path
		 */
		public boolean isOnPath(Object obj) {
			return target == obj || (parent != null && parent.isOnPath(obj));
		}

		public Set<Node> getChildren() {
			if (children == null) {
				children = new LinkedHashSet<Node>();
				if (target instanceof Entry) {
					if (((Entry<?, ?>) target).getValue() instanceof Map) {
						final Set<Entry> entrySet = ((Map) ((Entry) target)
								.getValue()).entrySet();
						for (Entry entry : entrySet) {
							children.add(new Node(this, null, entry));
						}
					} else if (((Entry) target).getValue() instanceof Set) {
						for (Object obj : ((Set) ((Entry) target).getValue())) {
							children.add(new Node(this, null, obj));
						}
					}
				} else if (target instanceof EObject) {
					for (Entry<EObject, Set<EObject>> entry : getRelatedElements(
							(EObject) target).entrySet()) {
						for (EObject eObj : entry.getValue()) {
							children.add(new Node(this, entry.getKey(), eObj));
						}
					}
				}
			}
			return children;
		}

		/**
		 * Gets the {@link Map} of relation to related elements.
		 * 
		 * @param element
		 *            the {@link EObject element} to use as start point
		 * 
		 * @return the {@link Map} of relation to related elements
		 */
		protected Map<EObject, Set<EObject>> getRelatedElements(EObject element) {
			Map<EObject, Set<EObject>> res = new LinkedHashMap<EObject, Set<EObject>>();
			for (EReference eRef : element.eClass().getEAllReferences()) {
				Object value = element.eGet(eRef);
				res.put(eRef, new LinkedHashSet<EObject>());
				if (value instanceof EObject) {
					if (!isOnPath(value)) {
						res.get(eRef).add((EObject) value);
					}
				} else if (value instanceof List<?>) {
					for (Object o : (List<?>) value) {
						if (o instanceof EObject) {
							if (!isOnPath(o)) {
								res.get(eRef).add((EObject) o);
							}
						}
					}
				}
			}
			return res;
		}
	}

	private Map<EObject, Map<EClass, Set<EObject>>> model;

	private List<Node> roots;

	/**
	 * Selected {@link Node}.
	 */
	private final Set<Node> selectedNodes = new HashSet<Node>();

	public SelectConnectedElementsDialog(Shell parent,
			Map<EObject, Map<EClass, Set<EObject>>> model, String title,
			Image image, int width, int height) {
		super(parent, title, image, width, height);
		this.model = model;
	}

	public void setSelected(Object element, boolean selected) {
		Object target = ((Node) element).target;
		if (selected) {
			if (target instanceof Entry) {
				selectedNodes.addAll(((Node) element).getChildren());
			} else if (target instanceof EObject) {
				Node node = ((Node) element);
				while (node != null) {
					selectedNodes.add(node);
					node = node.parent;
				}
			}
		} else {
			if (target instanceof Entry) {
				selectedNodes.removeAll(((Node) element).getChildren());
			} else if (target instanceof EObject) {
				Node node = ((Node) element);
				while (node != null) {
					selectedNodes.remove(node);
					node = node.parent;
				}
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
				return ((Node) element).getChildren().size() > 0;
			}

			@Override
			public Object getParent(Object element) {
				return ((Node) element).parent;
			}

			@Override
			public Object[] getElements(Object inputElement) {

				if (roots == null) {
					roots = new ArrayList<Node>();

					for (Entry<EObject, Map<EClass, Set<EObject>>> entry : model
							.entrySet()) {
						roots.add(new Node(null, null, entry));
					}
				}

				return roots.toArray();
			}

			@Override
			public Object[] getChildren(Object parentElement) {
				return ((Node) parentElement).getChildren().toArray();
			}

		};
	}

	public ICheckStateProvider createCheckStateProvider() {
		return new ICheckStateProvider() {
			public boolean isGrayed(Object element) {

				int nbContained = 0;
				for (Node child : ((Node) element).getChildren()) {
					if (selectedNodes.contains(child)) {
						++nbContained;
					}
				}
				return selectedNodes.contains(element) && nbContained > 0
						&& nbContained < ((Node) element).getChildren().size();
			}

			public boolean isChecked(Object element) {
				return selectedNodes.contains(element);
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
				final Object target = ((Node) element).target;
				if (target instanceof Entry) {
					Object key = ((Entry<?, ?>) target).getKey();
					if (key instanceof EClass) {
						return BasicDiagramUtil.splitCamelCase(((EClass) key)
								.getName());
					}
				} else if (target instanceof EObject) {
					StringBuilder label = new StringBuilder(512);
					label.append(EMFUtil.retrieveNameFrom((EObject) target));
					final EObject parentRelation = ((Node) element).parentRelation;
					if (parentRelation != null) {
						label.append(" (");
						label.append(EMFUtil.retrieveNameFrom(parentRelation));
						label.append(")");
					}
					return label.toString();
				}
				return null;
			}

			@Override
			public Image getImage(Object element) {
				final Object target = ((Node) element).target;
				if (target instanceof Entry) {
					Entry<?, ?> entry = (Entry<?, ?>) target;
					if (entry.getKey() instanceof EClass) {
						EClass eClass = (EClass) entry.getKey();
						EObject o = EcoreUtil.create(eClass);
						return EMFUtil.getImage(o);
					}
				} else if (target instanceof EObject) {
					return EMFUtil.getImage((EObject) target);
				}
				return null;
			}
		};
	}

	/**
	 * Gets selected {@link EObject}.
	 * 
	 * @return selected {@link EObject}
	 */
	public Set<EObject> getSelectedEObjects() {
		Set<EObject> res = new HashSet<EObject>();

		for (Node node : selectedNodes) {
			if (node.target instanceof EObject) {
				res.add((EObject) node.target);
			}
		}

		return res;
	}

}
