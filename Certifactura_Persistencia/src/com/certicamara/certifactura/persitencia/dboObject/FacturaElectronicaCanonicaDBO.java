package com.certicamara.certifactura.persitencia.dboObject;

import com.certicamara.certifactura.dominio.dtos.FacturaElectronicaDTO;
import com.mongodb.BasicDBObject;

/**
 * CertiFactura
 * Certicámara S.A.
 * FacturaElectronicaDominio
 * @author Seven4N Ltda.
 * Apr 23, 2012
 */
public class FacturaElectronicaCanonicaDBO extends BasicDBObject {
	public FacturaElectronicaCanonicaDBO( FacturaElectronicaDTO facturaElectronicaDTO)
	{
		darFacturaElectronicaCanonicaDBO( facturaElectronicaDTO );
		
	}
	
	public void darFacturaElectronicaCanonicaDBO(FacturaElectronicaDTO facturaElectronicaDTO){		
		put("consecutivoIdentificador" , facturaElectronicaDTO.getConsecutivoIdentificador( ) );
		put("estado" , facturaElectronicaDTO.getEstado( ) );
		put("fecha" , facturaElectronicaDTO.getFecha( ) );
		put("identificacionEmisor" , facturaElectronicaDTO.getIdentificacionEmisor( ) );
		put("identificacionReceptor" , facturaElectronicaDTO.getIdentificacionReceptor( ) );		
	}
	public FacturaElectronicaCanonicaDBO obtenerFacturaElectronicaCanonicaDBO(FacturaElectronicaDTO facturaElectronicaDTO){
		return this;
	}
}
	


