package com.certicamara.certifactura.dominio.clientes.facturaElectronica;

import com.certicamara.certifactura.dominio.clientes.facturaElectronica.dtos.FacturaElectronicaCarrefourDTO;
import com.certicamara.certifactura.dominio.clientes.facturaElectronica.repositorios.RepositorioFacturaElectronicaCarrefour;
import com.certicamara.certifactura.dominio.conceptos.facturaElectronica.FacturaElectronica;
import com.certicamara.certifactura.dominio.conceptos.facturaElectronica.IFacturaElectronica;
import com.certicamara.certifactura.infraestructura.excepciones.ExcepcionCertiFactura;

/**
 * CertiFactura
 * Certicámara S.A.
 * FacturaElectronicaCarrefour
 * @author Seven4N Ltda.
 * Apr 20, 2012
 */
public class FacturaElectronicaCarrefour implements IFacturaElectronica{
	
	private FacturaElectronica facturaCanonica;
	
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

	public String getId( )
	{
		return id;
	}

	public void setId( String id )
	{
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see com.certicamara.certifactura.dominio.conceptos.facturaElectronica.IFacturaElectronica#crearFacturaElectronica()
	 */
	@Override
	final public void crearFacturaElectronica( ) throws ExcepcionCertiFactura
	{
		//MIRAR SI EXISTE CONTENEDOR
		System.out.println("EN FacturaElectronicaCarrefour.crearFacturaElectronica()");
		
		//llamar método de factura electrónica(este es el que maneja el ciclo de vida)
		this.getFacturaCanonica( ).crearFacturaElectronica( );
		
		//si todo ok con la conónica, persistir la personalizada
		//llamar el repositorio y que se guarde
		RepositorioFacturaElectronicaCarrefour repo = new RepositorioFacturaElectronicaCarrefour("FacturaCarrefour","Certicamara" );
		repo.guardar( this.obtenerDTO( ) );
	}

	/* (non-Javadoc)
	 * @see com.certicamara.certifactura.dominio.conceptos.facturaElectronica.IFacturaElectronica#entregarFacturaElectronica()
	 */
	@Override
	public void entregarFacturaElectronica( ) throws ExcepcionCertiFactura
	{
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.certicamara.certifactura.dominio.conceptos.facturaElectronica.IFacturaElectronica#aceptarFacturaElectronica()
	 */
	@Override
	public void aceptarFacturaElectronica( ) throws ExcepcionCertiFactura
	{
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.certicamara.certifactura.dominio.conceptos.facturaElectronica.IFacturaElectronica#agregarNotaDebitoElectronica()
	 */
	@Override
	public void agregarNotaDebitoElectronica( ) throws ExcepcionCertiFactura
	{
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.certicamara.certifactura.dominio.conceptos.facturaElectronica.IFacturaElectronica#entregarNotaDebitoElectronica()
	 */
	@Override
	public void entregarNotaDebitoElectronica( ) throws ExcepcionCertiFactura
	{
		// TODO Auto-generated method stub
		
	}

	public FacturaElectronica getFacturaCanonica( )
	{
		return facturaCanonica;
	}

	public void setFacturaCanonica( FacturaElectronica facturaCanonica )
	{
		this.facturaCanonica = facturaCanonica;
	}
	
	public FacturaElectronicaCarrefourDTO obtenerDTO()
	{
		FacturaElectronicaCarrefourDTO dto = new FacturaElectronicaCarrefourDTO( );
		dto.setContenedor( this.getContenedor( ) );
		dto.setId( this.getId( ) );
		
		return dto;
	}
}