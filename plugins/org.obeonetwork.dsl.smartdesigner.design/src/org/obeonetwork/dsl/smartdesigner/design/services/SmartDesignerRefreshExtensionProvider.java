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

package org.obeonetwork.dsl.smartdesigner.design.services;

import fr.obeo.dsl.viewpoint.DDiagram;
import fr.obeo.dsl.viewpoint.business.api.refresh.IRefreshExtension;
import fr.obeo.dsl.viewpoint.business.api.refresh.IRefreshExtensionProvider;
import fr.obeo.dsl.viewpoint.description.DiagramDescription;
import fr.obeo.dsl.viewpoint.description.JavaExtension;
import fr.obeo.dsl.viewpoint.description.Viewpoint;

/**
 * A {@link IRefreshExtensionProvider} that provides
 * {@link SmartDesignerRefreshExtension}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class SmartDesignerRefreshExtensionProvider implements
		IRefreshExtensionProvider {

	private final static SmartDesignerRefreshExtension INSTANCE = new SmartDesignerRefreshExtension();

	/**
	 * A {@link IRefreshExtension} that {@link ConnectorServices#clearCache()
	 * clear} the {@link ConnectorServices} cache.
	 * 
	 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
	 */
	private static class SmartDesignerRefreshExtension implements
			IRefreshExtension {
		/**
		 * {@inheritDoc}
		 * 
		 * @see fr.obeo.dsl.viewpoint.business.api.refresh.IRefreshExtension#beforeRefresh(fr.obeo.dsl.viewpoint.DDiagram)
		 */
		@Override
		public void beforeRefresh(DDiagram dDiagram) {
			ConnectorServices.clearCache();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see fr.obeo.dsl.viewpoint.business.api.refresh.IRefreshExtension#postRefresh(fr.obeo.dsl.viewpoint.DDiagram)
		 */
		@Override
		public void postRefresh(DDiagram dDiagram) {
			ConnectorServices.clearCache();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.viewpoint.business.api.refresh.IRefreshExtensionProvider#getRefreshExtension(fr.obeo.dsl.viewpoint.DDiagram)
	 */
	@Override
	public IRefreshExtension getRefreshExtension(DDiagram viewPoint) {
		return INSTANCE;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.viewpoint.business.api.refresh.IRefreshExtensionProvider#provides(fr.obeo.dsl.viewpoint.DDiagram)
	 */
	@Override
	public boolean provides(DDiagram viewPoint) {
		boolean res = false;

		final DiagramDescription description = viewPoint.getDescription();
		if (description != null) {
			Object eContainer = description.eContainer();
			if (eContainer instanceof Viewpoint) {
				Viewpoint viewpoint = (Viewpoint) eContainer;
				for (JavaExtension extension : viewpoint
						.getOwnedJavaExtensions()) {
					if (ConnectorServices.class.getCanonicalName().equals(
							extension.getQualifiedClassName())) {
						res = true;
						break;
					}
				}
			}
		}

		return res;
	}

}
