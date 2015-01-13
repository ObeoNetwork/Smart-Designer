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
package org.obeonetwork.dsl.smartdesigner.design.actions;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.PlatformUI;
import org.obeonetwork.dsl.smartdesigner.Diagram;
import org.obeonetwork.dsl.smartdesigner.GraphicalElement;
import org.obeonetwork.dsl.smartdesigner.design.popups.DeletePopup;
import org.obeonetwork.dsl.smartdesigner.design.util.BasicDiagramUtil;

import fr.obeo.dsl.viewpoint.DEdge;
import fr.obeo.dsl.viewpoint.tools.api.ui.IExternalJavaAction;

/**
 * The java action that implements the Delete action.
 * 
 * @author Stephane Drapeau - Obeo
 * 
 */
public class DeleteGraphicalElement implements IExternalJavaAction {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.obeo.dsl.viewpoint.tools.api.ui.IExternalJavaAction#canExecute(java
	 * .util.Collection)
	 */
	@Override
	public boolean canExecute(Collection<? extends EObject> selections) {
		// Always true.
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.obeo.dsl.viewpoint.tools.api.ui.IExternalJavaAction#execute(java.util
	 * .Collection, java.util.Map)
	 */
	@Override
	public void execute(Collection<? extends EObject> selections,
			Map<String, Object> parameters) {

		Object oView = parameters.get("elementView");
		if(oView instanceof DEdge){
			DEdge dEdge = (DEdge) oView;
			deleteEdge(dEdge);
			return;
		}
		
		Object o = parameters.get("element");
		if (o instanceof GraphicalElement) {
			GraphicalElement graphicalElement = (GraphicalElement) o;
			EObject semanticElement = graphicalElement.getSemanticElement();
			int result = deleteElement(graphicalElement, semanticElement);
			if (result == -1) {
				// Nothing to do.
			} else if (result == 0) {
				// Delete the semantic element and the graphical representation
				if (semanticElement == null) {
					// The semantic element can be null.
					removeEObject(graphicalElement);
				} else {
					List<GraphicalElement> graphicalElements = BasicDiagramUtil
							.getGraphicalElementsWhereSemanticElementAppears(
									BasicDiagramUtil
											.getDocumentRoot(graphicalElement),
									semanticElement);
					removeEObject(semanticElement);
					// Delete all the graphical elements that have the object
					// semanticElement as semantic element.
					for (GraphicalElement ge : graphicalElements) {
						removeEObject(ge);
					}
				}
			} else if (result == 1) {
				// Delete only the graphical representation
				removeEObject(graphicalElement);
			}
			// In the case of deleting a diagram
//		} else if (o instanceof Diagram) {
//			Diagram diagram = (Diagram) o;
//			Object parentElement = parameters.get("parentElement");
//			// delete the reference between the parent diagram (container) and
//			// its son (the contained)
//			if (parentElement instanceof GraphicalElement) {
//				((GraphicalElement) parentElement).getDiagrams()
//						.remove(diagram);
//			}
//			} else if (parentElement instanceof Diagram) {
//				((Diagram) parentElement).getDiagrams().remove(diagram);
//			}

		}

		else {
			return;
		}

	}

	protected void deleteEdge(DEdge dEdge) {
		// Nothing
	}

	/**
	 * Treatment that opens a dialog asking the user if he wants to remove only
	 * the graphical element or the graphical element and the semantic element.
	 * 
	 * @param graphicalElement
	 *            Graphical element to delete
	 * @param semanticElement
	 *            Semantic element to delete
	 * @returns -1 == nothing to do ; 0 == delete the semantic element ; 1 =
	 *          delete only the graphical representation
	 */
	protected int deleteElement(GraphicalElement graphicalElement,
			EObject semanticElement) {
		DeletePopup dialog = new DeletePopup(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell());
		dialog.setBlockOnOpen(true);
		dialog.open();
		return dialog.getResult();
	}

	/**
	 * Remove the EObject <code>element</code> from his container and unset all
	 * his references and cross references.
	 * 
	 * @param element
	 *            The EObject to remove.
	 */
	private void removeEObject(EObject element) {
		if (element == null) {
			return;
		}
		// Unset all references to avoid dangling references
		for (EStructuralFeature sf : element.eClass()
				.getEAllStructuralFeatures()) {
			element.eUnset(sf);
		}
		EcoreUtil.delete(element, true);
	}

}
