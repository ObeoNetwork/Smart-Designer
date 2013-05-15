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

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IRegistryEventListener;
import org.eclipse.core.runtime.Platform;

/**
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class ConnectedElementsRegistryListener implements
		IRegistryEventListener {

	/**
	 * Name of the extension point to parse for extensions.
	 */
	public static final String CONNECTED_ELEMENTS_EXTENSION_POINT = "org.obeonetwork.dsl.smartdesigner.design.connectedElements"; //$NON-NLS-1$

	/**
	 * Name of the extension point's "ConnectedElementsProvider" tag.
	 */
	private static final String CONNECTED_ELEMENTS_TAG_EXTENSION = "ConnectedElementsProvider"; //$NON-NLS-1$

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.runtime.IRegistryEventListener#added(org.eclipse.core.runtime.IExtension[])
	 */
	@Override
	public void added(IExtension[] extensions) {
		for (IExtension extension : extensions) {
			parseExtension(extension);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.runtime.IRegistryEventListener#removed(org.eclipse.core.runtime.IExtension[])
	 */
	@Override
	public void removed(IExtension[] extensions) {
		for (IExtension extension : extensions) {
			final IConfigurationElement[] configElements = extension
					.getConfigurationElements();
			for (IConfigurationElement elem : configElements) {
				if (CONNECTED_ELEMENTS_TAG_EXTENSION.equals(elem.getName())) {
					final String extensionClassName = elem
							.getAttribute(ConnectedElementsExtensionDescriptor.CONNECTED_ELEMENTS_ATTRIBUTE_EXTENSION);
					ConnectedElementsExtensionRegistry
							.removeExtension(extensionClassName);
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.runtime.IRegistryEventListener#added(org.eclipse.core.runtime.IExtensionPoint[])
	 */
	@Override
	public void added(IExtensionPoint[] extensionPoints) {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.runtime.IRegistryEventListener#removed(org.eclipse.core.runtime.IExtensionPoint[])
	 */
	@Override
	public void removed(IExtensionPoint[] extensionPoints) {
	}

	/**
	 * Though this listener reacts to the extension point changes, there could
	 * have been contributions before it's been registered. This will parse
	 * these initial contributions.
	 */
	public void parseInitialContributions() {
		final IExtensionRegistry registry = Platform.getExtensionRegistry();

		for (IExtension extension : registry.getExtensionPoint(
				CONNECTED_ELEMENTS_EXTENSION_POINT).getExtensions()) {
			parseExtension(extension);
		}
	}

	/**
	 * Parses a single extension contribution.
	 * 
	 * @param extension
	 *            Parses the given extension and adds its contribution to the
	 *            registry.
	 */
	private void parseExtension(IExtension extension) {
		final IConfigurationElement[] configElements = extension
				.getConfigurationElements();
		for (IConfigurationElement elem : configElements) {
			if (CONNECTED_ELEMENTS_TAG_EXTENSION.equals(elem.getName())) {
				ConnectedElementsExtensionRegistry
						.addExtension(new ConnectedElementsExtensionDescriptor(
								elem));
			}
		}
	}

}
