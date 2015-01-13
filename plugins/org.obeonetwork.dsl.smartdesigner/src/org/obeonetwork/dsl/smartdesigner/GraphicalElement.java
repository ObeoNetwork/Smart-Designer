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
 * A representation of the model object '<em><b>Graphical Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.smartdesigner.GraphicalElement#getSemanticElement <em>Semantic Element</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.smartdesigner.GraphicalElement#getChild <em>Child</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.smartdesigner.GraphicalElement#isHidden <em>Hidden</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.dsl.smartdesigner.SmartdesignerPackage#getGraphicalElement()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface GraphicalElement extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Semantic Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Semantic Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Semantic Element</em>' reference.
	 * @see #setSemanticElement(EObject)
	 * @see org.obeonetwork.dsl.smartdesigner.SmartdesignerPackage#getGraphicalElement_SemanticElement()
	 * @model required="true"
	 * @generated
	 */
	EObject getSemanticElement();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.smartdesigner.GraphicalElement#getSemanticElement <em>Semantic Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Semantic Element</em>' reference.
	 * @see #getSemanticElement()
	 * @generated
	 */
	void setSemanticElement(EObject value);

	/**
	 * Returns the value of the '<em><b>Child</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.smartdesigner.GraphicalElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child</em>' containment reference list.
	 * @see org.obeonetwork.dsl.smartdesigner.SmartdesignerPackage#getGraphicalElement_Child()
	 * @model containment="true"
	 * @generated
	 */
	EList<GraphicalElement> getChild();

	/**
	 * Returns the value of the '<em><b>Hidden</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hidden</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hidden</em>' attribute.
	 * @see #setHidden(boolean)
	 * @see org.obeonetwork.dsl.smartdesigner.SmartdesignerPackage#getGraphicalElement_Hidden()
	 * @model default="false"
	 * @generated
	 */
	boolean isHidden();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.smartdesigner.GraphicalElement#isHidden <em>Hidden</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hidden</em>' attribute.
	 * @see #isHidden()
	 * @generated
	 */
	void setHidden(boolean value);

} // GraphicalElement
