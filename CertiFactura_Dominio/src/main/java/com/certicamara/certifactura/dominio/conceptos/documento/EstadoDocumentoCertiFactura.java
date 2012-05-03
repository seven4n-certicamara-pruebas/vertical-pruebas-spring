package com.certicamara.certifactura.dominio.conceptos.documento;

import java.util.Collection;

/**
 * CertiFactura
 * Certicámara S.A.
 * EstadoDocumentoCertiFactura
 * @author Seven4N Ltda.
 * Apr 20, 2012
 */
public class EstadoDocumentoCertiFactura
{
	
	//------------------------------
	//        Atributos
	//------------------------------
	private String nombre;
	private Collection< EventoDocumentoCertiFactura > eventos;
	

	//------------------------------
	//        Constructores
	//------------------------------
	
	/**
	 * Constructor
	 */
	public EstadoDocumentoCertiFactura( String nombre, Collection< EventoDocumentoCertiFactura > eventos )
	{
		super( );
		this.nombre = nombre;
		this.eventos = eventos;
	}
	
	/**
	 * Constructor
	 */
	public EstadoDocumentoCertiFactura( )
	{
		// TODO Auto-generated constructor stub
	}
	
	

	//------------------------------
	//          Métodos
	//------------------------------
	public String getNombre( )
	{
		return nombre;
	}
	public void setNombre( String nombre )
	{
		this.nombre = nombre;
	}
	public Collection< EventoDocumentoCertiFactura > getEventos( )
	{
		return eventos;
	}
	public void setEventos( Collection< EventoDocumentoCertiFactura > eventos )
	{
		this.eventos = eventos;
	}

	//------------------------------
	//       Métodos Privados
	//------------------------------
}





