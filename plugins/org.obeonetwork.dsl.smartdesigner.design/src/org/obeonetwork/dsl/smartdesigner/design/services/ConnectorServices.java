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
package org.obeonetwork.dsl.smartdesigner.design.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.obeonetwork.dsl.smartdesigner.Diagram;
import org.obeonetwork.dsl.smartdesigner.GraphicalElement;
import org.obeonetwork.dsl.smartdesigner.design.registry.ConnectedElementsExtensionRegistry;
import org.obeonetwork.dsl.smartdesigner.design.util.BasicDiagramUtil;
import org.obeonetwork.dsl.smartdesigner.design.util.EMFUtil;

/**
 * Services for the edges.
 * 
 * @author Stephane Drapeau - Obeo
 * 
 */
public class ConnectorServices {

	/**
	 * The relation cache.
	 */
	private static Map<EObject, Map<EObject, Set<Object>>> relations = new HashMap<EObject, Map<EObject, Set<Object>>>();

	/**
	 * The extended relation cache.
	 */
	private static Map<EObject, Map<EObject, Set<EObject>>> extendedRelations = new HashMap<EObject, Map<EObject, Set<EObject>>>();

	/**
	 * Returns the label for the edge that links the GraphicalElement
	 * <code>source</code> with the graphicalElement <code>target</code>.
	 * 
	 * @param source
	 *            The GraphicalElement that is the source of the edge.
	 * @param target
	 *            The graphicalElement that is the target of the edge.
	 * @return the label for the edge that links the GraphicalElement
	 *         <code>source</code> with the graphicalElement <code>target</code>
	 *         .
	 */
	public String getLabel(GraphicalElement source, GraphicalElement target) {
		StringBuilder res = new StringBuilder();

		Map<EObject, Set<Object>> map = internalGetRelatedElements(source
				.getSemanticElement());
		for (Entry<EObject, Set<Object>> entry : map.entrySet()) {
			if (entry.getValue().contains(target.getSemanticElement())) {
				res.append(BasicDiagramUtil.splitCamelCase(EMFUtil
						.retrieveNameFrom(entry.getKey())));
				res.append("\n ");
			}
		}

		return res.substring(0, res.length() - "\n ".length());
	}

	/**
	 * Returns the label for the edge that links the GraphicalElement
	 * <code>source</code> with the graphicalElement <code>target</code>.
	 * 
	 * @param source
	 *            The GraphicalElement that is the source of the edge.
	 * @param target
	 *            The graphicalElement that is the target of the edge.
	 * @return the label for the edge that links the GraphicalElement
	 *         <code>source</code> with the graphicalElement <code>target</code>
	 *         .
	 */
	public String getExtendedLabel(GraphicalElement source,
			GraphicalElement target) {
		StringBuilder res = new StringBuilder();

		Map<EObject, Set<EObject>> map = internalGetExtendedRelatedElements(source
				.getSemanticElement());
		for (Entry<EObject, Set<EObject>> entry : map.entrySet()) {
			if (entry.getValue().contains(target.getSemanticElement())) {
				res.append(BasicDiagramUtil.splitCamelCase(EMFUtil
						.retrieveNameFrom(entry.getKey())));
				res.append("\n ");
			}
		}

		return res.substring(0, res.length() - "\n ".length());
	}

	/**
	 * Check if the connection between <code>source</code> and
	 * <code>target</code> is bidirectional. The connection is bidirectional if
	 * it exists a reference from the semantic element of <code>source</code> to
	 * the semantic element of <code>target</code> and a reference from the
	 * semantic element of <code>target</code> to the semantic element of
	 * <code>source</code>.
	 * 
	 * @param source
	 *            First GraphicalElement to consider.
	 * @param target
	 *            Second GraphicalElement to consider.
	 * @return <code>true</code> if it exists a reference from the semantic
	 *         element of <code>source</code> to the semantic element of
	 *         <code>target</code> and a reference from the semantic element of
	 *         <code>target</code> to the semantic element of
	 *         <code>source</code>. <code>false</code> otherwise.
	 */
	public boolean isBidirectionalConnector(GraphicalElement source,
			GraphicalElement target) {
		return existRelation(source.getSemanticElement(),
				target.getSemanticElement())
				&& existRelation(target.getSemanticElement(),
						source.getSemanticElement());
	}

