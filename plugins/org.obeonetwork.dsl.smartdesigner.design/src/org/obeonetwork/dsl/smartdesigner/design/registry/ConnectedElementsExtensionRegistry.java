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

package org.obeonetwork.dsl.smartdesigner.design.registry;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

/**
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class ConnectedElementsExtensionRegistry {

	/**
	 * List of extensions created from the extension point contributions.
	 */
	private static final List<ConnectedElementsExtensionDescriptor> EXTENSIONS = new ArrayList<ConnectedElementsExtensionDescriptor>();

	/**
	 * Constructor.
	 */
	private ConnectedElementsExtensionRegistry() {
	}

	/**
	 * Adds an extension to the registry.
	 * 
	 * @param extension
	 *            The extension that is to be added to the registry.
	 */
	public static void addExtension(
			ConnectedElementsExtensionDescriptor extension) {
		EXTENSIONS.add(extension);
	}

	/**
	 * Removes all extensions from the registry. This will be called at plugin
	 * stopping.
	 */
	public static void clearRegistry() {
		EXTENSIONS.clear();
	}

	/**
	 * Returns a copy of the registered extensions list.
	 * 
	 * @return A copy of the registered extensions list.
	 */
	public static List<ConnectedElementsExtensionDescriptor> getRegisteredExtensions() {
		return new ArrayList<ConnectedElementsExtensionDescriptor>(EXTENSIONS);
	}

	/**
	 * Removes a phantom from the registry.
	 * 
	 * @param syncElementClassName
	 *            Qualified class name of the sync element which corresponding
	 *            phantom is to be removed from the registry.
	 */
	public static void removeExtension(String extensionClassName) {
		for (ConnectedElementsExtensionDescriptor extension : getRegisteredExtensions()) {
			if (extension.getExtensionClassName().equals(extensionClassName)) {
				EXTENSIONS.remove(extension);
			}
		}
	}

	/**
	 * Gets the {@link Map} of relation to related elements.
	 * 
	 * @param element
	 *            the {@link EObject element} to use as start point
	 * 
	 * @return the {@link Map} of relation to related elements
	 */
	public static Map<EObject, Set<EObject>> getExtendedRelatedElements(
			EObject element) {
		Map<EObject, Set<EObject>> res = new LinkedHashMap<EObject, Set<EObject>>();
		for (ConnectedElementsExtensionDescriptor extension : getRegisteredExtensions()) {
			final Map<EObject, Set<EObject>> relatedElements = extension
					.getConnectedElementsProvider().getRelatedElements(element);
			if (relatedElements != null) {
				res.putAll(relatedElements);
			}
		}
		return res;
	}

}
