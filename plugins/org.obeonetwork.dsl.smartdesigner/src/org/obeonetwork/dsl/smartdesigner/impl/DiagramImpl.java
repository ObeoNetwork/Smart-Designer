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
 * <li>{@link org.obeonetwork.dsl.smartdesigner.impl.DiagramImpl#getElements
 * <em>Elements</em>}</li>
 * <li>{@link org.obeonetwork.dsl.smartdesigner.impl.DiagramImpl#getName <em>
 * Name</em>}</li>
 * <li>
 * {@link org.obeonetwork.dsl.smartdesigner.impl.DiagramImpl#getHiddenRelations
 * <em>Hidden Relations</em>}</li>
 * <li>{@link org.obeonetwork.dsl.smartdesigner.impl.DiagramImpl#getDiagrams
 * <em>Diagrams</em>}</li>
 * <li>
 * {@link org.obeonetwork.dsl.smartdesigner.impl.DiagramImpl#getAccessControl
 * <em>Access Control</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class DiagramImpl extends CDOObjectImpl implements Diagram {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SmartdesignerPackage.Literals.DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<GraphicalElement> getElements() {
		return (EList<GraphicalElement>) eGet(
				SmartdesignerPackage.Literals.DIAGRAM__ELEMENTS, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return (String) eGet(SmartdesignerPackage.Literals.DIAGRAM__NAME, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setName(String newName) {
		eSet(SmartdesignerPackage.Literals.DIAGRAM__NAME, newName);
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		if (eFeature.equals(SmartdesignerPackage.Literals.DIAGRAM__NAME)) {
			if (getName() == null || "".equals(getName().trim())) {
				super.eSet(eFeature, newValue);
			}
		} else {
			super.eSet(eFeature, newValue);
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<EObject> getHiddenRelations() {
		return (EList<EObject>) eGet(
				SmartdesignerPackage.Literals.DIAGRAM__HIDDEN_RELATIONS, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Diagram> getDiagrams() {
		return (EList<Diagram>) eGet(
				SmartdesignerPackage.Literals.DIAGRAM__DIAGRAMS, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getAccessControl() {
		return (String) eGet(
				SmartdesignerPackage.Literals.DIAGRAM__ACCESS_CONTROL, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAccessControl(String newAccessControl) {
		eSet(SmartdesignerPackage.Literals.DIAGRAM__ACCESS_CONTROL,
				newAccessControl);
	}

} // DiagramImpl