	/**
	 * Check if the extended connection between <code>source</code> and
	 * <code>target</code> is bidirectional. The connection is bidirectional if
	 * it exists a reference from the semantic element of <code>source</code> to
	 * the semantic element of <code>target</code> and a reference from the
	 * semantic element of <code>target</code> to the semantic element of
	 * <code>source</code>.
	 * 
	 * @param source
	 *            First GraphicalElement to consider.
	 * @param target
	 *            Second GraphicalElement to consider.
	 * @return <code>true</code> if it exists a reference from the semantic
	 *         element of <code>source</code> to the semantic element of
	 *         <code>target</code> and a reference from the semantic element of
	 *         <code>target</code> to the semantic element of
	 *         <code>source</code>. <code>false</code> otherwise.
	 */
	public boolean isBidirectionalExtendedConnector(GraphicalElement source,
			GraphicalElement target) {
		return existExtendedRelation(source.getSemanticElement(),
				target.getSemanticElement())
				&& existExtendedRelation(target.getSemanticElement(),
						source.getSemanticElement());
	}

	/**
	 * Returns the list of GraphicalElement in relation with
	 * <code>graphicalElement</code>. <code>graphicalElement</code> is in
	 * relation with an other GraphicalElement B if :
	 * <ul>
	 * <li>a reference exists from <code>graphicalElement</code> to B and
	 * compare(<code>graphicalElement</code>
	 * .getSemanticElement(),B.getSemanticElement()>0).</li>
	 * <li>no reference exists from <code>graphicalElement</code> to B and
	 * compare(<code>graphicalElement</code>
	 * .getSemanticElement(),B.getSemanticElement()>0) and a reference exists
	 * from B to <code>graphicalElement</code>.</li>
	 * </ul>
	 * 
	 * @param graphicalElement
	 *            The GraphicalElement for which we are looking the list of
	 *            GraphicalElement in relation with.
	 * @return the list of GraphicalElement in relation with
	 *         <code>graphicalElement</code>.
	 */
	public List<GraphicalElement> getRelatedElements(
			GraphicalElement graphicalElement) {
		Diagram diagram = BasicDiagramUtil.getDiagram(graphicalElement);
		if (diagram == null) {
			return new ArrayList<GraphicalElement>();
		}
		Set<GraphicalElement> resultSet = new HashSet<GraphicalElement>();
		for (GraphicalElement ge : getAllGraphicalElements(diagram)) {
			if (ge != graphicalElement) {
				EObject sourceObject = graphicalElement.getSemanticElement();
				EObject targetObject = ge.getSemanticElement();
				if (sourceObject != null && targetObject != null
						&& compare(sourceObject, targetObject) > 0 && //
						!isAncestor(graphicalElement, ge) && //
						!isAncestor(ge, graphicalElement) && //
						(//
						existRelation(sourceObject, targetObject)//
						|| //
						existRelation(targetObject, sourceObject)//
						)//
				) {
					resultSet.add(ge);
				}
			}
		}
		return new ArrayList<GraphicalElement>(resultSet);
	}

	private boolean isAncestor(GraphicalElement potentialAncestor,
			GraphicalElement potentialChild) {
		if (potentialAncestor == potentialChild) {
			return true;
		} else {
			EObject childContainer = potentialChild.eContainer();
			if (childContainer != null
					&& childContainer instanceof GraphicalElement) {
				if (childContainer == potentialAncestor) {
					return true;
				} else {
					return isAncestor(potentialAncestor,
							(GraphicalElement) childContainer);
				}
			} else {
				return false;
			}
		}
	}

	private Collection<GraphicalElement> getAllGraphicalElements(Diagram diagram) {
		Collection<GraphicalElement> elements = new ArrayList<GraphicalElement>();
		elements.addAll(diagram.getElements());
		for (GraphicalElement graphicalElement : diagram.getElements()) {
			elements.addAll(getAllGraphicalElements(graphicalElement));
		}
		return elements;
	}

	private Collection<GraphicalElement> getAllGraphicalElements(
			GraphicalElement graphicalElement) {
		Collection<GraphicalElement> elements = new ArrayList<GraphicalElement>();
		elements.addAll(graphicalElement.getChild());
		for (GraphicalElement child : graphicalElement.getChild()) {
			elements.addAll(getAllGraphicalElements(child));
		}
		return elements;
	}

