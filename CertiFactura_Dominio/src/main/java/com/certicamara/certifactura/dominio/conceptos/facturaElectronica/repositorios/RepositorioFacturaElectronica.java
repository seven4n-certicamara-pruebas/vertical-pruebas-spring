package com.certicamara.certifactura.dominio.conceptos.facturaElectronica.repositorios;


import java.net.UnknownHostException;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.certicamara.certifactura.dominio.ddd.IRepositorio;
import com.certicamara.certifactura.dominio.dtos.FacturaElectronicaDTO;
import com.certicamara.certifactura.infraestructura.excepciones.ExcepcionTecnica;
import com.certicamara.certifactura.persistencia.vos.FacturaElectronicaVO;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;


public class RepositorioFacturaElectronica implements IRepositorio< FacturaElectronicaDTO, FacturaElectronicaVO >
{
	String collectionName="FacturaElectronica"; 
	//TODO Manejo nombres colecciones de MongoDB
	
	
	
	MongoOperations mongoOperations;
	
	public RepositorioFacturaElectronica( ) throws ExcepcionTecnica
	{
		try
		{
			MongoTemplate template = new MongoTemplate( new SimpleMongoDbFactory( new Mongo( ), "Certicamara" ) );
			template.setWriteConcern( WriteConcern.SAFE );
			mongoOperations = template;
		}
		catch ( UnknownHostException e )
		{
			throw new ExcepcionTecnica( e.getClass( ).getSimpleName( )+" en RepositorioFacturaElectronicaCarrefour.RepositorioFacturaElectronicaCarrefour "+e.getMessage( ),e );
		}
		catch ( MongoException e )
		{
			throw new ExcepcionTecnica( e.getClass( ).getSimpleName( )+" en RepositorioFacturaElectronicaCarrefour.RepositorioFacturaElectronicaCarrefour "+e.getMessage( ),e );
		}
		
	}
	
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
