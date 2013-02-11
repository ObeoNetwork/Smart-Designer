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
package org.obeonetwork.dsl.smartdesigner.design.dialogs;

/**
 * 
 * @author Stephane Drapeau - Obeo
 *
 */
public class ViewpointID {

	private String viewpointType;
	
	private String viewpointName;
	
	public ViewpointID(String viewpointType, String viewpointName){
		this.viewpointType=viewpointType;
		this.viewpointName=viewpointName;
	}

	public String getViewpointType() {
		return viewpointType;
	}

	public String getViewpointName() {
		return viewpointName;
	}
	
}
