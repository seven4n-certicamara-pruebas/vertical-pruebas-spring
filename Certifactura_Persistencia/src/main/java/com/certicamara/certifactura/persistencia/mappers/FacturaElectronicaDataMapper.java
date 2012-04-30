package com.certicamara.certifactura.persistencia.mappers;

import java.util.Date;

import com.certicamara.certifactura.dominio.dtos.FacturaElectronicaDTO;
import com.certicamara.certifactura.persistencia.dboObject.FacturaElectronicaCanonicaDBO;
import com.mongodb.DBObject;


public class FacturaElectronicaDataMapper
{
	public FacturaElectronicaDTO obtenerFacturaElectronicaDto(FacturaElectronicaCanonicaDBO facturaElectronicaCanonicaDBO){
		FacturaElectronicaDTO facturaElectronicaDto=new FacturaElectronicaDTO( );
		facturaElectronicaDto.setConsecutivoIdentificador(facturaElectronicaCanonicaDBO.getString( "consecutivoIdentificador" )); 
		facturaElectronicaDto.setEstado(facturaElectronicaCanonicaDBO.getString( "estado" ));
		facturaElectronicaDto.setFecha((Date)facturaElectronicaCanonicaDBO.get( "fecha" ));
		facturaElectronicaDto.setIdentificacionEmisor(facturaElectronicaCanonicaDBO.getString( "identificacionEmisor" ));
		facturaElectronicaDto.setIdentificacionReceptor(facturaElectronicaCanonicaDBO.getString( "identificacionReceptor" ));		
		return facturaElectronicaDto;
	}
	public FacturaElectronicaDTO obtenerFacturaElectronicaDto(DBObject facturaElectronicaCanonicaDBO){
		FacturaElectronicaDTO facturaElectronicaDto=new FacturaElectronicaDTO( );
		facturaElectronicaDto.setConsecutivoIdentificador((String)facturaElectronicaCanonicaDBO.get( "consecutivoIdentificador" )); 
		facturaElectronicaDto.setEstado((String)facturaElectronicaCanonicaDBO.get( "estado" ));
		facturaElectronicaDto.setFecha((Date)facturaElectronicaCanonicaDBO.get( "fecha" ));
		facturaElectronicaDto.setIdentificacionEmisor((String)facturaElectronicaCanonicaDBO.get( "identificacionEmisor" ));
		facturaElectronicaDto.setIdentificacionReceptor((String)facturaElectronicaCanonicaDBO.get( "identificacionReceptor" ));		
		return facturaElectronicaDto;
	}	
}
