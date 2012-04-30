package mappers;

import com.certicamara.certifactura.dominio.clientes.facturaElectronica.dtos.FacturaElectronicaCarrefourDTO;
import com.certicamara.certifactura.persitencia.dboObject.FacturaElectronicaCarrefourDBO;


public class FacturaElectronicaCarrefourDataMapper
{
	public FacturaElectronicaCarrefourDTO obtenerFacturaElectronicaCarrefourDto(FacturaElectronicaCarrefourDBO facturaElectronicaCarrefourDBO){
		FacturaElectronicaCarrefourDTO facturaElectronicaCarrefourDTO=new FacturaElectronicaCarrefourDTO( );
		facturaElectronicaCarrefourDTO.setContenedor(facturaElectronicaCarrefourDBO.getString( "contenedor" )); 
				
		return facturaElectronicaCarrefourDTO;
	}	
}
