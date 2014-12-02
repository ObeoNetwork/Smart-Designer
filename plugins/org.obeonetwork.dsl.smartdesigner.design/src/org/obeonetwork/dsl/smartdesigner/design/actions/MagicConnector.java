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
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ui.PlatformUI;
import org.obeonetwork.dsl.smartdesigner.GraphicalElement;
import org.obeonetwork.dsl.smartdesigner.design.popups.InformationPopup;
import org.obeonetwork.dsl.smartdesigner.design.popups.MagicConnectorPopup;
import org.obeonetwork.dsl.smartdesigner.design.util.EMFUtil;

import fr.obeo.dsl.viewpoint.tools.api.ui.IExternalJavaAction;

/**
 * The java action that implements the Magic Connector.
 * 
 * @author Stephane Drapeau - Obeo
 * 
 */
public class MagicConnector implements IExternalJavaAction {

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

		GraphicalElement source = null;
		Object o = parameters.get("source");
		if (o instanceof GraphicalElement) {
			source = (GraphicalElement) o;
		} else {
			return;
		}

		GraphicalElement target = null;
		o = parameters.get("target");
		if (o instanceof GraphicalElement) {
			target = (GraphicalElement) o;
		} else {
			return;
		}

		EObject sourceElement = source.getSemanticElement();
		EObject targetElement = target.getSemanticElement();

		List<EReference> references = EMFUtil.getReferencesBetween(
				sourceElement, targetElement);

		if (references.size() == 0) {
			// No reference between sourceElement and targetElement.
			noReferenceTreatment();
		} else if (references.size() == 1) {
			// Only one reference between sourceElement and targetElement.
			oneReferenceTreatment(sourceElement, targetElement,
					references.get(0));
		} else {
			manyReferencesTreatment(sourceElement, targetElement, references);
		}
	}

	/**
	 * Treatment to do if more than one EReference exist between sourceElement
	 * and targetElement.
	 * 
	 * @param sourceElement
	 * @param targetElement
	 * @param references
	 *            The list of EReference between sourceElement and
	 *            targetElement.
	 */
	protected void manyReferencesTreatment(EObject sourceElement,
			EObject targetElement, List<EReference> references) {
		MagicConnectorPopup dialog = new MagicConnectorPopup(PlatformUI
				.getWorkbench().getActiveWorkbenchWindow().getShell(),
				references);
		dialog.setBlockOnOpen(true);
		dialog.open();
		EReference referenceSelected = dialog.getResult();
		if (referenceSelected == null) {
			// No EReference selected.
			return;
		}
		EMFUtil.setEReference(sourceElement, targetElement, referenceSelected);
	}

	/**
	 * Treatment to do if only one reference exists between sourceElement and
	 * targetElement.
	 * 
	 * @param sourceElement
	 * @param targetElement
	 * @param reference
	 *            The EReference between sourceElement and targetElement.
	 */
	protected void oneReferenceTreatment(EObject sourceElement,
			EObject targetElement, EReference reference) {
		InformationPopup dialog = new InformationPopup(PlatformUI
				.getWorkbench().getActiveWorkbenchWindow().getShell(), 0, true,
				true, true, false, true, "1 reference available: "
						+ reference.getName(), null);
		dialog.open();
		EMFUtil.setEReference(sourceElement, targetElement, reference);
	}

	/**
	 * Treatment to do if no reference between the sourceElement and the
	 * targetElement exists.
	 */
	protected void noReferenceTreatment() {
		InformationPopup dialog = new InformationPopup(PlatformUI
				.getWorkbench().getActiveWorkbenchWindow().getShell(), 0, true,
				true, true, false, true, "No direct reference available", null);
		dialog.open();
	}

}
