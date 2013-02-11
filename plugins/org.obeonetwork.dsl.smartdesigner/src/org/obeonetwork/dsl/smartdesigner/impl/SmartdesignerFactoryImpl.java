/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.smartdesigner.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.obeonetwork.dsl.smartdesigner.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SmartdesignerFactoryImpl extends EFactoryImpl implements SmartdesignerFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SmartdesignerFactory init() {
		try {
			SmartdesignerFactory theSmartdesignerFactory = (SmartdesignerFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.obeonetwork.org/dsl/smartdesigner/1.2"); 
			if (theSmartdesignerFactory != null) {
				return theSmartdesignerFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SmartdesignerFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmartdesignerFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SmartdesignerPackage.GRAPHICAL_ELEMENT: return (EObject)createGraphicalElement();
			case SmartdesignerPackage.DIAGRAM: return (EObject)createDiagram();
			case SmartdesignerPackage.DOCUMENT_ROOT: return (EObject)createDocumentRoot();
			case SmartdesignerPackage.ACCESS_CONTROL: return (EObject)createAccessControl();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphicalElement createGraphicalElement() {
		GraphicalElementImpl graphicalElement = new GraphicalElementImpl();
		return graphicalElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagram createDiagram() {
		DiagramImpl diagram = new DiagramImpl();
		return diagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentRoot createDocumentRoot() {
		DocumentRootImpl documentRoot = new DocumentRootImpl();
		return documentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccessControl createAccessControl() {
		AccessControlImpl accessControl = new AccessControlImpl();
		return accessControl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmartdesignerPackage getSmartdesignerPackage() {
		return (SmartdesignerPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SmartdesignerPackage getPackage() {
		return SmartdesignerPackage.eINSTANCE;
	}

} //SmartdesignerFactoryImpl
