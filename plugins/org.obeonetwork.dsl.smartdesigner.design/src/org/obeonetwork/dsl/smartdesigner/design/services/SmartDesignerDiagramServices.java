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
package org.obeonetwork.dsl.smartdesigner.design.services;
import org.obeonetwork.dsl.smartdesigner.Diagram;
import org.obeonetwork.dsl.smartdesigner.design.tx.SemanticResourceSelectorHandler;



/**
 * Services for the smartdesigner.Diagram.
 * 
 * @author Stephane Drapeau - Obeo
 * 
 */
public class SmartDesignerDiagramServices {

	public String getSmartDesignerDiagramLabel(Diagram diagram){
		return SemanticResourceSelectorHandler.getSemanticResourceSelector().getArtifactName(diagram.getId());
	}

}
