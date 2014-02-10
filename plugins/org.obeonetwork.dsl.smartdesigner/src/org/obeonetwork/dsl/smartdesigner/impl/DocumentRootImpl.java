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
import org.obeonetwork.dsl.smartdesigner.DocumentRoot;
import org.obeonetwork.dsl.smartdesigner.SmartdesignerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.smartdesigner.impl.DocumentRootImpl#getDiagrams <em>Diagrams</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.smartdesigner.impl.DocumentRootImpl#getSemanticModel <em>Semantic Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DocumentRootImpl extends CDOObjectImpl implements DocumentRoot {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DocumentRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SmartdesignerPackage.Literals.DOCUMENT_ROOT;
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
	@SuppressWarnings("unchecked")
	public EList<Diagram> getDiagrams() {
		return (EList<Diagram>)eGet(SmartdesignerPackage.Literals.DOCUMENT_ROOT__DIAGRAMS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getSemanticModel() {
		return (EObject)eGet(SmartdesignerPackage.Literals.DOCUMENT_ROOT__SEMANTIC_MODEL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSemanticModel(EObject newSemanticModel) {
		eSet(SmartdesignerPackage.Literals.DOCUMENT_ROOT__SEMANTIC_MODEL, newSemanticModel);
	}

} //DocumentRootImpl
