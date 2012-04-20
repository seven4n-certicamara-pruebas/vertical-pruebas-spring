package com.certicamara.certifactura.aplicacion.FacturaElectronica;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.certicamara.certifactura.aplicacion.Comando;
import com.certicamara.certifactura.aplicacion.GestorComandos;

/**
 * CertiFactura
 * Certicámara S.A.
 * PruebaFacturaElectronica
 * @author Seven4N Ltda.
 * Apr 19, 2012
 */
public class PruebaFacturaElectronica
{

	/**
	 * @param args
	 */
	public static void main( String[ ] args )
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext( "com/certicamara/certifactura/aplicacion/aplication-context.xml" );
		GestorComandos gestorComandos = ( GestorComandos ) ctx.getBean( "gestorComandos" );

		Comando comando = ( Comando ) new ComandoCrearFacturaElectronica( "{\"FacturaElectronica\": {\"nit\": \"TG056PB\",\"nombre\": \"Exito\"}}", "Exito" );
		gestorComandos.recibirComando( comando );
	}

}
