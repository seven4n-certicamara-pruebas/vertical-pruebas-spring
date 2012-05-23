package com.certicamara.certifactura.persistencia.vos;

/**
 * CertiFactura Certicámara S.A. DocumentoXmlVO
 * 
 * @author Seven4N Ltda. May 15, 2012
 */
public class DocumentoXmlVO implements IVo< String >
{
	// ------------------------------
	// 			Atributos
	// ------------------------------

	/**
	 * La identificación del documento XML
	 */
	private String id;

	// ------------------------------
	// 			Constructores
	// ------------------------------

	/**
	 * Constructor
	 */
	public DocumentoXmlVO( )
	{
	}

	/**
	 * Constructor
	 */
	public DocumentoXmlVO( String id )
	{
		super( );
		this.id = id;
	}

	// ------------------------------
	// 			Métodos
	// ------------------------------

	/**
	 * @return the id
	 */
	public String getId( )
	{
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId( String id )
	{
		this.id = id;
	}

}
