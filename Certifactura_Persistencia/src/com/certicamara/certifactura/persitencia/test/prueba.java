package com.certicamara.certifactura.persitencia.test;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.document.mongodb.MongoOperations;


import com.certicamara.certifactura.dominio.clientes.facturaElectronica.dtos.FacturaElectronicaCarrefourDTO;
import com.certicamara.certifactura.dominio.dtos.FacturaElectronicaDTO;
import com.certicamara.certifactura.persitencia.config.SpringMongoConfig;
import com.certicamara.certifactura.persitencia.dboObject.FacturaElectronicaCanonicaDBO;
import com.certicamara.certifactura.persitencia.mappers.FacturaElectronicaDataMapper;
import com.certicamara.certifactura.persitencia.repositorio.FacturaElectronicaCarrefourRepository;
import com.certicamara.certifactura.persitencia.repositorio.FacturaElectronicaRepository;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;


public class prueba
{
	
    public static void main( String[] args ) throws UnknownHostException, MongoException
    {
    	ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
    	MongoOperations mongoOperation = (MongoOperations)ctx.getBean("mongoTemplate"); 
    	Mongo m = new Mongo( "localhost" );
    	m.dropDatabase("Certicamara");    	    	
    	FacturaElectronicaRepository facturaRepository=new FacturaElectronicaRepository( );
    	FacturaElectronicaCarrefourRepository facturaElectronicaCarrefourRepository=new FacturaElectronicaCarrefourRepository();
    	facturaRepository.setMongoOperations( mongoOperation );
    	facturaElectronicaCarrefourRepository.setBaseDatos( db );
    	FacturaElectronicaDTO facturaElectronicaDTO=new FacturaElectronicaDTO( );
    	facturaElectronicaDTO.setEstado( "esta" );
    	facturaElectronicaDTO.setFecha( new Date( ));
    	facturaElectronicaDTO.setConsecutivoIdentificador("1");
    	facturaElectronicaDTO.setIdentificacionEmisor("2");
    	facturaElectronicaDTO.setIdentificacionReceptor("4");
    	facturaRepository.guardar( facturaElectronicaDTO );  	
    	
//    	FacturaElectronicaCarrefourDTO facturaElectronicaCarrefourDTO=new FacturaElectronicaCarrefourDTO( );
//    	facturaElectronicaCarrefourDTO.setContenedor( "1" );
//    	FacturaElectronicaCarrefourDTO facturaElectronicaCarrefourDTO2=new FacturaElectronicaCarrefourDTO( );
//    	facturaElectronicaCarrefourDTO2.setContenedor( "2" );
//    	try
//		{
//			facturaElectronicaCarrefourRepository.actualizar( facturaElectronicaCarrefourDTO,facturaElectronicaCarrefourDTO2 );
//		}
//		catch ( Exception e )
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	facturaElectronicaCarrefourRepository.guardar( facturaElectronicaCarrefourDTO );
    	
//    	ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
//    	MongoOperations mongoOperation = (MongoOperations)ctx.getBean("mongoTemplate");
    	
    	//
    	

    	
    }
}
