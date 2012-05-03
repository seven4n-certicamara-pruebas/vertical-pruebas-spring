package com.certicamara.certifactura.infraestructura.excepciones;

/**
 * CertiFactura
 * Certicámara S.A.
 * ExcepcionNegocio
 * @author Seven4N Ltda.
 * Apr 25, 2012
 */
public class ExcepcionCertiFactura extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7094459164524901482L;

	/**
	 * Constructor
	 */
	public ExcepcionCertiFactura(String mensaje,Throwable excepcion )
	{
		super( mensaje+": "+excepcion.getMessage( ), excepcion );
	}
}





