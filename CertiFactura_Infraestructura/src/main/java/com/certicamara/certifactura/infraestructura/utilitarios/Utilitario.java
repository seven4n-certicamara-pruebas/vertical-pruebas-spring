package com.certicamara.certifactura.infraestructura.utilitarios;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import com.certicamara.certifactura.infraestructura.excepciones.ExcepcionTecnica;

/**
 * CertiFactura
 * Certicámara S.A.
 * Util
 * @author Seven4N Ltda.
 * Apr 26, 2012
 */
public class Utilitario
{
	public static String primeraEnMayuscula(String palabra)
	{
		String s = palabra.substring( 0 ,1).toUpperCase( );
		String s2 = palabra.substring(1);
		return s+s2;
	}

	/**
	 * Establece el contenido de los atributos de un objeto, con base a un mapa que contiene el nombre del atributo y el valor a establecer
	 * @param objeto Objeto a establecer atributos
	 * @param mapa Mapa que contiene los nombres de los atributos y valores para cada uno
	 * @return Object con los valores a establecer en el mapa entregado
	 * @throws ExcepcionTecnica
	 */
	public static Object establecerAtributosPorReflexion(Object objeto, HashMap<String,Object> mapa) throws ExcepcionTecnica
	{
		Class clase = objeto.getClass( );
		Set<String> setLlaves = mapa.keySet( );
		Iterator<String> iteradorLlaves = setLlaves.iterator( );
		while ( iteradorLlaves.hasNext( ) )
		{
			String llave = ( String ) iteradorLlaves.next( );
			Object valor = mapa.get( llave );

			try
			{
				Method metodo = clase.getDeclaredMethod( "set"+Utilitario.primeraEnMayuscula(llave ), valor.getClass( ) );
				metodo.invoke( objeto, valor );
			}
			catch ( SecurityException e )
			{
				throw new ExcepcionTecnica( e.getClass( ).getSimpleName( )+" en Utilitario.establecerAtributosPorReflexion "+e.getMessage( ),e );
			}
			catch ( NoSuchMethodException e )
			{
				
				throw new ExcepcionTecnica( e.getClass( ).getSimpleName( )+" en Utilitario.establecerAtributosPorReflexion "+e.getMessage( ),e );
			}
			catch ( IllegalArgumentException e )
			{
				throw new ExcepcionTecnica( e.getClass( ).getSimpleName( )+" en Utilitario.establecerAtributosPorReflexion "+e.getMessage( ),e );
			}
			catch ( IllegalAccessException e )
			{
				throw new ExcepcionTecnica( e.getClass( ).getSimpleName( )+" en Utilitario.establecerAtributosPorReflexion "+e.getMessage( ),e );
			}
			catch ( InvocationTargetException e )
			{
				throw new ExcepcionTecnica( e.getClass( ).getSimpleName( )+" en Utilitario.establecerAtributosPorReflexion "+e.getMessage( ),e );
			}
		}
		return objeto;
	}
}





