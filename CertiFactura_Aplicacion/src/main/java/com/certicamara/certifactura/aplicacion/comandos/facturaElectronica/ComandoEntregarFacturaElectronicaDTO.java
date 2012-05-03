package com.certicamara.certifactura.aplicacion.comandos.facturaElectronica;

import com.certicamara.certifactura.aplicacion.comandos.IComandoDTO;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * CertiFactura
 * Certicámara S.A.
 * ComandoCrearFacturaElectronica
 * @author Seven4N Ltda.
 * Apr 19, 2012
 */
public class ComandoEntregarFacturaElectronicaDTO implements IComandoDTO
{

	private String cadenaJson;

	private String nombreCliente;

	public ComandoEntregarFacturaElectronicaDTO( String cadenaJson, String nombreCliente )
	{
		this.cadenaJson = cadenaJson;
		this.nombreCliente = nombreCliente;
	}

	public void ejecutar( )
	{
		Injector inj = Guice.createInjector( new ModuloComandoCrearFacturaElectronicaCliente( "ComandoFacturaElectronica" + nombreCliente ) );
		ComandoFacturaElectronicaDTO generadorFacturaElectronica = inj.getInstance( ComandoFacturaElectronicaDTO.class );
		generadorFacturaElectronica.entregarFacturaElectronica(cadenaJson );
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
