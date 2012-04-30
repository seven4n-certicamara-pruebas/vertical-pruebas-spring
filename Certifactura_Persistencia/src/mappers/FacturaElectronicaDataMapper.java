package mappers;

import java.util.Date;

import com.certicamara.certifactura.dominio.dtos.FacturaElectronicaDTO;

import dboObject.FacturaElectronicaCanonicaDBO;

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
}
