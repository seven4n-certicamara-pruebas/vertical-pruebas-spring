package com.certicamara.certifactura.dominio.conceptos.facturaElectronica;

import java.util.HashMap;

import com.certicamara.certifactura.dominio.dtos.FacturaElectronicaDTO;

/**
 * CertiFactura
 * Certicámara S.A.
 * IFachadaServiciosFacturaElectronica
 * @author Seven4N Ltda.
 * Apr 27, 2012
 */
public interface IComandoExpedirFacturaElectronica
{
	public void expedirFacturaElectronica(FacturaElectronicaDTO facturaElectronicaCanonica, HashMap<String,Object> mapaCliente);
}





