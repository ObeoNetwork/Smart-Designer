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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.obeonetwork.dsl.smartdesigner.design.Activator;
import org.obeonetwork.dsl.smartdesigner.design.dialogs.IConnectedElementsProvider;

/**
 * Describes a extension as contributed to the
 * "org.obeonetwork.dsl.smartdesigner.design.connectedElements" extension point.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class ConnectedElementsExtensionDescriptor {

	/**
	 * Name of the connected elements extension point's tag
	 * "connectedElementsProvider" attribute.
	 */
	public static final String CONNECTED_ELEMENTS_ATTRIBUTE_EXTENSION = "connectedElementsProvider"; //$NON-NLS-1$

	/**
	 * Configuration element of this descriptor.
	 */
	private final IConfigurationElement element;

	/**
	 * Qualified class name of the connected elements extension. This will be
	 * used as an id to remove contributions.
	 */
	private final String extensionClassName;

	/**
	 * The {@link IConnectedElementsProvider}.
	 */
	private IConnectedElementsProvider provider;

	/**
	 * Constructor.
	 * 
	 * @param configuration
	 *            configuration element from which to create this descriptor.
	 */
	public ConnectedElementsExtensionDescriptor(
			IConfigurationElement configuration) {
		element = configuration;
		extensionClassName = configuration
				.getAttribute(CONNECTED_ELEMENTS_ATTRIBUTE_EXTENSION);
	}

	/**
	 * Returns this descriptor's "connectedElementsProvider" class name.
	 * 
	 * @return this descriptor's "connectedElementsProvider" class name.
	 */
	public String getExtensionClassName() {
		return extensionClassName;
	}

	/**
	 * Creates an instance of this descriptor's
	 * {@link IConnectedElementsProvider}.
	 * 
	 * @return a new instance of this descriptor's
	 *         {@link IConnectedElementsProvider}.
	 */
	public IConnectedElementsProvider getConnectedElementsProvider() {
		if (provider == null) {
			try {
				provider = (IConnectedElementsProvider) element
						.createExecutableExtension(CONNECTED_ELEMENTS_ATTRIBUTE_EXTENSION);
			} catch (CoreException e) {
				Activator
						.getDefault()
						.getLog()
						.log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e
								.getLocalizedMessage(), e));
			}
		}
		return provider;
	}

}
