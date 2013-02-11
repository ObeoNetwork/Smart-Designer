/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.smartdesigner;

import org.eclipse.emf.cdo.CDOObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Access Control</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.smartdesigner.AccessControl#getDiagrams <em>Diagrams</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.smartdesigner.AccessControl#getAccessControl <em>Access Control</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.dsl.smartdesigner.SmartdesignerPackage#getAccessControl()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface AccessControl extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Diagrams</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.smartdesigner.Diagram}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagrams</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagrams</em>' reference list.
	 * @see org.obeonetwork.dsl.smartdesigner.SmartdesignerPackage#getAccessControl_Diagrams()
	 * @model
	 * @generated
	 */
	EList<Diagram> getDiagrams();

	/**
	 * Returns the value of the '<em><b>Access Control</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Access Control</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Access Control</em>' attribute.
	 * @see #setAccessControl(String)
	 * @see org.obeonetwork.dsl.smartdesigner.SmartdesignerPackage#getAccessControl_AccessControl()
	 * @model
	 * @generated
	 */
	String getAccessControl();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.smartdesigner.AccessControl#getAccessControl <em>Access Control</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Access Control</em>' attribute.
	 * @see #getAccessControl()
	 * @generated
	 */
	void setAccessControl(String value);

} // AccessControl
