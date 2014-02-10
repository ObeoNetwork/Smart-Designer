/*******************************************************************************
 * Copyright (c) 2011-2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.smartdesigner.design.tx;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

/**
 * @author SDrapeau
 * 
 */
public class SemanticResourceSelectorHandler {

	private static ISemanticResourceSelector semanticResourceSelector = init();

	private static final String TX_SELECTOR_ID = "org.obeonetwork.dsl.smartdesigner.design.tx";

	private static ISemanticResourceSelector init() {
		IConfigurationElement[] contributions = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(TX_SELECTOR_ID);
		IConfigurationElement ce = null;
		for (int i = 0; i < contributions.length; i++) {
			ce = contributions[i];
		}

		ISemanticResourceSelector srl = null;
		if (ce != null) {
			try {
				srl = (ISemanticResourceSelector) ce
						.createExecutableExtension("class");
			} catch (CoreException e) {
				//Nada
			}
		}
		return srl;
	}

	public static ISemanticResourceSelector getSemanticResourceSelector() {
		return semanticResourceSelector;
	}

}
