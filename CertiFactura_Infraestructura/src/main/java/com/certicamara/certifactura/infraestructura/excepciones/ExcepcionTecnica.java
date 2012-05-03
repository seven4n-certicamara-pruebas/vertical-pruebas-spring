package com.certicamara.certifactura.infraestructura.excepciones;

/**
 * CertiFactura
 * Certicámara S.A.
 * ExcepcionTecnica
 * @author Seven4N Ltda.
 * Apr 25, 2012
 */
public class ExcepcionTecnica extends ExcepcionCertiFactura
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -925445124995831375L;

	/**
	 * Constructor
	 */
	public ExcepcionTecnica( String mensaje, Throwable excepcion )
	{
		super( mensaje, excepcion );
	}
}





