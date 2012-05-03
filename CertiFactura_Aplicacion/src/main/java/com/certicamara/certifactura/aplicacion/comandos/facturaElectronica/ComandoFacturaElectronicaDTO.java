package com.certicamara.certifactura.aplicacion.comandos.facturaElectronica;

/**
 * CertiFactura
 * Certicámara S.A.
 * GeneradorFacturaElectronica
 * @author Seven4N Ltda.
 * Apr 19, 2012
 */
public interface ComandoFacturaElectronicaDTO
{

	void crearFacturaElectronica( String cadenaJson );
	
	void entregarFacturaElectronica( String cadenaJson );

}
