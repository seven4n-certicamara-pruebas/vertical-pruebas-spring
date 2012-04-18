package core;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.document.mongodb.MongoOperations;
import org.springframework.data.document.mongodb.query.Criteria;
import org.springframework.data.document.mongodb.query.Query;
import org.springframework.data.document.mongodb.query.Update;
import config.SpringMongoConfig;
import model.User;
 
public class App
{
 
    public static void main( String[] args )
    {
    	//For Annotation
    	ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
 
    	//For XML
    	//ApplicationContext ctx = new GenericXmlApplicationContext("mongo-config.xml");
 
    	MongoOperations mongoOperation = (MongoOperations)ctx.getBean("mongoTemplate");
 
        User user = new User("1001", "yong", "mook kim", 30);
 
        //save
        mongoOperation.save("userprofile",user);
 
        //find
        User savedUser = mongoOperation.findOne("userprofile",
        		new Query(Criteria.where("id").is("1001")),
				User.class);
 
        System.out.println("savedUser : " + savedUser);
 
        //update
        mongoOperation.updateFirst("userprofile",
        		new Query(Criteria.where("firstname").is("yong")), 
        		Update.update("lastname", "new lastname"));
 
        //find
        User updatedUser = mongoOperation.findOne("userprofile",
        		new Query(Criteria.where("id").is("1001")),
				User.class);
 
        System.out.println("updatedUser : " + updatedUser);
 
        //delete
        mongoOperation.remove("userprofile",
        		new Query(Criteria.where("id").is("1001")),
        		User.class);
 
        //List
        List<User> listUser =  
        	mongoOperation.getCollection("userprofile", User.class);
        System.out.println("Number of user = " + listUser.size());
 
    }
 
}