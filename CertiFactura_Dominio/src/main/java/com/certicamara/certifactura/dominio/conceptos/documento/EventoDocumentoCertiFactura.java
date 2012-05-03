package com.certicamara.certifactura.dominio.conceptos.documento;

/**
 * CertiFactura
 * Certicámara S.A.
 * EventoDocumentoCertiFactura
 * @author Seven4N Ltda.
 * Apr 20, 2012
 */
public class EventoDocumentoCertiFactura
{
	//------------------------------
	//        Atributos
	//------------------------------
	private String nombre;

	//------------------------------
	//        Constructores
	//------------------------------
	/**
	 * Constructor
	 */
	public EventoDocumentoCertiFactura( )
	{
		// TODO Auto-generated constructor stub
	}
	
	public EventoDocumentoCertiFactura(String nombre )
	{
		this.nombre = nombre;
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

	//------------------------------
	//       Métodos Privados
	//------------------------------
}





