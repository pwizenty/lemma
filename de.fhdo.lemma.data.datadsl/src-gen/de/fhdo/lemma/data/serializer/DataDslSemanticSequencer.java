/*
 * generated by Xtext 2.16.0
 */
package de.fhdo.lemma.data.serializer;

import com.google.inject.Inject;
import de.fhdo.lemma.data.ComplexTypeImport;
import de.fhdo.lemma.data.Context;
import de.fhdo.lemma.data.DataField;
import de.fhdo.lemma.data.DataModel;
import de.fhdo.lemma.data.DataPackage;
import de.fhdo.lemma.data.DataStructure;
import de.fhdo.lemma.data.Enumeration;
import de.fhdo.lemma.data.EnumerationField;
import de.fhdo.lemma.data.ListType;
import de.fhdo.lemma.data.PossiblyImportedComplexType;
import de.fhdo.lemma.data.PrimitiveBoolean;
import de.fhdo.lemma.data.PrimitiveByte;
import de.fhdo.lemma.data.PrimitiveCharacter;
import de.fhdo.lemma.data.PrimitiveDate;
import de.fhdo.lemma.data.PrimitiveDouble;
import de.fhdo.lemma.data.PrimitiveFloat;
import de.fhdo.lemma.data.PrimitiveInteger;
import de.fhdo.lemma.data.PrimitiveLong;
import de.fhdo.lemma.data.PrimitiveShort;
import de.fhdo.lemma.data.PrimitiveString;
import de.fhdo.lemma.data.PrimitiveValue;
import de.fhdo.lemma.data.Version;
import de.fhdo.lemma.data.services.DataDslGrammarAccess;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class DataDslSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private DataDslGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == DataPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case DataPackage.COMPLEX_TYPE_IMPORT:
				sequence_ComplexTypeImport(context, (ComplexTypeImport) semanticObject); 
				return; 
			case DataPackage.CONTEXT:
				sequence_Context(context, (Context) semanticObject); 
				return; 
			case DataPackage.DATA_FIELD:
				sequence_DataField(context, (DataField) semanticObject); 
				return; 
			case DataPackage.DATA_MODEL:
				sequence_DataModel(context, (DataModel) semanticObject); 
				return; 
			case DataPackage.DATA_STRUCTURE:
				sequence_DataStructure(context, (DataStructure) semanticObject); 
				return; 
			case DataPackage.ENUMERATION:
				sequence_Enumeration(context, (Enumeration) semanticObject); 
				return; 
			case DataPackage.ENUMERATION_FIELD:
				sequence_EnumerationField(context, (EnumerationField) semanticObject); 
				return; 
			case DataPackage.LIST_TYPE:
				sequence_ListType(context, (ListType) semanticObject); 
				return; 
			case DataPackage.POSSIBLY_IMPORTED_COMPLEX_TYPE:
				sequence_PossiblyImportedComplexType(context, (PossiblyImportedComplexType) semanticObject); 
				return; 
			case DataPackage.PRIMITIVE_BOOLEAN:
				sequence_PrimitiveType(context, (PrimitiveBoolean) semanticObject); 
				return; 
			case DataPackage.PRIMITIVE_BYTE:
				sequence_PrimitiveType(context, (PrimitiveByte) semanticObject); 
				return; 
			case DataPackage.PRIMITIVE_CHARACTER:
				sequence_PrimitiveType(context, (PrimitiveCharacter) semanticObject); 
				return; 
			case DataPackage.PRIMITIVE_DATE:
				sequence_PrimitiveType(context, (PrimitiveDate) semanticObject); 
				return; 
			case DataPackage.PRIMITIVE_DOUBLE:
				sequence_PrimitiveType(context, (PrimitiveDouble) semanticObject); 
				return; 
			case DataPackage.PRIMITIVE_FLOAT:
				sequence_PrimitiveType(context, (PrimitiveFloat) semanticObject); 
				return; 
			case DataPackage.PRIMITIVE_INTEGER:
				sequence_PrimitiveType(context, (PrimitiveInteger) semanticObject); 
				return; 
			case DataPackage.PRIMITIVE_LONG:
				sequence_PrimitiveType(context, (PrimitiveLong) semanticObject); 
				return; 
			case DataPackage.PRIMITIVE_SHORT:
				sequence_PrimitiveType(context, (PrimitiveShort) semanticObject); 
				return; 
			case DataPackage.PRIMITIVE_STRING:
				sequence_PrimitiveType(context, (PrimitiveString) semanticObject); 
				return; 
			case DataPackage.PRIMITIVE_VALUE:
				sequence_PrimitiveValue(context, (PrimitiveValue) semanticObject); 
				return; 
			case DataPackage.VERSION:
				sequence_Version(context, (Version) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     ComplexTypeImport returns ComplexTypeImport
	 *
	 * Constraint:
	 *     (importURI=STRING name=ID)
	 */
	protected void sequence_ComplexTypeImport(ISerializationContext context, ComplexTypeImport semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, DataPackage.Literals.COMPLEX_TYPE_IMPORT__IMPORT_URI) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DataPackage.Literals.COMPLEX_TYPE_IMPORT__IMPORT_URI));
			if (transientValues.isValueTransient(semanticObject, DataPackage.Literals.COMPLEX_TYPE_IMPORT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DataPackage.Literals.COMPLEX_TYPE_IMPORT__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getComplexTypeImportAccess().getImportURISTRINGTerminalRuleCall_3_0(), semanticObject.getImportURI());
		feeder.accept(grammarAccess.getComplexTypeImportAccess().getNameIDTerminalRuleCall_5_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Context returns Context
	 *
	 * Constraint:
	 *     (name=ID complexTypes+=ComplexType+)
	 */
	protected void sequence_Context(ISerializationContext context, Context semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DataField returns DataField
	 *
	 * Constraint:
	 *     (
	 *         hidden?='hide'? 
	 *         (primitiveType=PrimitiveType | complexType=PossiblyImportedComplexType)? 
	 *         name=ID 
	 *         (features+=FieldFeature features+=FieldFeature*)?
	 *     )
	 */
	protected void sequence_DataField(ISerializationContext context, DataField semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DataModel returns DataModel
	 *
	 * Constraint:
	 *     (complexTypeImports+=ComplexTypeImport* (versions+=Version+ | contexts+=Context+ | complexTypes+=ComplexType+))
	 */
	protected void sequence_DataModel(ISerializationContext context, DataModel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ComplexType returns DataStructure
	 *     DataStructure returns DataStructure
	 *
	 * Constraint:
	 *     (name=ID super=[DataStructure|QualifiedName]? (dataFields+=DataField dataFields+=DataField*)?)
	 */
	protected void sequence_DataStructure(ISerializationContext context, DataStructure semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     EnumerationField returns EnumerationField
	 *
	 * Constraint:
	 *     (name=ID initializationValue=PrimitiveValue?)
	 */
	protected void sequence_EnumerationField(ISerializationContext context, EnumerationField semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ComplexType returns Enumeration
	 *     Enumeration returns Enumeration
	 *
	 * Constraint:
	 *     (name=ID fields+=EnumerationField fields+=EnumerationField*)
	 */
	protected void sequence_Enumeration(ISerializationContext context, Enumeration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ComplexType returns ListType
	 *     ListType returns ListType
	 *
	 * Constraint:
	 *     ((name=ID dataFields+=DataField dataFields+=DataField*) | (name=ID primitiveType=PrimitiveType))
	 */
	protected void sequence_ListType(ISerializationContext context, ListType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PossiblyImportedComplexType returns PossiblyImportedComplexType
	 *
	 * Constraint:
	 *     (import=[ComplexTypeImport|ID]? complexType=[ComplexType|QualifiedName])
	 */
	protected void sequence_PossiblyImportedComplexType(ISerializationContext context, PossiblyImportedComplexType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PrimitiveType returns PrimitiveBoolean
	 *
	 * Constraint:
	 *     {PrimitiveBoolean}
	 */
	protected void sequence_PrimitiveType(ISerializationContext context, PrimitiveBoolean semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PrimitiveType returns PrimitiveByte
	 *
	 * Constraint:
	 *     {PrimitiveByte}
	 */
	protected void sequence_PrimitiveType(ISerializationContext context, PrimitiveByte semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PrimitiveType returns PrimitiveCharacter
	 *
	 * Constraint:
	 *     {PrimitiveCharacter}
	 */
	protected void sequence_PrimitiveType(ISerializationContext context, PrimitiveCharacter semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PrimitiveType returns PrimitiveDate
	 *
	 * Constraint:
	 *     {PrimitiveDate}
	 */
	protected void sequence_PrimitiveType(ISerializationContext context, PrimitiveDate semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PrimitiveType returns PrimitiveDouble
	 *
	 * Constraint:
	 *     {PrimitiveDouble}
	 */
	protected void sequence_PrimitiveType(ISerializationContext context, PrimitiveDouble semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PrimitiveType returns PrimitiveFloat
	 *
	 * Constraint:
	 *     {PrimitiveFloat}
	 */
	protected void sequence_PrimitiveType(ISerializationContext context, PrimitiveFloat semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PrimitiveType returns PrimitiveInteger
	 *
	 * Constraint:
	 *     {PrimitiveInteger}
	 */
	protected void sequence_PrimitiveType(ISerializationContext context, PrimitiveInteger semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PrimitiveType returns PrimitiveLong
	 *
	 * Constraint:
	 *     {PrimitiveLong}
	 */
	protected void sequence_PrimitiveType(ISerializationContext context, PrimitiveLong semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PrimitiveType returns PrimitiveShort
	 *
	 * Constraint:
	 *     {PrimitiveShort}
	 */
	protected void sequence_PrimitiveType(ISerializationContext context, PrimitiveShort semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PrimitiveType returns PrimitiveString
	 *
	 * Constraint:
	 *     {PrimitiveString}
	 */
	protected void sequence_PrimitiveType(ISerializationContext context, PrimitiveString semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PrimitiveValue returns PrimitiveValue
	 *
	 * Constraint:
	 *     (numericValue=BIG_DECIMAL | booleanValue=BOOLEAN | stringValue=STRING)
	 */
	protected void sequence_PrimitiveValue(ISerializationContext context, PrimitiveValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Version returns Version
	 *
	 * Constraint:
	 *     (name=ID (complexTypes+=ComplexType+ | contexts+=Context+)?)
	 */
	protected void sequence_Version(ISerializationContext context, Version semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
