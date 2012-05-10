package com.certicamara.certifactura.aplicacion.comandos.facturaElectronica;

import java.io.IOException;
import java.util.HashMap;

import com.certicamara.certifactura.aplicacion.comandos.IComandoDTO;
import com.certicamara.certifactura.dominio.conceptos.facturaElectronica.IComandoCrearFacturaElectronica;
import com.certicamara.certifactura.dominio.dtos.FacturaElectronicaDTO;
import com.certicamara.certifactura.infraestructura.excepciones.ExcepcionTecnica;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * CertiFactura
 * Certicámara S.A.
 * ComandoCrearFacturaElectronica
 * @author Seven4N Ltda.
 * Apr 19, 2012
 */
public class ComandoCrearFacturaElectronicaDTO implements IComandoDTO
{

	private String cadenaJsonFacturaCanonica;

	private String nombreCliente;
	
	private String cadenaJsonFacturaCliente;

	public ComandoCrearFacturaElectronicaDTO( String cadenaJsonFacturaCanonica, String cadenaJsonFacturaCliente, String nombreCliente )
	{
		this.cadenaJsonFacturaCanonica = cadenaJsonFacturaCanonica;
		this.nombreCliente = nombreCliente;
		this.cadenaJsonFacturaCliente = cadenaJsonFacturaCliente;
	}

	/**
	 * @return the cadenaJsonFacturaCanonica
	 */
	public String getCadenaJsonFacturaCanonica( )
	{
		return cadenaJsonFacturaCanonica;
	}

	/**
	 * @param cadenaJsonFacturaCanonica the cadenaJsonFacturaCanonica to set
	 */
	public void setCadenaJsonFacturaCanonica( String cadenaJsonFacturaCanonica )
	{
		this.cadenaJsonFacturaCanonica = cadenaJsonFacturaCanonica;
	}

	/**
	 * @return the nombreCliente
	 */
	public String getNombreCliente( )
	{
		return nombreCliente;
	}

	/**
	 * @param nombreCliente the nombreCliente to set
	 */
	public void setNombreCliente( String nombreCliente )
	{
		this.nombreCliente = nombreCliente;
	}

	/**
	 * @return the cadenaJsonFacturaCliente
	 */
	public String getCadenaJsonFacturaCliente( )
	{
		return cadenaJsonFacturaCliente;
	}

	/**
	 * @param cadenaJsonFacturaCliente the cadenaJsonFacturaCliente to set
	 */
	public void setCadenaJsonFacturaCliente( String cadenaJsonFacturaCliente )
	{
		this.cadenaJsonFacturaCliente = cadenaJsonFacturaCliente;
	}

	public void ejecutar( )
	{
		//Llamar la fachada del cliente
		Injector injector = Guice.createInjector( new ModuloComandoCrearFacturaElectronicaCliente( ( this.getNombreCliente( ) ) ) );
		IComandoCrearFacturaElectronica comandoCrearFacturaElectronicaCliente = injector.getInstance( IComandoCrearFacturaElectronica.class );
		
		//Crear Objetos de json, y pasarselos a la fachada
		FacturaElectronicaDTO facturaElectronicaCanonica = transformarJsonDto( this.cadenaJsonFacturaCanonica);
		HashMap< String, Object > mapaFacturaElectronicaCliente = transformarJsonMapa( this.cadenaJsonFacturaCliente);
		
		//llamar el servicio de la fachada
		comandoCrearFacturaElectronicaCliente.crearFacturaElectronica( facturaElectronicaCanonica, mapaFacturaElectronicaCliente);
	}
	
	private FacturaElectronicaDTO transformarJsonDto(String jsonFacturaElectronicaCanonica) throws ExcepcionTecnica{
		FacturaElectronicaDTO facturaElectronicaDTO;

		try
		{
			ObjectMapper mapper = new ObjectMapper();
			//Pasar de json a FacturaElectronicaDTO
			facturaElectronicaDTO = mapper.readValue( jsonFacturaElectronicaCanonica, FacturaElectronicaDTO.class );
		}
		catch ( JsonParseException e )
		{
			throw new ExcepcionTecnica( e.getClass( ).getSimpleName( )+" en ComandoGUICrearFacturaElectronica.transformarJsonDto "+e.getMessage( ),e );
		}
		catch ( JsonMappingException e )
		{
			throw new ExcepcionTecnica( e.getClass( ).getSimpleName( )+" en ComandoGUICrearFacturaElectronica.transformarJsonDto "+e.getMessage( ),e );
		}
		catch ( IOException e )
		{
			throw new ExcepcionTecnica( e.getClass( ).getSimpleName( )+" en ComandoGUICrearFacturaElectronica.transformarJsonDto "+e.getMessage( ),e );
		}
		
		return facturaElectronicaDTO;
	}
	
	@SuppressWarnings ( "unchecked" )
	private HashMap< String, Object > transformarJsonMapa(String jsonFacturaElectronicaCliente){
		HashMap<String,Object> mapaFacturaCliente;

		try
		{
			ObjectMapper mapper = new ObjectMapper();
			//Pasar de json a un mapa con los valores de la factura del cliente
			mapaFacturaCliente = mapper.readValue( jsonFacturaElectronicaCliente, HashMap.class );
		}
		catch ( JsonParseException e )
		{
			throw new ExcepcionTecnica( e.getClass( ).getSimpleName( )+" en ComandoGUICrearFacturaElectronica.transformarJsonMapa "+e.getMessage( ),e );
		}
		catch ( JsonMappingException e )
		{
			throw new ExcepcionTecnica( e.getClass( ).getSimpleName( )+" en ComandoGUICrearFacturaElectronica.transformarJsonMapa "+e.getMessage( ),e );
		}
		catch ( IOException e )
		{
			throw new ExcepcionTecnica( e.getClass( ).getSimpleName( )+" en ComandoGUICrearFacturaElectronica.transformarJsonMapa "+e.getMessage( ),e );
		}
		
		return mapaFacturaCliente;
	}


}
