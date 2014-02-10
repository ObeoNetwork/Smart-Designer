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


/**
 * Selector to get the transaction.
 * 
 * @author SDrapeau
 * 
 */
public interface ISemanticResourceSelector {

	/**
	 * @return the artifact name.
	 * @return
	 */
	public String getArtifactName(long artifactId);

}
