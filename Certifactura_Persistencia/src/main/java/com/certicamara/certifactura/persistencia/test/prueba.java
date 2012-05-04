package com.certicamara.certifactura.persistencia.test;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import com.certicamara.certifactura.persistencia.config.AppConfig;
import com.certicamara.certifactura.persistencia.dtos.FacturaElectronicaCarrefourDTO;
import com.certicamara.certifactura.persistencia.dtos.FacturaElectronicaDTO;
import com.certicamara.certifactura.persistencia.repositorio.RepositorioFacturaElectronica;
import com.certicamara.certifactura.persistencia.repositorio.RepositorioFacturaElectronicaCarrefour;


public class prueba
{
	
    public static void main( String[] args ) throws Exception
    {
    	ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//    	MongoOperations mongoOperation = (MongoOperations)ctx.getBean("mongoTemplate");    	
    	    	
//    	RepositorioFacturaElectronica repositorioFacturaElectronica=new RepositorioFacturaElectronica( );
//    	RepositorioFacturaElectronicaCarrefour repositorioFacturaElectronicaCarrefour=new RepositorioFacturaElectronicaCarrefour();
    	
    	RepositorioFacturaElectronica repositorioFacturaElectronica=(RepositorioFacturaElectronica)ctx.getBean("repositorioFacturaElectronica");
    	RepositorioFacturaElectronicaCarrefour repositorioFacturaElectronicaCarrefour=(RepositorioFacturaElectronicaCarrefour)ctx.getBean("repositorioFacturaElectronicaCarrefour");

    	
//    	repositorioFacturaElectronica.setMongoOperations( mongoOperation );
//    	repositorioFacturaElectronicaCarrefour.setMongoOperations( mongoOperation ); 
    	
    	FacturaElectronicaCarrefourDTO facturaElectronicaCarrefourDTO=new FacturaElectronicaCarrefourDTO( );
    	facturaElectronicaCarrefourDTO.setId( "1" );
    	facturaElectronicaCarrefourDTO.setContenedor( "21321" );
    	
    	
    	
    	FacturaElectronicaDTO facturaElectronicaDTO=new FacturaElectronicaDTO( );
    	facturaElectronicaDTO.setEstado( "Mandado" );
    	facturaElectronicaDTO.setId( "1" );
    	facturaElectronicaDTO.setFecha( new Date( ));
    	facturaElectronicaDTO.setConsecutivoIdentificador("1");
    	facturaElectronicaDTO.setIdentificacionEmisor("3");
    	facturaElectronicaDTO.setIdentificacionReceptor("4");
    	
    	repositorioFacturaElectronica.guardar( facturaElectronicaDTO );
    	repositorioFacturaElectronicaCarrefour.guardar( facturaElectronicaCarrefourDTO );
    	
    	


    	
    }
}
