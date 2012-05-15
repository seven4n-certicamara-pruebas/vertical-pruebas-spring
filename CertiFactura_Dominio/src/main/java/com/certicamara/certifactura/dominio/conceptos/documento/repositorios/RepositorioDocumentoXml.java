package com.certicamara.certifactura.dominio.conceptos.documento.repositorios;

import com.certicamara.certifactura.dominio.ddd.IRepositorio;
import com.certicamara.certifactura.dominio.dtos.DocumentoXmlDTO;
import com.certicamara.certifactura.persistencia.vos.DocumentoXmlVO;

/**
 * CertiFactura Certicámara S.A. RepositorioDocumentoXmlFacturaElectronica
 * 
 * @author Seven4N Ltda. May 15, 2012
 */
public class RepositorioDocumentoXml extends IRepositorio< DocumentoXmlDTO >
{

	// ------------------------------
	// 			Constructores
	// ------------------------------

	/**
	 * Constructor encargado de inicializar un repositorio
	 * 
	 * @param collectionName
	 *            Nombre de la colección donde se va almacenar los documentos
	 * @param bdName
	 *            Nombre de la base de datos
	 */
	public RepositorioDocumentoXml( String collectionName, String bdName )
	{
		super( collectionName, bdName );
	}

	/**
	 * Constructor encargado de inicializar un repositorio
	 * 
	 * @param collectionName
	 *            Nombre de la colección donde se va almacenar las facturas
	 */
	public RepositorioDocumentoXml( String collectionName )
	{
		super( collectionName );
	}

	// ------------------------------
	// 			Métodos
	// ------------------------------

	/**
	 * Método encargado de guardar un documento XML
	 * 
	 * @param documentoXmlDTO
	 *            Documento Xml
	 */
	public void guardar( DocumentoXmlDTO documentoXmlDTO )
	{
		guardar( documentoXmlDTO, new DocumentoXmlVO( documentoXmlDTO.getId( ) ), DocumentoXmlDTO.class );
	}
}
