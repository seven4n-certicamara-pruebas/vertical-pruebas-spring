package com.certicamara.certifactura.dominio.conceptos.documento.repositorios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.LinkedHashMap;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.certicamara.certifactura.dominio.dtos.DocumentoXmlDTO;
import com.certicamara.certifactura.infraestructura.excepciones.ExcepcionNegocio;
import com.certicamara.certifactura.infraestructura.utilitarios.ConvertidorPojoDocumento;
import com.certicamara.certifactura.infraestructura.utilitarios.GeneradorDocumentosXml;
import com.certicamara.certifactura.persistencia.vos.DocumentoXmlVO;

/**
 * CertiFactura Certicámara S.A. RepositorioDocumentoXmlFacturaElectronicaTest
 * 
 * @author Seven4N Ltda. May 15, 2012
 */
public class RepositorioDocumentoXmlTest
{
	private DocumentoXmlDTO documentoPruebaDTO;

	private DocumentoXmlVO documentoPruebaVO;

	@Before
	public void inicializarDocumentoPrueba( )
	{
		Random generadorAleatorios = new Random( );

		String idDocumento = "Documento " + generadorAleatorios.nextInt( );
		LinkedHashMap< String, Object > mapaValoresFactura = new LinkedHashMap< String, Object >( );
		mapaValoresFactura.put( "id", idDocumento );
		mapaValoresFactura.put( "descripcion", "factura de prueba" );
		mapaValoresFactura.put( "fechaCreacion", "2001-09-08T20:46:40-05:00" );
		mapaValoresFactura.put( "valor", "963852" );

		LinkedHashMap< String, Object > mapaValoresEmisor = new LinkedHashMap< String, Object >( );
		mapaValoresEmisor.put( "descripcionEmisor", "cadena de comida exito" );
		mapaValoresEmisor.put( "idEmisor", "321654" );
		mapaValoresEmisor.put( "nombre", "exito" );

		mapaValoresFactura.put( "emisor", mapaValoresEmisor );

		documentoPruebaDTO = new DocumentoXmlDTO( idDocumento, ConvertidorPojoDocumento.convertirDocumentomlABytes( GeneradorDocumentosXml.generadorGenericoDeDocumentos( mapaValoresFactura, "facturaPrueba" ) ) );
		documentoPruebaVO = new DocumentoXmlVO( idDocumento );
	}

	/**
	 * Test method for
	 * {@link com.certicamara.certifactura.dominio.conceptos.documento.repositorios.RepositorioDocumentoXml#guardar(com.certicamara.certifactura.dominio.dtos.DocumentoXmlDTO)}
	 * .
	 */
	@Test
	public void testGuardarDocumentoXmlDTO( )
	{
		RepositorioDocumentoXml repositorioDocumentoXml = new RepositorioDocumentoXml( "ColeccionDocumentosPrueba", "BaseDatosPrueba" );
		repositorioDocumentoXml.guardar( documentoPruebaDTO );

		DocumentoXmlDTO documentoEnc = repositorioDocumentoXml.buscar( documentoPruebaVO, DocumentoXmlDTO.class );
		assertNotNull( documentoEnc );

		Document documentoXml = ConvertidorPojoDocumento.convertirBytesADocumentoXml( documentoEnc.getDocumentoXml( ) );
		Node nodoRaiz = documentoXml.getDocumentElement( );

		// Valida que el elemento raíz tenga el nombre correcto
		assertEquals( "facturaPrueba", nodoRaiz.getNodeName( ) );

		// Valida que el documento solo contenga un id y tenga éste
		// correctamente
		NodeList listaNodos = documentoXml.getElementsByTagName( "id" );
		assertEquals( 1, listaNodos.getLength( ) );
		assertEquals( documentoPruebaVO.getId( ), listaNodos.item( 0 ).getTextContent( ) );

		// Valida que el documento solo contenga un valor y tenga éste
		// correctamente
		listaNodos = documentoXml.getElementsByTagName( "valor" );
		assertEquals( 1, listaNodos.getLength( ) );
		assertEquals( "963852", listaNodos.item( 0 ).getTextContent( ) );

		// Valida que el documento solo contenga una fecha y tenga ésta
		// correctamente
		listaNodos = documentoXml.getElementsByTagName( "fechaCreacion" );
		assertEquals( 1, listaNodos.getLength( ) );
		assertEquals( "2001-09-08T20:46:40-05:00", listaNodos.item( 0 ).getTextContent( ) );

		// Valida que el documento solo contenga un nombre de emisor y tenga
		// éste correctamente
		listaNodos = documentoXml.getElementsByTagName( "descripcion" );
		assertEquals( 1, listaNodos.getLength( ) );
		assertEquals( "factura de prueba", listaNodos.item( 0 ).getTextContent( ) );

		// Valida que el documento solo contenga un id de emisor y tenga éste
		// correctamente
		listaNodos = documentoXml.getElementsByTagName( "idEmisor" );
		assertEquals( 1, listaNodos.getLength( ) );
		assertEquals( "321654", listaNodos.item( 0 ).getTextContent( ) );

		// Valida que el documento solo contenga un nombre de emisor y tenga
		// éste correctamente
		listaNodos = documentoXml.getElementsByTagName( "nombre" );
		assertEquals( 1, listaNodos.getLength( ) );
		assertEquals( "exito", listaNodos.item( 0 ).getTextContent( ) );

		// Valida que el documento solo contenga un id de emisor y tenga éste
		// correctamente
		listaNodos = documentoXml.getElementsByTagName( "descripcionEmisor" );
		assertEquals( 1, listaNodos.getLength( ) );
		assertEquals( "cadena de comida exito", listaNodos.item( 0 ).getTextContent( ) );
	}
	
