package com.certicamara.certifactura.infraestructura.utilitarios;

import java.io.File;
import java.io.StringWriter;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import com.certicamara.certifactura.infraestructura.excepciones.ExcepcionTecnica;

/**
 * CertiFactura Certicámara S.A. PojoADocumento
 * 
 * @author Seven4N Ltda. May 14, 2012
 */
public class ConvertidorPojoDocumento<T>
{

	// ------------------------------
	// Atributos
	// ------------------------------

	/**
	 * El tipo del Pojo que se maneja
	 */
	private final Class< ? extends T > tipoPojo;
	
	/**
	 * Indica la ubicación del esquema con el que se realizan las validaciones 
	 */
	private final String rutaEsquema;

	// ------------------------------
	// Constructores
	// ------------------------------

	/**
	 * 
	 * Constructor
	 */
	public ConvertidorPojoDocumento( Class< ? extends T > tipoPojo,  String rutaEsquema)
	{
		this.tipoPojo = tipoPojo;
		this.rutaEsquema = rutaEsquema;
	}

	// ------------------------------
	// Métodos
	// ------------------------------

	/**
	 * Dado un pojo, convierte éste en un documento XML tipo DOM. También valida que el pojo tenga una estructura correcta; que coincida con el XSD.
	 * @param pojo la instancia a convertir
	 * @return devuelve el documento
	 */
	public Document darDocumentoDomConValidacion( T pojo ) throws ExcepcionTecnica
	{
		try
		{
			// Crea la fábrica de esquemas y genera una instancia del esquema
			SchemaFactory sf = SchemaFactory.newInstance( XMLConstants.W3C_XML_SCHEMA_NS_URI );
			Schema schema = sf.newSchema( new File( rutaEsquema ) );//TODO cambiar la fuente de donde se carga el esquema

			// Crea el contexto JAXB e inicia el Marshaller
			JAXBContext context = JAXBContext.newInstance( tipoPojo );
			Marshaller m = context.createMarshaller( );
			m.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );
			m.setSchema( schema );

			// Crea una fábrica de constructores de documentos, genera un nuevo
			// constructor y crea una instancia de un documento donde quedara la
			// información del objeto
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance( );
			DocumentBuilder docBuilder = factory.newDocumentBuilder( );
			Document document = docBuilder.newDocument( );

			// Convierte el pojo en un documento
			m.marshal( pojo, document );

			return document;
		}
		catch ( IllegalArgumentException e )
		{
			throw new ExcepcionTecnica( e.getClass( ).getSimpleName( )+" en ConvertidorPojoDocumento.darDocumentoDomConValidacion "+e.getMessage( ),e );
		}
		catch ( NullPointerException e )
		{
			throw new ExcepcionTecnica( e.getClass( ).getSimpleName( )+" en ConvertidorPojoDocumento.darDocumentoDomConValidacion "+e.getMessage( ),e );
		}
		catch ( SAXException e )
		{
			throw new ExcepcionTecnica( e.getClass( ).getSimpleName( )+" en ConvertidorPojoDocumento.darDocumentoDomConValidacion "+e.getMessage( ),e );
		}
		catch ( UnsupportedOperationException e )
		{
			throw new ExcepcionTecnica( e.getClass( ).getSimpleName( )+" en ConvertidorPojoDocumento.darDocumentoDomConValidacion "+e.getMessage( ),e );
		}
		catch ( JAXBException e )
		{
			throw new ExcepcionTecnica( e.getClass( ).getSimpleName( )+" en ConvertidorPojoDocumento.darDocumentoDomConValidacion "+e.getMessage( ),e );
		}
		catch ( FactoryConfigurationError e )
		{
			throw new ExcepcionTecnica( e.getClass( ).getSimpleName( )+" en ConvertidorPojoDocumento.darDocumentoDomConValidacion "+e.getMessage( ),e );
		}
		catch ( ParserConfigurationException e ) 
		{
			throw new ExcepcionTecnica( e.getClass( ).getSimpleName( )+" en ConvertidorPojoDocumento.darDocumentoDomConValidacion "+e.getMessage( ),e );
		}

	}

	/**
	 * Dado un documento XML, convierte éste en un pojo. También valida que el documento tenga una estructura correcta; que coincida con el XSD.
	 * @param documentoDom la instancia a convertir
	 * @return devuelve una instancia del pojo
	 */
	public T darPojoConValidacion( Document documentoDom ) throws ExcepcionTecnica
	{
		try
		{
			// Crea la fábrica de esquemas y genera una instancia del esquema
			SchemaFactory sf = SchemaFactory.newInstance( XMLConstants.W3C_XML_SCHEMA_NS_URI );
			Schema schema = sf.newSchema( new File( rutaEsquema ) );

			// Crea el contexto JAXB e inicia el Unmarshaller
			JAXBContext context = JAXBContext.newInstance( tipoPojo );
			Unmarshaller um = context.createUnmarshaller( );
			um.setSchema( schema );

			// Convierte el documento en un pojo
			T pojo = ( T ) um.unmarshal( documentoDom );

			return pojo;
		}
		catch ( IllegalArgumentException e )
		{
			throw new ExcepcionTecnica( e.getClass( ).getSimpleName( )+" en ConvertidorPojoDocumento.darPojoConValidacion "+e.getMessage( ),e );
		}
		catch ( NullPointerException e )
		{
			throw new ExcepcionTecnica( e.getClass( ).getSimpleName( )+" en ConvertidorPojoDocumento.darPojoConValidacion "+e.getMessage( ),e );
		}
		catch ( SAXException e )
		{
			throw new ExcepcionTecnica( e.getClass( ).getSimpleName( )+" en ConvertidorPojoDocumento.darPojoConValidacion "+e.getMessage( ),e );
		}
		catch ( UnsupportedOperationException e )
		{
			throw new ExcepcionTecnica( e.getClass( ).getSimpleName( )+" en ConvertidorPojoDocumento.darPojoConValidacion "+e.getMessage( ),e );
		}
		catch ( JAXBException e )
		{
			throw new ExcepcionTecnica( e.getClass( ).getSimpleName( )+" en ConvertidorPojoDocumento.darPojoConValidacion "+e.getMessage( ),e );
		}
		catch ( FactoryConfigurationError e )
		{
			throw new ExcepcionTecnica( e.getClass( ).getSimpleName( )+" en ConvertidorPojoDocumento.darPojoConValidacion "+e.getMessage( ),e );
		}

	}

	/**
	 * Convierte un documento XML tipo DOM en un String
	 * @param documento es la instancia a convertir
	 * @return devuelve un string del documento dado
	 */
	public String xmlToString( Node documento ) throws ExcepcionTecnica
	{
		try
		{
			
			Source source = new DOMSource( documento );
			
			StringWriter stringWriter = new StringWriter( );
			
			Result result = new StreamResult( stringWriter );
			
			TransformerFactory factory = TransformerFactory.newInstance( );
			Transformer transformer = factory.newTransformer( );
			transformer.transform( source, result );
			
			return stringWriter.getBuffer( ).toString( );
		}
		catch ( TransformerConfigurationException e )
		{
			throw new ExcepcionTecnica( e.getClass( ).getSimpleName( )+" en ConvertidorPojoDocumento.xmlToString "+e.getMessage( ),e );
		}
		catch ( TransformerException e )
		{
			throw new ExcepcionTecnica( e.getClass( ).getSimpleName( )+" en ConvertidorPojoDocumento.xmlToString "+e.getMessage( ),e );
		}
	}
}
