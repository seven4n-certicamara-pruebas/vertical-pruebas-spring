package com.certicamara.certifactura.dominio.clientes.facturaElectronica;

import com.certicamara.certifactura.dominio.conceptos.facturaElectronica.FacturaElectronica;
import com.certicamara.certifactura.dominio.conceptos.facturaElectronica.IFacturaElectronica;
import com.certicamara.certifactura.dominio.ddd.AggregateRoot;
import com.certicamara.certifactura.dominio.ddd.Entity;

/**
 * CertiFactura
 * Certicámara S.A.
 * FacturaElectronicaCarrefour
 * @author Seven4N Ltda.
 * Apr 20, 2012
 */
public class FacturaElectronicaCarrefour extends AggregateRoot implements IFacturaElectronica{
	
	private FacturaElectronica facturaCanonica;
	
	private String contenedor;

	public String getContenedor( )
	{
		return contenedor;
	}

	public void setContenedor( String contenedor )
	{
		this.contenedor = contenedor;
	}

	/* (non-Javadoc)
	 * @see com.certicamara.certifactura.dominio.conceptos.facturaElectronica.IFacturaElectronica#crearFacturaElectronica()
	 */
	@Override
	final public void crearFacturaElectronica( )
	{
		//MIRAR SI EXISTE CONTENEDOR
		System.out.println(this.getFacturaCanonica( ));
		System.out.println("conetenedor="+this.getContenedor( ));
		//llamar método de factura electrónica(este es el que maneja el ciclo de vida)
		System.out.println("llamando factura método de Factura Electronica Cononica");
		//si todo ok con la conónica, persistir la personalizada
		//llamar el repositorio y que se guarde
		//TODO COMPLETAR
	}

	/* (non-Javadoc)
	 * @see com.certicamara.certifactura.dominio.conceptos.facturaElectronica.IFacturaElectronica#entregarFacturaElectronica()
	 */
	@Override
	public void entregarFacturaElectronica( )
	{
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.certicamara.certifactura.dominio.conceptos.facturaElectronica.IFacturaElectronica#aceptarFacturaElectronica()
	 */
	@Override
	public void aceptarFacturaElectronica( )
	{
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.certicamara.certifactura.dominio.conceptos.facturaElectronica.IFacturaElectronica#agregarNotaDebitoElectronica()
	 */
	@Override
	public void agregarNotaDebitoElectronica( )
	{
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.certicamara.certifactura.dominio.conceptos.facturaElectronica.IFacturaElectronica#entregarNotaDebitoElectronica()
	 */
	@Override
	public void entregarNotaDebitoElectronica( )
	{
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.certicamara.certifactura.dominio.ddd.Entity#isSameEntityAs(com.certicamara.certifactura.dominio.ddd.Entity)
	 */
	@Override
	public boolean isSameEntityAs( Entity Entity )
	{
		// TODO Auto-generated method stub
		return false;
	}

	public FacturaElectronica getFacturaCanonica( )
	{
		return facturaCanonica;
	}

	public void setFacturaCanonica( FacturaElectronica facturaCanonica )
	{
		this.facturaCanonica = facturaCanonica;
	}


}
