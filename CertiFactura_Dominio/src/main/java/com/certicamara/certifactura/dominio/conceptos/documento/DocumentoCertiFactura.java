package com.certicamara.certifactura.dominio.conceptos.documento;

import java.util.Collection;

import co.s4n.osp.EntityWithStates;

/**
 * CertiFactura
 * Certicámara S.A.
 * DocumentoCertiFactura
 * @author Seven4N Ltda.
 * Apr 20, 2012
 */
public abstract class DocumentoCertiFactura extends EntityWithStates
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
		//TODO SETEAR ID
		super( "id" );
		this.productos = productos;
		this.estados = estados;
		this.listaAbonos = listaAbonos;
		this.soportesAdjuntos = soportesAdjuntos;
	}



	public DocumentoCertiFactura( String id )
	{
		super( id );
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





