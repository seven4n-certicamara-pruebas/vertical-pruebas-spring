package com.certicamara.certifactura.persitencia.dboObject;

import com.certicamara.certifactura.dominio.clientes.facturaElectronica.dtos.FacturaElectronicaCarrefourDTO;
import com.mongodb.BasicDBObject;

public class FacturaElectronicaCarrefourDBO extends BasicDBObject
{
	public FacturaElectronicaCarrefourDBO( FacturaElectronicaCarrefourDTO facturaElectronicaCarrefourDTO)
	{
		darFacturaElectronicaCarrefourDBO( facturaElectronicaCarrefourDTO );
		
	}
	
	public FacturaElectronicaCarrefourDBO( )
	{
		// TODO Auto-generated constructor stub
	}

	public void darFacturaElectronicaCarrefourDBO(FacturaElectronicaCarrefourDTO facturaElectronicaCarrefourDTO){		
		put("contenedor" , facturaElectronicaCarrefourDTO.getContenedor( ) );				
	}
	public FacturaElectronicaCarrefourDBO obtenerFacturaElectronicaCarrefourDBO(FacturaElectronicaCarrefourDTO facturaElectronicaCarrefourDTO){
		return this;
	}

}
