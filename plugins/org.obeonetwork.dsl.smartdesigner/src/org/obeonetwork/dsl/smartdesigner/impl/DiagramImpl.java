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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.obeonetwork.dsl.smartdesigner.Diagram;
import org.obeonetwork.dsl.smartdesigner.GraphicalElement;
import org.obeonetwork.dsl.smartdesigner.SmartdesignerPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Diagram</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.smartdesigner.impl.DiagramImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.smartdesigner.impl.DiagramImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.smartdesigner.impl.DiagramImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.smartdesigner.impl.DiagramImpl#getDiagrams <em>Diagrams</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DiagramImpl extends CDOObjectImpl implements Diagram {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final long ID_EDEFAULT = 0L;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SmartdesignerPackage.Literals.DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<GraphicalElement> getElements() {
		return (EList<GraphicalElement>)eDynamicGet(SmartdesignerPackage.DIAGRAM__ELEMENTS, SmartdesignerPackage.Literals.DIAGRAM__ELEMENTS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eDynamicGet(SmartdesignerPackage.DIAGRAM__NAME, SmartdesignerPackage.Literals.DIAGRAM__NAME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eDynamicSet(SmartdesignerPackage.DIAGRAM__NAME, SmartdesignerPackage.Literals.DIAGRAM__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getId() {
		return (Long)eDynamicGet(SmartdesignerPackage.DIAGRAM__ID, SmartdesignerPackage.Literals.DIAGRAM__ID, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(long newId) {
		eDynamicSet(SmartdesignerPackage.DIAGRAM__ID, SmartdesignerPackage.Literals.DIAGRAM__ID, newId);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Diagram> getDiagrams() {
		return (EList<Diagram>)eDynamicGet(SmartdesignerPackage.DIAGRAM__DIAGRAMS, SmartdesignerPackage.Literals.DIAGRAM__DIAGRAMS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SmartdesignerPackage.DIAGRAM__ELEMENTS:
				return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
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
			case SmartdesignerPackage.DIAGRAM__ELEMENTS:
				return getElements();
			case SmartdesignerPackage.DIAGRAM__NAME:
				return getName();
			case SmartdesignerPackage.DIAGRAM__ID:
				return getId();
			case SmartdesignerPackage.DIAGRAM__DIAGRAMS:
				return getDiagrams();
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
			case SmartdesignerPackage.DIAGRAM__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends GraphicalElement>)newValue);
				return;
			case SmartdesignerPackage.DIAGRAM__NAME:
				setName((String)newValue);
				return;
			case SmartdesignerPackage.DIAGRAM__ID:
				setId((Long)newValue);
				return;
			case SmartdesignerPackage.DIAGRAM__DIAGRAMS:
				getDiagrams().clear();
				getDiagrams().addAll((Collection<? extends Diagram>)newValue);
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
			case SmartdesignerPackage.DIAGRAM__ELEMENTS:
				getElements().clear();
				return;
			case SmartdesignerPackage.DIAGRAM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SmartdesignerPackage.DIAGRAM__ID:
				setId(ID_EDEFAULT);
				return;
			case SmartdesignerPackage.DIAGRAM__DIAGRAMS:
				getDiagrams().clear();
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
			case SmartdesignerPackage.DIAGRAM__ELEMENTS:
				return !getElements().isEmpty();
			case SmartdesignerPackage.DIAGRAM__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case SmartdesignerPackage.DIAGRAM__ID:
				return getId() != ID_EDEFAULT;
			case SmartdesignerPackage.DIAGRAM__DIAGRAMS:
				return !getDiagrams().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // DiagramImpl
