package com.certicamara.certifactura.dominio.conceptos.facturaElectronica;

import com.certicamara.certifactura.infraestructura.excepciones.ExcepcionCertiFactura;

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
	public void crearFacturaElectronica( ) throws ExcepcionCertiFactura;

	public void entregarFacturaElectronica( ) throws ExcepcionCertiFactura;

	public void aceptarFacturaElectronica( ) throws ExcepcionCertiFactura;

	public void agregarNotaDebitoElectronica( ) throws ExcepcionCertiFactura;

	public void entregarNotaDebitoElectronica( ) throws ExcepcionCertiFactura;
	
}
