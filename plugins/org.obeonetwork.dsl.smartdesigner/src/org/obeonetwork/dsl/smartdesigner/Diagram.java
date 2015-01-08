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
 *   <li>{@link org.obeonetwork.dsl.smartdesigner.Diagram#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.smartdesigner.Diagram#getId <em>Id</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.smartdesigner.Diagram#getDiagrams <em>Diagrams</em>}</li>
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

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.obeonetwork.dsl.smartdesigner.SmartdesignerPackage#getDiagram_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.smartdesigner.Diagram#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(long)
	 * @see org.obeonetwork.dsl.smartdesigner.SmartdesignerPackage#getDiagram_Id()
	 * @model
	 * @generated
	 */
	long getId();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.smartdesigner.Diagram#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(long value);

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
	 * @see org.obeonetwork.dsl.smartdesigner.SmartdesignerPackage#getDiagram_Diagrams()
	 * @model
	 * @generated
	 */
	EList<Diagram> getDiagrams();

} // Diagram
