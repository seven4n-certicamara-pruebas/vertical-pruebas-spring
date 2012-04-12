package com.seven4n.pruebaAmq;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestJms {
	
	public static void main(String[] args) {
	       
        ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/resources/META-INF/spring/app-context.xml");
        OrderService orderService = (OrderService) ctx.getBean("orderService");
       
        for(int i =1; i<=5; i++)
            orderService.sendOrder(1+i, 10.0D+i);
    }

}