	/**
	 * Test method for
	 * {@link com.certicamara.certifactura.dominio.conceptos.documento.repositorios.RepositorioDocumentoXml#guardar(com.certicamara.certifactura.dominio.dtos.DocumentoXmlDTO)}
	 * .
	 */
	@Test ( expected = ExcepcionNegocio.class )
	public void testGuardarDocumentoXmlDTOIgual( )
	{
		RepositorioDocumentoXml repositorioDocumentoXml = new RepositorioDocumentoXml( "ColeccionDocumentosPrueba", "BaseDatosPrueba" );
		repositorioDocumentoXml.guardar( documentoPruebaDTO );
		repositorioDocumentoXml.guardar( documentoPruebaDTO );
		
	}

	/**
	 * Test method for
	 * {@link com.certicamara.certifactura.dominio.conceptos.documento.repositorios.RepositorioDocumentoXml#buscar(com.certicamara.certifactura.persistencia.vos.IVo, java.lang.Class)}
	 * .
	 */
	@Test
	public void testBuscarIVoClassOfDocumentoXmlDTO( )
	{
		RepositorioDocumentoXml repositorioDocumentoXml = new RepositorioDocumentoXml( "ColeccionDocumentosPrueba", "BaseDatosPrueba" );
		repositorioDocumentoXml.guardar( documentoPruebaDTO );

		DocumentoXmlDTO documentoEnc = repositorioDocumentoXml.buscar( documentoPruebaVO, DocumentoXmlDTO.class );
		assertNotNull( documentoEnc );
	}
	
	/**
	 * Test method for
	 * {@link com.certicamara.certifactura.dominio.conceptos.documento.repositorios.RepositorioDocumentoXml#buscar(com.certicamara.certifactura.persistencia.vos.IVo, java.lang.Class)}
	 * .
	 */
	@Test
	public void testBuscarIVoClassOfDocumentoXmlDTONoExistente( )
	{
		RepositorioDocumentoXml repositorioDocumentoXml = new RepositorioDocumentoXml( "ColeccionDocumentosPrueba", "BaseDatosPrueba" );
		documentoPruebaVO.setId( documentoPruebaVO.getId( ) + 1 );

		DocumentoXmlDTO documentoEnc = repositorioDocumentoXml.buscar( documentoPruebaVO, DocumentoXmlDTO.class );
		assertNull( documentoEnc );
	}

}
