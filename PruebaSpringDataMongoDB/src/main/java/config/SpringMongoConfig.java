package config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.document.mongodb.MongoOperations;
import org.springframework.data.document.mongodb.MongoTemplate;
import org.springframework.data.document.mongodb.config.AbstractMongoConfiguration;
import com.mongodb.Mongo;

@Configuration
public class SpringMongoConfig extends AbstractMongoConfiguration {
 
	@Override
	public @Bean Mongo mongo() throws Exception {
//		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
//		MongoOperations mongoOperation = (MongoOperations)ctx.getBean("mongoTemplate");
		return new Mongo("localhost");
	}
 
	@Override
	public @Bean MongoTemplate mongoTemplate() throws Exception { 
		return new MongoTemplate(mongo(),"yourdb","yourCollection");
	}
 
}