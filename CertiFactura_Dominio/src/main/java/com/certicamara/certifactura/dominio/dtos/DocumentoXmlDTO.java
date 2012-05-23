package com.certicamara.certifactura.dominio.dtos;

import org.w3c.dom.Document;

/**
 * CertiFactura Certicámara S.A. DocumentoXmlFacturaElectronicaDTO
 * 
 * @author Seven4N Ltda. May 15, 2012
 */
public class DocumentoXmlDTO
{
	// ------------------------------
	// 			Atributos
	// ------------------------------

	/**
	 * Es la identificación del documento
	 */
	private String id;

	/**
	 * Es el documento en XML
	 */
	private byte[] documentoXml;

	// ------------------------------
	// 			Constructores
	// ------------------------------

	/**
	 * Constructor
	 */
	public DocumentoXmlDTO( String idDocumento, byte[] documentoXml )
	{
		super( );
		this.id = idDocumento;
		this.documentoXml = documentoXml;
	}

	/**
	 * Constructor
	 */
	public DocumentoXmlDTO( )
	{
	}

	// ------------------------------
	// 			Métodos
	// ------------------------------

	/**
	 * @return the documentoXml
	 */
	public byte[] getDocumentoXml( )
	{
		return documentoXml;
	}

	/**
	 * @return the id
	 */
	public String getId( )
	{
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId( String id )
	{
		this.id = id;
	}

	/**
	 * @param documentoXml
	 *            the documentoXml to set
	 */
	public void setDocumentoXml( byte[] documentoXml )
	{
		this.documentoXml = documentoXml;
	}

}
