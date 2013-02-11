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
 * A representation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.smartdesigner.DocumentRoot#getDiagrams <em>Diagrams</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.smartdesigner.DocumentRoot#getSemanticModel <em>Semantic Model</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.smartdesigner.DocumentRoot#getAccessControls <em>Access Controls</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.dsl.smartdesigner.SmartdesignerPackage#getDocumentRoot()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface DocumentRoot extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Diagrams</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.smartdesigner.Diagram}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagrams</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagrams</em>' containment reference list.
	 * @see org.obeonetwork.dsl.smartdesigner.SmartdesignerPackage#getDocumentRoot_Diagrams()
	 * @model containment="true"
	 * @generated
	 */
	EList<Diagram> getDiagrams();

	/**
	 * Returns the value of the '<em><b>Semantic Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Semantic Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Semantic Model</em>' reference.
	 * @see #setSemanticModel(EObject)
	 * @see org.obeonetwork.dsl.smartdesigner.SmartdesignerPackage#getDocumentRoot_SemanticModel()
	 * @model required="true"
	 * @generated
	 */
	EObject getSemanticModel();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.smartdesigner.DocumentRoot#getSemanticModel <em>Semantic Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Semantic Model</em>' reference.
	 * @see #getSemanticModel()
	 * @generated
	 */
	void setSemanticModel(EObject value);

	/**
	 * Returns the value of the '<em><b>Access Controls</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.smartdesigner.AccessControl}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Access Controls</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Access Controls</em>' containment reference list.
	 * @see org.obeonetwork.dsl.smartdesigner.SmartdesignerPackage#getDocumentRoot_AccessControls()
	 * @model containment="true"
	 * @generated
	 */
	EList<AccessControl> getAccessControls();

} // DocumentRoot
