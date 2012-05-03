package com.certicamara.certifactura.infraestructura.excepciones;

/**
 * CertiFactura
 * Certicámara S.A.
 * ExcepcionNegocio
 * @author Seven4N Ltda.
 * Apr 25, 2012
 */
public class ExcepcionNegocio extends ExcepcionCertiFactura
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5273234137972575048L;

	/**
	 * Constructor
	 */
	public ExcepcionNegocio(String mensaje,Throwable excepcion )
	{
		super( mensaje, excepcion );
	}
	
	

}





