package com.certicamara.certifactura.aplicacion.FacturaElectronica;

import com.certicamara.certifactura.aplicacion.Comando;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * CertiFactura
 * Certicámara S.A.
 * ComandoCrearFacturaElectronica
 * @author Seven4N Ltda.
 * Apr 19, 2012
 */
public class ComandoCrearFacturaElectronica implements Comando
{

	private String cadenaJson;

	private String nombreCliente;

	public ComandoCrearFacturaElectronica( String cadenaJson, String nombreCliente )
	{
		this.cadenaJson = cadenaJson;
		this.nombreCliente = nombreCliente;
	}

	public void ejecutar( )
	{
		Injector inj = Guice.createInjector( new ModuloCrearFacturaElectronica( "GeneradorFacturaElectronica" + nombreCliente ) );
		GeneradorFacturaElectronica generadorFacturaElectronica = inj.getInstance( GeneradorFacturaElectronica.class );
		generadorFacturaElectronica.crearFacturaElectronica( cadenaJson );
	}

	public String getCadenaJson( )
	{
		return cadenaJson;
	}

	public String getNombreCliente( )
	{
		return nombreCliente;
	}

}
