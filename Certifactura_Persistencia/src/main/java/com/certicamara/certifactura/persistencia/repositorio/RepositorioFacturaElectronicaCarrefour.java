package com.certicamara.certifactura.persistencia.repositorio;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import com.certicamara.certifactura.persistencia.contrato.IRepositorio;
import com.certicamara.certifactura.persistencia.dtos.FacturaElectronicaCarrefourDTO;
import com.certicamara.certifactura.persistencia.vo.FacturaElectronicaCarrefourVO;


public class RepositorioFacturaElectronicaCarrefour implements IRepositorio< FacturaElectronicaCarrefourDTO, FacturaElectronicaCarrefourVO >
{
	String collectionName="FacturaElectronicaCarrefour";
	//TODO Manejo nombres colecciones de MongoDB
	
	@Autowired
	MongoOperations mongoOperations;
	
	public void setMongoOperations(MongoOperations m){
		mongoOperations=m;
	}

	@Override
	public void guardar( FacturaElectronicaCarrefourDTO facturaElectronicaCarrefourDTO )
	{
		mongoOperations.save( facturaElectronicaCarrefourDTO, collectionName);		
	}

	@Override
	public void actualizar( FacturaElectronicaCarrefourDTO facturaElectronicaCarrefourDTO ) throws Exception
	{		
		if (buscar(new FacturaElectronicaCarrefourVO( facturaElectronicaCarrefourDTO.getId( ) ))==null){
			throw new Exception( "No se encontro la factura electronica" );
		}
		guardar( facturaElectronicaCarrefourDTO );
	}

	@Override
	public FacturaElectronicaCarrefourDTO buscar( FacturaElectronicaCarrefourVO llave ) throws Exception
	{		
		FacturaElectronicaCarrefourDTO facturaElectronicaDTO = mongoOperations.findById( llave.getId( ), FacturaElectronicaCarrefourDTO.class, collectionName );		
		if (facturaElectronicaDTO==null){
			throw new Exception( "No se encontro la factura electronica" );
		}
		return facturaElectronicaDTO;
	}

	
}
