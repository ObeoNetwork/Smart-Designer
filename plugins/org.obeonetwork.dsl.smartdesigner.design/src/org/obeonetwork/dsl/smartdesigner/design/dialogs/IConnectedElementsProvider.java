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

package org.obeonetwork.dsl.smartdesigner.design.dialogs;

import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

/**
 * Provides connected elements for the {@link SelectConnectedElementsDialog}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public interface IConnectedElementsProvider {

	/**
	 * Gets the {@link Map} of relation to related elements.
	 * 
	 * @param element
	 *            the {@link EObject element} to use as start point
	 * 
	 * @return the {@link Map} of relation to related elements
	 */
	Map<EObject, Set<EObject>> getRelatedElements(EObject element);
	
}
