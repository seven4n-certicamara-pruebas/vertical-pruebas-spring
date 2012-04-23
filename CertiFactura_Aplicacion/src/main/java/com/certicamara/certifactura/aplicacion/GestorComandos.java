package com.certicamara.certifactura.aplicacion;

import com.certicamara.certifactura.aplicacion.FacturaElectronica.ComandoCrearFacturaElectronica;

/**
 * CertiFactura
 * Certicámara S.A.
 * GestorComandos
 * @author Seven4N Ltda.
 * Apr 19, 2012
 */
public class GestorComandos
{

	public void recibirComando( Comando comando )
	{

		if ( comando instanceof ComandoCrearFacturaElectronica )
		{
			comando.ejecutar( );
		}
	}

}
