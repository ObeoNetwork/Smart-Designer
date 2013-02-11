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
package org.obeonetwork.dsl.smartdesigner.design;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 * 
 * @author Stephane Drapeau - Obeo
 * 
 */
public class Activator extends AbstractUIPlugin {
	// The plug-in ID
	public static final String PLUGIN_ID = "org.obeonetwork.dsl.smartdesigner.design";

	// The shared instance
	private static Activator plugin;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Creates and returns the "viewpoint" image.
	 * 
	 * @return a new "viewpoint" image. Null if no image could be found.
	 */
	public static Image getViewpointImage() {
		ImageDescriptor imageDescriptor = AbstractUIPlugin
				.imageDescriptorFromPlugin(PLUGIN_ID,
						"icons/full/obj16/viewpoint.gif");
		if (imageDescriptor == null) {
			return null;
		}
		return imageDescriptor.createImage(true);
	}
	
	/**
	 * Creates and returns the "shade graphical element" image.
	 * 
	 * @return a new "shade graphical element" image. Null if no image could be found.
	 */
	public static Image getShadeGraphicalElementImage() {
		ImageDescriptor imageDescriptor = AbstractUIPlugin
				.imageDescriptorFromPlugin(PLUGIN_ID,
						"icons/full/obj16/hideGraphicalElement.gif");
		if (imageDescriptor == null) {
			return null;
		}
		return imageDescriptor.createImage(true);
	}
	
	/**
	 * Creates and returns the "connected elements" image.
	 * 
	 * @return a new "connected elements" image. Null if no image could be found.
	 */
	public static Image getConnectedElementsImage() {
		ImageDescriptor imageDescriptor = AbstractUIPlugin
				.imageDescriptorFromPlugin(PLUGIN_ID,
						"icons/full/obj16/relation.gif");
		if (imageDescriptor == null) {
			return null;
		}
		return imageDescriptor.createImage(true);
	}
	
	/**
	 * Creates and returns the "architecture" image.
	 * 
	 * @return a new "architecture" image. Null if no image could be found.
	 */
	public static Image getArchitectureImage() {
		ImageDescriptor imageDescriptor = AbstractUIPlugin
				.imageDescriptorFromPlugin(PLUGIN_ID,
						"icons/full/obj16/architecture.gif");
		if (imageDescriptor == null) {
			return null;
		}
		return imageDescriptor.createImage(true);
	}
}
