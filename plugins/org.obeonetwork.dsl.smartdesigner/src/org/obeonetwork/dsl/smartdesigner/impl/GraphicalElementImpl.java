/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.smartdesigner.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.obeonetwork.dsl.smartdesigner.Diagram;
import org.obeonetwork.dsl.smartdesigner.GraphicalElement;
import org.obeonetwork.dsl.smartdesigner.SmartdesignerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graphical Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.smartdesigner.impl.GraphicalElementImpl#getSemanticElement <em>Semantic Element</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.smartdesigner.impl.GraphicalElementImpl#getChild <em>Child</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.smartdesigner.impl.GraphicalElementImpl#isHidden <em>Hidden</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.smartdesigner.impl.GraphicalElementImpl#getDiagrams <em>Diagrams</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GraphicalElementImpl extends CDOObjectImpl implements GraphicalElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphicalElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SmartdesignerPackage.Literals.GRAPHICAL_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getSemanticElement() {
		return (EObject)eGet(SmartdesignerPackage.Literals.GRAPHICAL_ELEMENT__SEMANTIC_ELEMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSemanticElement(EObject newSemanticElement) {
		eSet(SmartdesignerPackage.Literals.GRAPHICAL_ELEMENT__SEMANTIC_ELEMENT, newSemanticElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<GraphicalElement> getChild() {
		return (EList<GraphicalElement>)eGet(SmartdesignerPackage.Literals.GRAPHICAL_ELEMENT__CHILD, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHidden() {
		return (Boolean)eGet(SmartdesignerPackage.Literals.GRAPHICAL_ELEMENT__HIDDEN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHidden(boolean newHidden) {
		eSet(SmartdesignerPackage.Literals.GRAPHICAL_ELEMENT__HIDDEN, newHidden);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Diagram> getDiagrams() {
		return (EList<Diagram>)eGet(SmartdesignerPackage.Literals.GRAPHICAL_ELEMENT__DIAGRAMS, true);
	}

} //GraphicalElementImpl
