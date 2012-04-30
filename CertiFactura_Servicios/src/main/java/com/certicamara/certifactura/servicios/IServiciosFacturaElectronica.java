package com.certicamara.certifactura.servicios;


import javax.jws.WebParam;
import javax.jws.WebService;

import com.certicamara.certifactura.dominio.dtos.FacturaElectronicaDTO;
import com.certicamara.certifactura.dto.ParejaDTO;

/**
 * CertiFactura
 * Certicámara S.A.
 * IserviciosFacturaElectronica
 * EndPoint que permite establecer las firmas necesarias para la publicación de servicios relacionados con Factura Electronica
 * @author Seven4N Ltda.
 * Apr 27, 2012
 */
@WebService
public interface IServiciosFacturaElectronica
{
	
	/**
	 * Servicio que permite crear una factura electronica a partir de la factura canonica establecido en el modelo de negocio y la factura adicional establecido para cada cliente
	 * 
	 * @param idEmisor Identificador del emisor
	 * @param facturaElectronica DTO de factura electronica canonica
	 * @param mapa Mapa de valores que conforman la factura para cada cliente, es decir los atributos que estan especificados para cada cliente
	 */
	void crearFacturaElectronica(@WebParam( name = "idEmisor") String idEmisor, @WebParam( name = "facturaElectronicaCanonica") FacturaElectronicaDTO facturaElectronica, @WebParam( name = "camposAdicionales") ParejaDTO parejaFacturaParticular);
	
	/**
	 * Servicio que entrega una factura electronica para cada emisor  
	 * 
	 * @param idEmisor Identificador del emisor de la factura
	 * @param idFactura identificador de la factura
	 */
	void entregarFacturaElectronica(@WebParam( name = "idEmisor") String idEmisor, @WebParam( name = "idFactura")  String idFactura);

}
