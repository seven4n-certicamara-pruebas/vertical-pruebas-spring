package com.certicamara.certifactura.persistencia.config;

import java.util.Arrays;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.Mongo;
import com.mongodb.WriteConcern;

@Configuration
public class AppConfig
{
	@Bean
	public MongoDbFactory mongoDbFactory( ) throws Exception
	{
		return new SimpleMongoDbFactory( new Mongo( ), "FacturaElectronica" );
	}

	@Bean
	public MongoTemplate mongoTemplate( ) throws Exception
	{
		MongoTemplate template = new MongoTemplate( mongoDbFactory( ) );
		template.setWriteConcern( WriteConcern.SAFE );
		return template;
	}

}