package com.certicamara.certifactura.persistencia.test;

import java.net.UnknownHostException;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.document.mongodb.MongoOperations;

import com.certicamara.certifactura.dominio.clientes.facturaElectronica.dtos.FacturaElectronicaCarrefourDTO;
import com.certicamara.certifactura.dominio.dtos.FacturaElectronicaDTO;
import com.certicamara.certifactura.persistencia.config.SpringMongoConfig;
import com.certicamara.certifactura.persistencia.dboObject.FacturaElectronicaCanonicaDBO;
import com.certicamara.certifactura.persistencia.repositorio.FacturaElectronicaCarrefourRepository;
import com.certicamara.certifactura.persistencia.repositorio.FacturaElectronicaRepository;
import com.mongodb.Mongo;
import com.mongodb.MongoException;


public class prueba
{
	
    public static void main( String[] args ) throws Exception
    {
//    	ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("com/certicamara/certifactura/persistencia/config/Persistencia-Context.xml");
    	MongoOperations mongoOperation = (MongoOperations)ctx.getBean("mongoTemplate"); 
    	Mongo m = new Mongo( "localhost" );
    	//m.dropDatabase("Certicamara");    	    	
    	FacturaElectronicaRepository facturaRepository=new FacturaElectronicaRepository( );
    	FacturaElectronicaCarrefourRepository facturaElectronicaCarrefourRepository=new FacturaElectronicaCarrefourRepository();
    	facturaRepository.setMongoOperations( mongoOperation );
    	facturaElectronicaCarrefourRepository.setMongoOperations( mongoOperation );
//    	facturaElectronicaCarrefourRepository.setBaseDatos( db );
    	FacturaElectronicaDTO facturaElectronicaDTO=new FacturaElectronicaDTO( );
//    	facturaElectronicaDTO.setEstado( "change" );
//    	facturaElectronicaDTO.setFecha( new Date( ));
    	facturaElectronicaDTO.setConsecutivoIdentificador("1");
//    	facturaElectronicaDTO.setIdentificacionEmisor("2");
//    	facturaElectronicaDTO.setIdentificacionReceptor("4");
    	FacturaElectronicaCanonicaDBO facturaElectronicaCanonicaDBO=new FacturaElectronicaCanonicaDBO( facturaElectronicaDTO );
    	FacturaElectronicaDTO facturaElectronicaDTO2=facturaRepository.buscar( facturaElectronicaCanonicaDBO );  	
    	
    	FacturaElectronicaCarrefourDTO facturaElectronicaCarrefourDTO=new FacturaElectronicaCarrefourDTO( );
    	facturaElectronicaCarrefourDTO.setContenedor( "1" );
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
