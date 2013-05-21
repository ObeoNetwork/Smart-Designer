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

package org.obeonetwork.dsl.smartdesigner.design.graphical.edit.policies;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gmf.runtime.diagram.ui.tools.PopupBarTool;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.swt.graphics.Image;

import fr.obeo.dsl.viewpoint.ViewpointPackage;
import fr.obeo.dsl.viewpoint.description.tool.AbstractToolDescription;
import fr.obeo.dsl.viewpoint.description.tool.ContainerCreationDescription;
import fr.obeo.dsl.viewpoint.description.tool.EdgeCreationDescription;
import fr.obeo.dsl.viewpoint.description.tool.NodeCreationDescription;
import fr.obeo.dsl.viewpoint.description.tool.PaneBasedSelectionWizardDescription;
import fr.obeo.dsl.viewpoint.description.tool.SelectionWizardDescription;
import fr.obeo.dsl.viewpoint.description.tool.ToolDescription;
import fr.obeo.dsl.viewpoint.diagram.graphical.edit.policies.ViewPointPopupBarEditPolicy;
import fr.obeo.dsl.viewpoint.provider.ViewpointEditPlugin;

/**
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class SmartPopupBarEditPolicy extends ViewPointPopupBarEditPolicy {

	/**
	 * Predefined feature names used to retrieve names from {@link EBoject}s.
	 */
	private static final Collection<String> ALLOWED_TOOL_LABELS = Arrays
			.asList("Connect", "Connected objects");

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.viewpoint.diagram.graphical.edit.policies.ViewPointPopupBarEditPolicy#fillPopupBarDescriptors()
	 */
	@Override
	protected void fillPopupBarDescriptors() {
		if (getPopupBarDescriptors().isEmpty()) {
			final PaletteViewer paletteViewer = getHost().getViewer()
					.getEditDomain().getPaletteViewer();
			for (Object child : paletteViewer.getPaletteRoot().getChildren()) {
				if (child instanceof PaletteDrawer) {
					final PaletteDrawer drawer = (PaletteDrawer) child;
					if (drawer.isVisible()) {
						addFromPaletteStack(drawer);
					}
				}
			}
		}
	}

	/**
	 * Check the {@link PaletteContainer#getChildren() children} of the given
	 * {@link PaletteContainer} in order to add
	 * {@link SmartPopupBarEditPolicy#ALLOWED_TOOL_LABELS allowed}
	 * {@link CreationToolEntry}.
	 * 
	 * @param container
	 *            the {@link PaletteContainer}
	 */
	private void addFromPaletteStack(final PaletteContainer container) {
		final List<PaletteEntry> children = container.getChildren();

		for (PaletteEntry child : children) {
			if (child instanceof CreationToolEntry) {
				CreationToolEntry tool = (CreationToolEntry) child;
				if (ALLOWED_TOOL_LABELS.contains(tool.getLabel())) {
					addTool(tool);
				}
			} else if (child instanceof PaletteContainer) {
				addFromPaletteStack((PaletteContainer) child);
			}
		}
	}

	/**
	 * Add the given {@link CreationToolEntry}.
	 * 
	 * @param tool
	 *            the {@link CreationToolEntry} to add
	 */
	protected void addTool(CreationToolEntry tool) {
		final CreationFactory factory = (CreationFactory) tool
				.getToolProperty(org.eclipse.gef.tools.CreationTool.PROPERTY_CREATION_FACTORY);
		if (factory != null) {
			final AbstractToolDescription desc = (AbstractToolDescription) factory
					.getNewObject();
			final IElementType elementType = getElementType(desc);
			if (elementType != null) {
				final Image icon;
				if (tool.getSmallIcon() != null) {
					icon = ViewpointEditPlugin.getPlugin().getImage(
							tool.getSmallIcon());
				} else {
					icon = null;
				}
				final CreateRequest req = new CreateRequest();
				req.setFactory(factory);
				final PopupBarTool popupBarTool = new PopupBarTool(getHost(),
						req);
				addPopupBarDescriptor(elementType, icon, popupBarTool,
						tool.getLabel());
			}
		}
	}

	/**
	 * Returns the type of element created by the specified
	 * {@link AbstractToolDescription} in the format expected by GMF, or
	 * <code>null</code> if the AbstractToolDescription's type is not supported.
	 */
	private IElementType getElementType(final AbstractToolDescription desc) {
		EClass klass = null;

		if (desc instanceof NodeCreationDescription) {
			klass = ViewpointPackage.eINSTANCE.getDNode();
		} else if (desc instanceof ContainerCreationDescription) {
			klass = ViewpointPackage.eINSTANCE.getDContainer();
		} else if (desc instanceof EdgeCreationDescription) {
			klass = ViewpointPackage.eINSTANCE.getDEdge();
		} else if (desc instanceof SelectionWizardDescription
				|| desc instanceof PaneBasedSelectionWizardDescription) {
			/*
			 * return a fake class as element type is not used by popup bar
			 * descriptor
			 */
			klass = ViewpointPackage.eINSTANCE.getDNode();
		} else if (desc instanceof ToolDescription) {
			/*
			 * return a fake class as element type is not used by popup bar
			 * descriptor
			 */
			klass = ViewpointPackage.eINSTANCE.getDNode();
		}

		if (klass != null) {
			return ElementTypeRegistry.getInstance().getElementType(klass);
		} else {
			return null;
		}
	}

}
