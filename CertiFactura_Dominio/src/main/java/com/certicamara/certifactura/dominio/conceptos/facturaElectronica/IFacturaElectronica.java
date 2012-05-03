package com.certicamara.certifactura.dominio.conceptos.facturaElectronica;

/**
 * CertiFactura
 * Certicámara S.A.
 * IFacturaElectronica
 * @author Seven4N Ltda.
 * Apr 20, 2012
 */
public interface IFacturaElectronica
{
	/**
	 * Crea una Factura Electrónica 
	 */
	public void crearFacturaElectronica( );

	public void entregarFacturaElectronica( );

	public void aceptarFacturaElectronica( );

	public void agregarNotaDebitoElectronica( );

	public void entregarNotaDebitoElectronica( );
	
}
