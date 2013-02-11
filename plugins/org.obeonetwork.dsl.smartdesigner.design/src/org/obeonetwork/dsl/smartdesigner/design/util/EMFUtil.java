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
package org.obeonetwork.dsl.smartdesigner.design.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * Utility class for EMF objects.
 * 
 * @author Stephane Drapeau - Obeo
 * 
 */
public class EMFUtil {

	/**
	 * Tries to find a label for the given object.
	 * 
	 * @param object
	 *            the object
	 * @return
	 */
	public static String retrieveNameFrom(EObject object) {
		if (object == null) {
			return "";
		} else {
			EClass eClass = object.eClass();
			EStructuralFeature feature = eClass.getEStructuralFeature("name");
			if (!(feature instanceof EAttribute)) {
				feature = eClass.getEStructuralFeature("nom");
				if (!(feature instanceof EAttribute)) {
					if (!(feature instanceof EAttribute)) {
						feature = null;
						for (EStructuralFeature f : eClass.getEAllAttributes()) {
							if (f instanceof EAttribute) {
								if (String.class == ((EAttribute) f).getEType()
										.getInstanceClass()) {
									feature = f;
									break;
								}
							}
						}
					}
				}
			}
			return (feature != null) ? String.valueOf((object.eGet(feature)))
					: eClass.getName();
		}
	}

	/**
	 * Get the image corresponding to the EObject <code>eObject</code> (looks
	 * for the image in the .edit plugin).
	 * 
	 * @param eObject
	 *            The EObject for which we are looking for an image.
	 * @return the image corresponding to the EObject <code>eObject</code>.
	 */
	public static Image getImage(EObject eObject) {
		if (eObject == null) {
			return null;
		}

		Image result = null;
		Bundle bundle = FrameworkUtil.getBundle(eObject.getClass());
		ImageDescriptor imageDescriptor = AbstractUIPlugin
				.imageDescriptorFromPlugin(
						bundle.getSymbolicName() + ".edit",
						"icons/full/obj16/"
								+ eObject.getClass().getSimpleName()
										.replace("Impl", "") + ".gif");
		if (imageDescriptor == null) {
			return null;
		}
		result = imageDescriptor.createImage(true);
		return result;
	}

	/**
	 * Returns the references existing between <code>sourceElement</code> and
	 * <code>targetElement</code>.
	 * 
	 * @param sourceElement
	 * @param targetElement
	 * @return the list of references existing between
	 *         <code>sourceElement</code> and <code>targetElement</code>.
	 *         Returns an empty list if there is no reference between
	 *         <code>sourceElement</code> and <code>targetElement</code>.
	 */
	public static List<EReference> getReferencesBetween(EObject sourceElement,
			EObject targetElement) {
		EList<EReference> references = sourceElement.eClass()
				.getEAllReferences();
		List<EReference> result = new ArrayList<EReference>();
		for (EReference ref : references) {
			List<String> implementedInterfaces = getImplementedInterfaces(targetElement
					.getClass());
			if (implementedInterfaces.contains(ref.getEReferenceType()
					.getInstanceClassName())) {
				result.add(ref);
			}
		}
		return result;
	}

	/**
	 * Returns the list of interfaces implemented by the class
	 * <code>clazz</code>.
	 * 
	 * @param clazz
	 * @return
	 */
	private static List<String> getImplementedInterfaces(Class clazz) {
		List<String> list = new ArrayList();
		Class[] classes = clazz.getInterfaces();
		for (Class c : classes) {
			list.add(c.getCanonicalName());
			list.addAll(getImplementedInterfaces(c));
		}
		return list;
	}

	/**
	 * Set a reference from <code>sourceElement</code> to
	 * <code>targetElement</code>.
	 * 
	 * @param sourceElement
	 * @param targetElement
	 * @param reference
	 */
	public static void setEReference(EObject sourceElement,
			EObject targetElement, EReference reference) {
		if (reference.isMany()) {
			EList<EObject> list = new BasicEList<EObject>();
			if (sourceElement.eGet(reference) instanceof List) {
				for (Object o : (List) sourceElement.eGet(reference)) {
					list.add((EObject) o);
				}
			}
			list.add(targetElement);
			sourceElement.eSet(reference, list);
		} else {
			sourceElement.eSet(reference, targetElement);
		}
	}

}
