package com.certicamara.certifactura.aplicacion.excepciones;

import com.certicamara.certifactura.infraestructura.excepciones.ExcepcionNegocio;

/**
 * CertiFactura
 * Certicámara S.A.
 * ExcepcionComandoNoExiste
 * @author Seven4N Ltda.
 * Apr 25, 2012
 */
public class ExcepcionComandoNoExiste extends ExcepcionNegocio
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8581741106223129138L;

	/**
	 * Constructor
	 */
	public ExcepcionComandoNoExiste( String mensaje, Throwable excepcion )
	{
		super( "ExcepcionComandoNoexiste: ", excepcion );
	}
}





