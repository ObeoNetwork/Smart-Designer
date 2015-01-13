/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.smartdesigner;

import org.eclipse.emf.cdo.CDOObject;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.smartdesigner.Diagram#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.dsl.smartdesigner.SmartdesignerPackage#getDiagram()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface Diagram extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.smartdesigner.GraphicalElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see org.obeonetwork.dsl.smartdesigner.SmartdesignerPackage#getDiagram_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<GraphicalElement> getElements();

} // Diagram
