/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.smartdesigner.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
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
 * </ul>
 * </p>
 *
 * @generated
 */
public class GraphicalElementImpl extends CDOObjectImpl implements GraphicalElement {
	/**
	 * The default value of the '{@link #isHidden() <em>Hidden</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHidden()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HIDDEN_EDEFAULT = false;

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
		return (EObject)eDynamicGet(SmartdesignerPackage.GRAPHICAL_ELEMENT__SEMANTIC_ELEMENT, SmartdesignerPackage.Literals.GRAPHICAL_ELEMENT__SEMANTIC_ELEMENT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetSemanticElement() {
		return (EObject)eDynamicGet(SmartdesignerPackage.GRAPHICAL_ELEMENT__SEMANTIC_ELEMENT, SmartdesignerPackage.Literals.GRAPHICAL_ELEMENT__SEMANTIC_ELEMENT, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSemanticElement(EObject newSemanticElement) {
		eDynamicSet(SmartdesignerPackage.GRAPHICAL_ELEMENT__SEMANTIC_ELEMENT, SmartdesignerPackage.Literals.GRAPHICAL_ELEMENT__SEMANTIC_ELEMENT, newSemanticElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<GraphicalElement> getChild() {
		return (EList<GraphicalElement>)eDynamicGet(SmartdesignerPackage.GRAPHICAL_ELEMENT__CHILD, SmartdesignerPackage.Literals.GRAPHICAL_ELEMENT__CHILD, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHidden() {
		return (Boolean)eDynamicGet(SmartdesignerPackage.GRAPHICAL_ELEMENT__HIDDEN, SmartdesignerPackage.Literals.GRAPHICAL_ELEMENT__HIDDEN, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHidden(boolean newHidden) {
		eDynamicSet(SmartdesignerPackage.GRAPHICAL_ELEMENT__HIDDEN, SmartdesignerPackage.Literals.GRAPHICAL_ELEMENT__HIDDEN, newHidden);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SmartdesignerPackage.GRAPHICAL_ELEMENT__CHILD:
				return ((InternalEList<?>)getChild()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SmartdesignerPackage.GRAPHICAL_ELEMENT__SEMANTIC_ELEMENT:
				if (resolve) return getSemanticElement();
				return basicGetSemanticElement();
			case SmartdesignerPackage.GRAPHICAL_ELEMENT__CHILD:
				return getChild();
			case SmartdesignerPackage.GRAPHICAL_ELEMENT__HIDDEN:
				return isHidden();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SmartdesignerPackage.GRAPHICAL_ELEMENT__SEMANTIC_ELEMENT:
				setSemanticElement((EObject)newValue);
				return;
			case SmartdesignerPackage.GRAPHICAL_ELEMENT__CHILD:
				getChild().clear();
				getChild().addAll((Collection<? extends GraphicalElement>)newValue);
				return;
			case SmartdesignerPackage.GRAPHICAL_ELEMENT__HIDDEN:
				setHidden((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SmartdesignerPackage.GRAPHICAL_ELEMENT__SEMANTIC_ELEMENT:
				setSemanticElement((EObject)null);
				return;
			case SmartdesignerPackage.GRAPHICAL_ELEMENT__CHILD:
				getChild().clear();
				return;
			case SmartdesignerPackage.GRAPHICAL_ELEMENT__HIDDEN:
				setHidden(HIDDEN_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SmartdesignerPackage.GRAPHICAL_ELEMENT__SEMANTIC_ELEMENT:
				return basicGetSemanticElement() != null;
			case SmartdesignerPackage.GRAPHICAL_ELEMENT__CHILD:
				return !getChild().isEmpty();
			case SmartdesignerPackage.GRAPHICAL_ELEMENT__HIDDEN:
				return isHidden() != HIDDEN_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //GraphicalElementImpl
