package com.certicamara.certifactura.dominio.clientes.facturaElectronica.repositorios;



import java.net.UnknownHostException;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.certicamara.certifactura.dominio.clientes.facturaElectronica.dtos.FacturaElectronicaCarrefourDTO;
import com.certicamara.certifactura.dominio.ddd.IRepositorio;
import com.certicamara.certifactura.infraestructura.excepciones.ExcepcionTecnica;
import com.certicamara.certifactura.persistencia.clientes.facturaElectronica.vos.FacturaElectronicaCarrefourVO;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;


public class RepositorioFacturaElectronicaCarrefour implements IRepositorio< FacturaElectronicaCarrefourDTO, FacturaElectronicaCarrefourVO >
{
	String collectionName="FacturaElectronicaCarrefour";
	//TODO Manejo nombres colecciones de MongoDB
	
	MongoOperations mongoOperations;
	
	
	
	public RepositorioFacturaElectronicaCarrefour( ) throws ExcepcionTecnica
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
