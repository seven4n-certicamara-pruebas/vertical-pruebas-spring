package com.certicamara.certifactura.aplicacion;

import com.certicamara.certifactura.aplicacion.comandos.IComandoDTO;
import com.certicamara.certifactura.infraestructura.excepciones.ExcepcionCertiFactura;


/**
 * CertiFactura
 * Certicámara S.A.
 * GestorComandos
 * @author Seven4N Ltda.
 * Apr 19, 2012
 */
public class GestorComandos
{

	public void recibirComando( IComandoDTO comando ) throws ExcepcionCertiFactura
	{
		comando.ejecutar( );
	}
}
