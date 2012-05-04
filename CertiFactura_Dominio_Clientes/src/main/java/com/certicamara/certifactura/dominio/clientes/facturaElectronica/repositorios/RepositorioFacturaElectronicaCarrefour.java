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
	public void guardar( FacturaElectronicaCarrefourDTO facturaElectronicaCarrefourDTO ) throws ExcepcionTecnica
	{
		try
		{
			buscar(new FacturaElectronicaCarrefourVO( facturaElectronicaCarrefourDTO.getId( ) ));
			throw new ExcepcionTecnica( "En RepositorioFacturaElectronicaCarrefour.guardar: Ya existe una factura electrónica con el mismo Id ",new Exception( ) );
		}
		catch ( ExcepcionTecnica e )
		{
			try{
				mongoOperations.save( facturaElectronicaCarrefourDTO, collectionName);
			}
			catch(RuntimeException ex){
				throw new ExcepcionTecnica( ex.getClass( ).getSimpleName( )+" en RepositorioFacturaElectronicaCarrefour.guardar "+ex.getMessage( ), ex);
			}
		}
	}

	@Override
	public void actualizar( FacturaElectronicaCarrefourDTO facturaElectronicaCarrefourDTO ) throws ExcepcionTecnica
	{		
		try
		{
			buscar(new FacturaElectronicaCarrefourVO( facturaElectronicaCarrefourDTO.getId( ) ));
			guardar( facturaElectronicaCarrefourDTO );
		}
		catch ( ExcepcionTecnica e )
		{
			throw new ExcepcionTecnica( e.getClass( ).getSimpleName( )+" en RepositorioFacturaElectronicaCarrefour.actualizar: No se encontró la factura electrónica "+e.getMessage( ),e );
		}
		
	}

	@Override
	public FacturaElectronicaCarrefourDTO buscar( FacturaElectronicaCarrefourVO llave ) throws ExcepcionTecnica
	{		
		FacturaElectronicaCarrefourDTO facturaElectronicaDTO = null;
		try{
			facturaElectronicaDTO = mongoOperations.findById( llave.getId( ), FacturaElectronicaCarrefourDTO.class, collectionName );
		}
		catch(RuntimeException e){
			throw new ExcepcionTecnica( e.getClass( ).getSimpleName( )+" en RepositorioFacturaElectronicaCarrefour.buscar "+e.getMessage( ), e);
		}
		if (facturaElectronicaDTO==null){
			throw new ExcepcionTecnica( "En RepositorioFacturaElectronicaCarrefour.buscar: No se encontró la factura electrónica ", new Exception( ));
		}
		return facturaElectronicaDTO;
	}

	
}
