/**
 * IServiciosFacturaElectronica.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.certicamara.certifactura.servicios;

import javax.jws.WebParam;
import javax.jws.WebService;



/**
 * CertiFactura
 * Certicámara S.A.
 * IserviciosFacturaElectronica
 * EndPoint que permite establecer las firmas necesarias para la publicación de servicios relacionados con Factura Electronica
 * @author Seven4N Ltda.
 * Apr 27, 2012
 */
@WebService
public interface IServiciosFacturaElectronica extends java.rmi.Remote {
	
    
	/**
	 * Servicio que entrega una factura electronica para cada emisor  
	 * @param idEmisor
	 * @param idFactura
	 * @throws java.rmi.RemoteException
	 */
	public void entregarFacturaElectronica(@WebParam( name = "idEmisor") String idEmisor, @WebParam( name = "idFactura")  String idFactura) throws java.rmi.RemoteException;
    
    /**
     * Servicio que permite crear una factura electronica a partir de la factura canonica establecido en el modelo de negocio y la factura adicional establecido para cada
     * 
     * @param idEmisor
     * @param facturaElectronica
     * @param facturaParticular
     * @throws java.rmi.RemoteException
     */
    public void crearFacturaElectronica(@WebParam( name = "idEmisor") String idEmisor, @WebParam( name = "facturaElectronicaCanonica") com.certicamara.certifactura.dominio.dtos.FacturaElectronicaDTO facturaElectronicaCanonica, @WebParam( name = "camposAdicionales") Object facturaParticular) throws java.rmi.RemoteException;
}
