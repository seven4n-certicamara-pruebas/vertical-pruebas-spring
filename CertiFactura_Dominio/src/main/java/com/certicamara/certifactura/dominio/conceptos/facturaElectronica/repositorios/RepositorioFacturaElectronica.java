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
			throw new ExcepcionTecnica( e.getClass( ).getSimpleName( )+" en RepositorioFacturaElectronica.RepositorioFacturaElectronica "+e.getMessage( ),e );
		}
		catch ( MongoException e )
		{
			throw new ExcepcionTecnica( e.getClass( ).getSimpleName( )+" en RepositorioFacturaElectronica.RepositorioFacturaElectronica "+e.getMessage( ),e );
		}
		
	}
	
	public void setMongoOperations(MongoOperations m){
		mongoOperations=m;
	}

	@Override
	public void guardar( FacturaElectronicaDTO facturaElectronicaDTO ) throws ExcepcionTecnica
	{
		try
		{
			buscar(new FacturaElectronicaVO( facturaElectronicaDTO.getId( ) ));
			throw new ExcepcionTecnica( "En RepositorioFacturaElectronica.guardar: Ya existe una factura electrónica con el mismo Id ",new Exception( ) );
		}
		catch ( ExcepcionTecnica e )
		{
			try{
				mongoOperations.save( facturaElectronicaDTO, collectionName);	
			}
			catch(RuntimeException ex){
				throw new ExcepcionTecnica( ex.getClass( ).getSimpleName( )+" en RepositorioFacturaElectronica.guardar "+ex.getMessage( ), ex);
			}
		}
	}

	@Override
	public void actualizar( FacturaElectronicaDTO facturaElectronicaDTO ) throws ExcepcionTecnica
	{		
		try
		{
			buscar(new FacturaElectronicaVO( facturaElectronicaDTO.getId( ) ));
			guardar( facturaElectronicaDTO );
		}
		catch ( ExcepcionTecnica e )
		{
			throw new ExcepcionTecnica( e.getClass( ).getSimpleName( )+" en RepositorioFacturaElectronica.actualizar: No se encontró la factura electrónica "+e.getMessage( ),e );
		}
		
	}

	@Override
	public FacturaElectronicaDTO buscar( FacturaElectronicaVO facturaElectronicaVO ) throws ExcepcionTecnica
	{		
		FacturaElectronicaDTO facturaElectronicaDTO = null;
		try{
			facturaElectronicaDTO = mongoOperations.findById( facturaElectronicaVO.getId( ), FacturaElectronicaDTO.class, collectionName );
		}
		catch(RuntimeException e){
			throw new ExcepcionTecnica( e.getClass( ).getSimpleName( )+" en RepositorioFacturaElectronica.buscar "+e.getMessage( ), e);
		}
			
		if (facturaElectronicaDTO==null){
			throw new ExcepcionTecnica( "En RepositorioFacturaElectronica.buscar: No se encontró la factura electrónica ", new Exception( ));
		}
		return facturaElectronicaDTO;
	}
	
}
