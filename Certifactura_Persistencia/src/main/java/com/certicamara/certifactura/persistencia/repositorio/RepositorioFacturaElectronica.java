package com.certicamara.certifactura.persistencia.repositorio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import com.certicamara.certifactura.persistencia.contrato.IRepositorio;
import com.certicamara.certifactura.persistencia.dtos.FacturaElectronicaDTO;
import com.certicamara.certifactura.persistencia.vo.FacturaElectronicaVO;


public class RepositorioFacturaElectronica implements IRepositorio< FacturaElectronicaDTO, FacturaElectronicaVO >
{
	String collectionName="FacturaElectronica"; 
	//TODO Manejo nombres colecciones de MongoDB
	
	@Autowired
	MongoOperations mongoOperations;
	
	public void setMongoOperations(MongoOperations m){
		mongoOperations=m;
	}

	@Override
	public void guardar( FacturaElectronicaDTO facturaElectronicaDTO )
	{
		mongoOperations.save( facturaElectronicaDTO, collectionName);		
	}

	@Override
	public void actualizar( FacturaElectronicaDTO facturaElectronicaDTO ) throws Exception
	{		
		if (buscar(new FacturaElectronicaVO( facturaElectronicaDTO.getId( ) ))==null){
			throw new Exception( "No se encontro la factura electronica" );
		}
		guardar( facturaElectronicaDTO );
	}

	@Override
	public FacturaElectronicaDTO buscar( FacturaElectronicaVO facturaElectronicaVO ) throws Exception
	{		
		FacturaElectronicaDTO facturaElectronicaDTO = mongoOperations.findById( facturaElectronicaVO.getId( ), FacturaElectronicaDTO.class, collectionName );		
		if (facturaElectronicaDTO==null){
			throw new Exception( "No se encontro la factura electronica" );
		}
		return facturaElectronicaDTO;
	}

		
	
	
	
}
