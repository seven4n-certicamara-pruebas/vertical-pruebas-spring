package com.certicamara.certifactura.persistencia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.certicamara.certifactura.persistencia.repositorio.RepositorioFacturaElectronica;
import com.certicamara.certifactura.persistencia.repositorio.RepositorioFacturaElectronicaCarrefour;
import com.mongodb.Mongo;
import com.mongodb.WriteConcern;

@Configuration
public class AppConfig
{
	@Bean
	public MongoDbFactory mongoDbFactory( ) throws Exception
	{
		return new SimpleMongoDbFactory( new Mongo( ), "Certicamara" );
	}

	@Bean
	public MongoTemplate mongoTemplate( ) throws Exception
	{
		MongoTemplate template = new MongoTemplate( mongoDbFactory( ) );
		template.setWriteConcern( WriteConcern.SAFE );
		return template;
	}
	
	@Bean
	public RepositorioFacturaElectronicaCarrefour repositorioFacturaElectronicaCarrefour( ) throws Exception
	{
		RepositorioFacturaElectronicaCarrefour repositorioFacturaElectronicaCarrefour=new RepositorioFacturaElectronicaCarrefour();
		return repositorioFacturaElectronicaCarrefour;
	}
	
	@Bean
	public RepositorioFacturaElectronica repositorioFacturaElectronica( ) throws Exception
	{
		RepositorioFacturaElectronica repositorioFacturaElectronica=new RepositorioFacturaElectronica();
		return repositorioFacturaElectronica;
	}

}