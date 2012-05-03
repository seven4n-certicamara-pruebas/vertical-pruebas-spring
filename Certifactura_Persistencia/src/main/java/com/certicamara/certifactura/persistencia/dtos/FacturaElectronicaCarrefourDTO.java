package com.certicamara.certifactura.persistencia.dtos;



/**
 * CertiFactura
 * Certicámara S.A.
 * FacturaElectronicaCarrefour
 * @author Seven4N Ltda.
 * Apr 20, 2012
 */
public class FacturaElectronicaCarrefourDTO {
	
	private FacturaElectronicaDTO facturaCanonica;

	private String contenedor;
	
	private String id;
	

	public String getContenedor( )
	{
		return contenedor;
	}

	public void setContenedor( String contenedor )
	{
		this.contenedor = contenedor;
	}

	public FacturaElectronicaDTO getFacturaCanonica( )
	{
		return facturaCanonica;
	}

	public void setFacturaCanonica( FacturaElectronicaDTO facturaCanonica )
	{
		this.facturaCanonica = facturaCanonica;
	}

	public String getId( )
	{
		return id;
	}

	public void setId( String id )
	{
		this.id = id;
	}


}
