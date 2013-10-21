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
package org.obeonetwork.dsl.smartdesigner.design.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.smartdesigner.Diagram;
import org.obeonetwork.dsl.smartdesigner.DocumentRoot;
import org.obeonetwork.dsl.smartdesigner.GraphicalElement;

import com.google.common.collect.Sets;

import fr.obeo.dsl.viewpoint.DDiagram;
import fr.obeo.dsl.viewpoint.DDiagramElement;

/**
 * Utility class for the Basic Diagram.
 * 
 * @author Stephane Drapeau - Obeo
 * 
 */
public class BasicDiagramUtil {

	/**
	 * Returns the Diagram containing the Object. <code>object</code>.
	 * 
	 * @param object
	 *            The Object for which we are looking for the Diagram.
	 * @return The Diagram containing the Object <code>object</code>. Null if
	 *         the Object <code>object</code> is not containing in a Diagram or
	 *         is not a Diagram.
	 */
	public static Diagram getDiagram(Object object) {
		Diagram diagram = null;
		if (object instanceof Diagram) {
			diagram = (Diagram) object;
		} else if (object instanceof GraphicalElement) {
			EObject eo = (EObject) object;
			while (eo != null && diagram == null) {
				if (eo instanceof Diagram) {
					diagram = (Diagram) eo;
				} else {
					eo = eo.eContainer();
				}
			}
		}
		return diagram;
	}

	/**
	 * Converts the String <code>s</code> to camel case.
	 * 
	 * @param s
	 *            The String to split.
	 * @return the String <code>s</code> split to camel case.
	 */
	public static String splitCamelCase(String s) {
		return s.replaceAll(String.format("%s|%s|%s",
				"(?<=[A-Z])(?=[A-Z][a-z])", "(?<=[^A-Z])(?=[A-Z])",
				"(?<=[A-Za-z])(?=[^A-Za-z])"), " ");
	}

	/**
	 * Returns a map of GraphicalElement that are in the DDiagram
	 * <code>diagram</code>.
	 * 
	 * @param diagram
	 * @return
	 */
	public static Map<EClass, List<GraphicalElement>> getGraphicalElements(
			DDiagram diagram) {
		Map<EClass, List<GraphicalElement>> graphicalElements = new HashMap<EClass, List<GraphicalElement>>();
		for (DDiagramElement element : diagram.getDiagramElements()) {
			for (EObject eo : element.getSemanticElements()) {
				if (eo instanceof GraphicalElement) {
					GraphicalElement ge = (GraphicalElement) eo;
					List<GraphicalElement> l = graphicalElements
							.get(((GraphicalElement) eo).getSemanticElement()
									.eClass());
					if (l == null) {
						l = new ArrayList<GraphicalElement>();
						graphicalElements.put(ge.getSemanticElement().eClass(),
								l);
					}
					l.add(ge);
				}
			}
		}
		return graphicalElements;
	}

	/**
	 * Returns the set of GraphicalElement that are hidden in DDiagram
	 * <code>diagram</code>.
	 * 
	 * @param diagram
	 *            The DDiagram where to find the GraphicalElement hidden.
	 * @return The set of GraphicalElement that are hidden in DDiagram
	 *         <code>diagram</code>.
	 */
	public static Set<GraphicalElement> getHiddenElements(DDiagram diagram) {
		Set<GraphicalElement> result = Sets.newHashSet();
		for (DDiagramElement element : diagram.getDiagramElements()) {
			for (EObject eo : element.getSemanticElements()) {
				if (eo instanceof GraphicalElement
						&& ((GraphicalElement) eo).isHidden()) {
					result.add((GraphicalElement) eo);
				}
			}
		}
		return result;
	}

	/**
	 * Returns the set of cross referenced objects. This is the list of EObjects
	 * that have a cross reference with
	 * <code>graphicalElement.getSemanticObject()</code>.
	 * 
	 * @param graphicalElement
	 *            GraphicalElement to find the cross referenced semantic
	 *            objects.
	 * @return the set of cross referenced objects.
	 */
	public static Set<EObject> getCrossReferencedElements(
			GraphicalElement graphicalElement) {
		List<EObject> crossReferencesL = new ArrayList<EObject>();
		crossReferencesL.addAll(graphicalElement.getSemanticElement()
				.eCrossReferences());
		crossReferencesL.addAll(graphicalElement.getSemanticElement().eContents());
		Collections.sort(crossReferencesL, new Comparator<EObject>() {
			@Override
			public int compare(EObject o1, EObject o2) {
				return o1.eClass().getName().compareTo(o2.eClass().getName());
			}
		});
		Set<EObject> crossReferences = new LinkedHashSet<EObject>(
				crossReferencesL);
		return crossReferences;
	}

	/**
	 * Returns the DocumentRoot containing the Object. <code>object</code>.
	 * 
	 * @param object
	 *            The Object for which we are looking for the DocumentRoot.
	 * @return The DocumentRoot containing the Object <code>object</code>.
	 */
	public static DocumentRoot getDocumentRoot(EObject object) {
		DocumentRoot root = null;
		EObject eo = (EObject) object;
		while (eo != null && root == null) {
			if (eo instanceof DocumentRoot) {
				root = (DocumentRoot) eo;
			} else {
				eo = eo.eContainer();
			}
		}
		return root;
	}

	/**
	 * Returns the list of graphical elements where the semantic element
	 * <code>semanticElement</code> appears.
	 * 
	 * @param documentRoot
	 *            The DocumentRoot element of the Basic Designer model that must
	 *            be considered as the start of the search.
	 * @param semanticElement
	 * @return
	 */
	public static List<GraphicalElement> getGraphicalElementsWhereSemanticElementAppears(
			DocumentRoot documentRoot, EObject semanticElement) {
		List<GraphicalElement> result = new ArrayList<GraphicalElement>();
		for (Diagram diag : documentRoot.getDiagrams()) {
			for (GraphicalElement ge : diag.getElements()) {
				result.addAll(getGraphicalElementsWhereSemanticElementAppears(
						ge, semanticElement));
			}
		}
		return result;
	}

	/**
	 * 
	 * Returns the list of graphical elements where the semantic element
	 * <code>semanticElement</code> appears.
	 * 
	 * @param graphicalElement
	 *            The root element that must be considered as the start of the
	 *            search.
	 * @param semanticElement
	 * @return
	 */
	private static List<GraphicalElement> getGraphicalElementsWhereSemanticElementAppears(
			GraphicalElement graphicalElement, EObject semanticElement) {
		List<GraphicalElement> result = new ArrayList<GraphicalElement>();
		if (semanticElement.equals(graphicalElement.getSemanticElement())) {
			result.add(graphicalElement);
		}
		for (GraphicalElement ge : graphicalElement.getChild()) {
			result.addAll(getGraphicalElementsWhereSemanticElementAppears(ge,
					semanticElement));
		}
		return result;
	}

}
