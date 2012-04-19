package com.certicamara.certifactura.aplicacion.pruebas;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Prueba {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/certicamara/certifactura/aplicacion/pruebas/contexto-aplicacion.xml");

		BeanTest bean = (BeanTest) ctx.getBean("test");
		bean.testMethod();
	}

}