	public List<GraphicalElement> getExtendedRelatedElements(
			GraphicalElement graphicalElement) {
		Diagram diagram = BasicDiagramUtil.getDiagram(graphicalElement);
		final Set<GraphicalElement> resultSet = new HashSet<GraphicalElement>();
		if (diagram != null) {
			for (GraphicalElement ge : getAllGraphicalElements(diagram)) {
				if (ge != graphicalElement) {
					EObject sourceObject = graphicalElement
							.getSemanticElement();
					EObject targetObject = ge.getSemanticElement();
					if (sourceObject != null && targetObject != null
							&& compare(sourceObject, targetObject) > 0 && //
							!isAncestor(graphicalElement, ge) && //
							!isAncestor(ge, graphicalElement) && //
							(//
							existExtendedRelation(sourceObject, targetObject)//
							|| //
							existExtendedRelation(targetObject, sourceObject)//
							)//
					) {
						resultSet.add(ge);
					}
				}
			}
		}
		return new ArrayList<GraphicalElement>(resultSet);
	}

	/**
	 * Checks if a reference exists between <code>sourceObject</code> and
	 * <code>targetObject</code>.
	 * 
	 * @param sourceObject
	 *            EObject for which we are looking for a reference to
	 *            <code>targetObject</code>.
	 * @param targetObject
	 *            EObject for which we are looking for a reference from
	 *            <code>sourceObject</code>.
	 * @return True if a reference exists between <code>sourceObject</code> and
	 *         <code>targetObject</code>, false otherwise.
	 */
	public boolean existRelation(EObject sourceObject, EObject targetObject) {
		boolean res = false;

		Map<EObject, Set<Object>> map = internalGetRelatedElements(sourceObject);
		for (Entry<EObject, Set<Object>> entry : map.entrySet()) {
			if (entry.getValue().contains(targetObject)) {
				res = true;
				break;
			}
		}

		return res;
	}

	/**
	 * Tells if there is an extended relation from {@link EObject sourceObject}
	 * to {@link EObject targetObject}
	 * 
	 * @param sourceObject
	 *            the source {@link EObject}
	 * @param targetObject
	 *            the target {@link EObject}
	 * @return <code>true</code> if there is an extended relation from
	 *         {@link EObject sourceObject} to {@link EObject targetObject},
	 *         <code>false</code> otherwise
	 */
	public boolean existExtendedRelation(EObject sourceObject,
			EObject targetObject) {
		boolean res = false;

		Map<EObject, Set<EObject>> map = internalGetExtendedRelatedElements(sourceObject);
		for (Entry<EObject, Set<EObject>> entry : map.entrySet()) {
			if (entry.getValue().contains(targetObject)) {
				res = true;
				break;
			}
		}

		return res;
	}

	/**
	 * A comparison function used to compare <code>sourceObject</code> and
	 * <code>targetObject</code>.
	 * 
	 * @param sourceObject
	 *            First object to compare.
	 * @param targetObject
	 *            Second object to compare.
	 * @return an int, result of the comparison of <code>sourceObject</code> and
	 *         <code>targetObject</code>.
	 */
	private int compare(EObject sourceObject, EObject targetObject) {
		int result = ((CDOObject) sourceObject).cdoID().compareTo(
				((CDOObject) targetObject).cdoID());
		return result;
		// return sourceObject.toString().compareTo(targetObject.toString());
	}

	/**
	 * Gets related elements for the given {@link EObject}.
	 * 
	 * @param eObj
	 *            the {@link EObject}
	 * @return related elements for the given {@link EObject}
	 */
	private Map<EObject, Set<Object>> internalGetRelatedElements(EObject eObj) {
		Map<EObject, Set<Object>> res = relations.get(eObj);
		if (res == null) {
			res = new LinkedHashMap<EObject, Set<Object>>();

			for (EReference ref : eObj.eClass().getEAllReferences()) {
				final Object value = eObj.eGet(ref);
				if (value instanceof List) {
					res.put(ref, new HashSet<Object>((List<?>) value));
				} else if (value != null) {
					final HashSet<Object> set = new HashSet<Object>();
					set.add(value);
					res.put(ref, set);
				}
			}

			relations.put(eObj, res);
		}
		return res;
	}

	/**
	 * Gets the
	 * {@link ConnectedElementsExtensionRegistry#getExtendedRelatedElements(EObject)
	 * extended related elements} of the given {@link EObject}
	 * 
	 * @param eObj
	 * @return
	 */
	private Map<EObject, Set<EObject>> internalGetExtendedRelatedElements(
			EObject eObj) {
		Map<EObject, Set<EObject>> res = extendedRelations.get(eObj);
		if (res == null) {
			res = ConnectedElementsExtensionRegistry
					.getExtendedRelatedElements(eObj);
			extendedRelations.put(eObj, res);
		}
		return res;
	}

	/**
	 * Clears caches.
	 */
	public static void clearCache() {
		relations.clear();
		extendedRelations.clear();
	}

}
