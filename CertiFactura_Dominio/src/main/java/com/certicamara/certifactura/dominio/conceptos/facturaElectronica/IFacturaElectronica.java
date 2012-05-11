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
	 * Genera, numera, firma/estampa y conserva una Factura Electrónica
	 * @throws ExcepcionCertiFactura
	 */
	public void expedirFacturaElectronica( ) throws ExcepcionCertiFactura;

	/**
	 * Entrega la factura electrónica al Adquiriente
	 * @throws ExcepcionCertiFactura
	 */
	public void entregarFacturaElectronica( ) throws ExcepcionCertiFactura;

	/**
	 * Acepta la factura electrónica por parte del Adquiriente
	 * @throws ExcepcionCertiFactura
	 */
	public void aceptarFacturaElectronica( ) throws ExcepcionCertiFactura;
	
	/**
	 * Rechaza la factura electrónica por parte del Adquiriente
	 * @throws ExcepcionCertiFactura
	 */
	public void rechazarFacturaElectronica( ) throws ExcepcionCertiFactura;
	
	/**
	 * Anula la factura electrónica por parte del Emisor
	 * @throws ExcepcionCertiFactura
	 */
	public void anularFacturaElectronica( ) throws ExcepcionCertiFactura;

	/**
	 * Agrega una nota débito electrónica a la factura electrónica
	 * @throws ExcepcionCertiFactura
	 */
	public void agregarNotaDebitoElectronica( ) throws ExcepcionCertiFactura;

	public void entregarNotaDebitoElectronica( ) throws ExcepcionCertiFactura;
	
}
