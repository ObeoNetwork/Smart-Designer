/*******************************************************************************
 * Copyright (c) 2010-2011 Obeo. All Rights Reserved.
 *
 * This file is part of Obeo Agility.
 *
 * This software and the attached documentation are the exclusive ownership
 * of its authors and was conceded to the profit of Obeo SARL.
 * This software and the attached documentation are protected under the rights
 * of intellectual ownership, including the section "Titre II  Droits des auteurs (Articles L121-1 L123-12)"
 * By installing this software, you acknowledge being aware of this rights and
 * accept them, and as a consequence you must:
 * - be in possession of a valid license of use conceded by Obeo only.
 * - agree that you have read, understood, and will comply with the license terms and conditions.
 * - agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries
 * or the authors of this software
 *
 * Should you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.
 *
 * Acceleo and Obeo are trademarks owned by Obeo.
 *
 *******************************************************************************/

package org.obeonetwork.dsl.smartdesigner.design.providers;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.obeonetwork.dsl.smartdesigner.design.graphical.edit.policies.SmartPopupBarEditPolicy;

import fr.obeo.dsl.viewpoint.diagram.edit.api.part.IDDiagramEditPart;
import fr.obeo.dsl.viewpoint.diagram.edit.api.part.IDiagramElementEditPart;

/**
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class SmartPopupBarEditpolicyProvider extends AbstractProvider implements
		IEditPolicyProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#provides(org.eclipse.gmf.runtime.common.core.service.IOperation)
	 */
	@Override
	public boolean provides(IOperation operation) {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider#createEditPolicies(org.eclipse.gef.EditPart)
	 */
	@Override
	public void createEditPolicies(EditPart editPart) {
			editPart.installEditPolicy(EditPolicyRoles.POPUPBAR_ROLE,
					new SmartPopupBarEditPolicy());
	}

}
