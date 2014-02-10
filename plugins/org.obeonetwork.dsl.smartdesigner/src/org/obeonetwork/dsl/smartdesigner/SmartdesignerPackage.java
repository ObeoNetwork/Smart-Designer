/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.smartdesigner;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.obeonetwork.dsl.smartdesigner.SmartdesignerFactory
 * @model kind="package"
 * @generated
 */
public interface SmartdesignerPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "smartdesigner";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.obeonetwork.org/dsl/smartdesigner/1.2";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "smartdesigner";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SmartdesignerPackage eINSTANCE = org.obeonetwork.dsl.smartdesigner.impl.SmartdesignerPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.smartdesigner.impl.GraphicalElementImpl <em>Graphical Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.smartdesigner.impl.GraphicalElementImpl
	 * @see org.obeonetwork.dsl.smartdesigner.impl.SmartdesignerPackageImpl#getGraphicalElement()
	 * @generated
	 */
	int GRAPHICAL_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Semantic Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICAL_ELEMENT__SEMANTIC_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Child</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICAL_ELEMENT__CHILD = 1;

	/**
	 * The feature id for the '<em><b>Hidden</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICAL_ELEMENT__HIDDEN = 2;

	/**
	 * The feature id for the '<em><b>Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICAL_ELEMENT__DIAGRAMS = 3;

	/**
	 * The number of structural features of the '<em>Graphical Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICAL_ELEMENT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.smartdesigner.impl.DiagramImpl <em>Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.smartdesigner.impl.DiagramImpl
	 * @see org.obeonetwork.dsl.smartdesigner.impl.SmartdesignerPackageImpl#getDiagram()
	 * @generated
	 */
	int DIAGRAM = 1;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__ELEMENTS = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__ID = 1;

	/**
	 * The feature id for the '<em><b>Hidden Relations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__HIDDEN_RELATIONS = 2;

	/**
	 * The feature id for the '<em><b>Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__DIAGRAMS = 3;

	/**
	 * The number of structural features of the '<em>Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.smartdesigner.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.smartdesigner.impl.DocumentRootImpl
	 * @see org.obeonetwork.dsl.smartdesigner.impl.SmartdesignerPackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 2;

	/**
	 * The feature id for the '<em><b>Diagrams</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__DIAGRAMS = 0;

	/**
	 * The feature id for the '<em><b>Semantic Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__SEMANTIC_MODEL = 1;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 2;

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.smartdesigner.GraphicalElement <em>Graphical Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graphical Element</em>'.
	 * @see org.obeonetwork.dsl.smartdesigner.GraphicalElement
	 * @generated
	 */
	EClass getGraphicalElement();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.smartdesigner.GraphicalElement#getSemanticElement <em>Semantic Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Semantic Element</em>'.
	 * @see org.obeonetwork.dsl.smartdesigner.GraphicalElement#getSemanticElement()
	 * @see #getGraphicalElement()
	 * @generated
	 */
	EReference getGraphicalElement_SemanticElement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.smartdesigner.GraphicalElement#getChild <em>Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Child</em>'.
	 * @see org.obeonetwork.dsl.smartdesigner.GraphicalElement#getChild()
	 * @see #getGraphicalElement()
	 * @generated
	 */
	EReference getGraphicalElement_Child();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.smartdesigner.GraphicalElement#isHidden <em>Hidden</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hidden</em>'.
	 * @see org.obeonetwork.dsl.smartdesigner.GraphicalElement#isHidden()
	 * @see #getGraphicalElement()
	 * @generated
	 */
	EAttribute getGraphicalElement_Hidden();

	/**
	 * Returns the meta object for the reference list '{@link org.obeonetwork.dsl.smartdesigner.GraphicalElement#getDiagrams <em>Diagrams</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Diagrams</em>'.
	 * @see org.obeonetwork.dsl.smartdesigner.GraphicalElement#getDiagrams()
	 * @see #getGraphicalElement()
	 * @generated
	 */
	EReference getGraphicalElement_Diagrams();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.smartdesigner.Diagram <em>Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagram</em>'.
	 * @see org.obeonetwork.dsl.smartdesigner.Diagram
	 * @generated
	 */
	EClass getDiagram();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.smartdesigner.Diagram#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.obeonetwork.dsl.smartdesigner.Diagram#getElements()
	 * @see #getDiagram()
	 * @generated
	 */
	EReference getDiagram_Elements();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.smartdesigner.Diagram#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.obeonetwork.dsl.smartdesigner.Diagram#getId()
	 * @see #getDiagram()
	 * @generated
	 */
	EAttribute getDiagram_Id();

	/**
	 * Returns the meta object for the reference list '{@link org.obeonetwork.dsl.smartdesigner.Diagram#getHiddenRelations <em>Hidden Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Hidden Relations</em>'.
	 * @see org.obeonetwork.dsl.smartdesigner.Diagram#getHiddenRelations()
	 * @see #getDiagram()
	 * @generated
	 */
	EReference getDiagram_HiddenRelations();

	/**
	 * Returns the meta object for the reference list '{@link org.obeonetwork.dsl.smartdesigner.Diagram#getDiagrams <em>Diagrams</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Diagrams</em>'.
	 * @see org.obeonetwork.dsl.smartdesigner.Diagram#getDiagrams()
	 * @see #getDiagram()
	 * @generated
	 */
	EReference getDiagram_Diagrams();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.smartdesigner.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see org.obeonetwork.dsl.smartdesigner.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.smartdesigner.DocumentRoot#getDiagrams <em>Diagrams</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Diagrams</em>'.
	 * @see org.obeonetwork.dsl.smartdesigner.DocumentRoot#getDiagrams()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Diagrams();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.smartdesigner.DocumentRoot#getSemanticModel <em>Semantic Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Semantic Model</em>'.
	 * @see org.obeonetwork.dsl.smartdesigner.DocumentRoot#getSemanticModel()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_SemanticModel();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SmartdesignerFactory getSmartdesignerFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.smartdesigner.impl.GraphicalElementImpl <em>Graphical Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.smartdesigner.impl.GraphicalElementImpl
		 * @see org.obeonetwork.dsl.smartdesigner.impl.SmartdesignerPackageImpl#getGraphicalElement()
		 * @generated
		 */
		EClass GRAPHICAL_ELEMENT = eINSTANCE.getGraphicalElement();

		/**
		 * The meta object literal for the '<em><b>Semantic Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPHICAL_ELEMENT__SEMANTIC_ELEMENT = eINSTANCE.getGraphicalElement_SemanticElement();

		/**
		 * The meta object literal for the '<em><b>Child</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPHICAL_ELEMENT__CHILD = eINSTANCE.getGraphicalElement_Child();

		/**
		 * The meta object literal for the '<em><b>Hidden</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPHICAL_ELEMENT__HIDDEN = eINSTANCE.getGraphicalElement_Hidden();

		/**
		 * The meta object literal for the '<em><b>Diagrams</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPHICAL_ELEMENT__DIAGRAMS = eINSTANCE.getGraphicalElement_Diagrams();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.smartdesigner.impl.DiagramImpl <em>Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.smartdesigner.impl.DiagramImpl
		 * @see org.obeonetwork.dsl.smartdesigner.impl.SmartdesignerPackageImpl#getDiagram()
		 * @generated
		 */
		EClass DIAGRAM = eINSTANCE.getDiagram();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIAGRAM__ELEMENTS = eINSTANCE.getDiagram_Elements();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGRAM__ID = eINSTANCE.getDiagram_Id();

		/**
		 * The meta object literal for the '<em><b>Hidden Relations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIAGRAM__HIDDEN_RELATIONS = eINSTANCE.getDiagram_HiddenRelations();

		/**
		 * The meta object literal for the '<em><b>Diagrams</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIAGRAM__DIAGRAMS = eINSTANCE.getDiagram_Diagrams();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.smartdesigner.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.smartdesigner.impl.DocumentRootImpl
		 * @see org.obeonetwork.dsl.smartdesigner.impl.SmartdesignerPackageImpl#getDocumentRoot()
		 * @generated
		 */
		EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

		/**
		 * The meta object literal for the '<em><b>Diagrams</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__DIAGRAMS = eINSTANCE.getDocumentRoot_Diagrams();

		/**
		 * The meta object literal for the '<em><b>Semantic Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__SEMANTIC_MODEL = eINSTANCE.getDocumentRoot_SemanticModel();

	}

} //SmartdesignerPackage
