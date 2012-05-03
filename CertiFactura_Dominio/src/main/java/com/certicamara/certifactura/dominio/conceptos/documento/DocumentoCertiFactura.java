package com.certicamara.certifactura.dominio.conceptos.documento;

import java.util.Collection;

/**
 * CertiFactura
 * Certicámara S.A.
 * DocumentoCertiFactura
 * @author Seven4N Ltda.
 * Apr 20, 2012
 */
public class DocumentoCertiFactura
{
	
	//------------------------------
	//        Atributos
	//------------------------------
	private Collection<ProductoCertiFactura> productos;
	private Collection<EstadoDocumentoCertiFactura> estados;
	private ListaAbonosCertiFactura listaAbonos;
	private Collection<SoporteAdjuntoCertiFactura > soportesAdjuntos;

	//------------------------------
	//        Constructores
	//------------------------------

	/**
	 * Constructor
	 */
	public DocumentoCertiFactura( Collection< ProductoCertiFactura > productos, Collection< EstadoDocumentoCertiFactura > estados, ListaAbonosCertiFactura listaAbonos, Collection< SoporteAdjuntoCertiFactura > soportesAdjuntos )
	{
		super( );
		this.productos = productos;
		this.estados = estados;
		this.listaAbonos = listaAbonos;
		this.soportesAdjuntos = soportesAdjuntos;
	}
	
	/**
	 * Constructor
	 */
	public DocumentoCertiFactura( )
	{
		// TODO Auto-generated constructor stub
	}

	//------------------------------
	//          Métodos
	//------------------------------
	/**
	 * @return the productos
	 */
	public Collection< ProductoCertiFactura > getProductos( )
	{
		return productos;
	}
	/**
	 * @param productos the productos to set
	 */
	public void setProductos( Collection< ProductoCertiFactura > productos )
	{
		this.productos = productos;
	}
	/**
	 * @return the estados
	 */
	public Collection< EstadoDocumentoCertiFactura > getEstados( )
	{
		return estados;
	}
	/**
	 * @param estados the estados to set
	 */
	public void setEstados( Collection< EstadoDocumentoCertiFactura > estados )
	{
		this.estados = estados;
	}
	public ListaAbonosCertiFactura getListaAbonos( )
	{
		return listaAbonos;
	}
	public void setListaAbonos( ListaAbonosCertiFactura listaAbonos )
	{
		this.listaAbonos = listaAbonos;
	}
	public Collection<SoporteAdjuntoCertiFactura > getSoportesAdjuntos( )
	{
		return soportesAdjuntos;
	}
	public void setSoportesAdjuntos( Collection<SoporteAdjuntoCertiFactura > soportesAdjuntos )
	{
		this.soportesAdjuntos = soportesAdjuntos;
	}

	//------------------------------
	//       Métodos Privados
	//------------------------------
}





