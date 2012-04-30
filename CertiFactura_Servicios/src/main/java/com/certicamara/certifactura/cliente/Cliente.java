package com.certicamara.certifactura.cliente;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * CertiFactura
 * Certicámara S.A.
 * Cliente
 * @author Seven4N Ltda.
 * Apr 25, 2012
 */
public class Cliente
{
	
	public static void main(String args[]){
		
		ApplicationContext contexto = new ClassPathXmlApplicationContext( "/client-beans.xml" );
		
		/*HelloWorld cliente = (HelloWorld)contexto.getBean("client");
		
		String mensaje = cliente.imprimeMensaje( "hola" );
		
		System.out.println("Mensaje --"+mensaje);*/
		
	}

}
