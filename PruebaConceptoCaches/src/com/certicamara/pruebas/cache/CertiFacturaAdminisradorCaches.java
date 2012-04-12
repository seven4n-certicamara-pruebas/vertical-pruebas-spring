package com.certicamara.pruebas.cache;

import java.util.Hashtable;
import java.util.List;

import com.certicamara.pruebas.cache.constants.CacheNameEnum;
import com.certicamara.pruebas.cache.estrategias.EstrategiaCargaClientes;

public class CertiFacturaAdminisradorCaches implements ICertiFacturaAdministradorCaches {

	//-----------------------------------------------------------------
	// Attributes
	//-----------------------------------------------------------------

	/**
	 * List of the caches
	 */
	private Hashtable< CacheNameEnum, CacheWrapper > caches;

	//-----------------------------------------------------------------
	// Constructor
	//-----------------------------------------------------------------

	/**
	 * Default constructor for the session bean
	 * Loads all the wrappers of every table cache	  
	 */
	public CertiFacturaAdminisradorCaches( )
	{
		caches = new Hashtable< CacheNameEnum, CacheWrapper >( );
		/* Cache de cLIENTES*/
		caches.put( CacheNameEnum.CERTIFACTURA_CLIENTES, new CacheWrapper( CacheNameEnum.CERTIFACTURA_CLIENTES.getCacheName( ), new EstrategiaCargaClientes( ) ) );
		//Acá se pueden ingresar más caches, con sus respectviso wrappers y estretegias de carga
	}

	//-----------------------------------------------------------------
	//	     Methods
	//-----------------------------------------------------------------

	/**
	 * Removes an element from a specific cache by its key 
	 * @param cacheNameEnum Enumeration of the cache
	 * @param elementKey Key of the element to be removed 
	 */
	public void removeElement( CacheNameEnum cacheNameEnum, String elementKey )
	{
		CacheWrapper cache = caches.get( cacheNameEnum );
		cache.remove( elementKey );
	}

	/**
	 * Clear a cache 
	 * @param cacheNameEnum Enumeration of the cache to be cleared     
	 */
	public void clear( CacheNameEnum cacheNameEnum )
	{
		CacheWrapper cache = caches.get( cacheNameEnum );
		cache.clear( );
	}

	/**
	 * Returns the number of elements in a specific cache 
	 * @param cacheNameEnum Enumeration of the cache
	 * @return int number of elementos contained in the CacheNameEnum
	 */
	public int getNumElements( CacheNameEnum cacheNameEnum )
	{
		CacheWrapper cache = caches.get( cacheNameEnum );
		int cacheSize = cache.size( );
		return cacheSize;
	}

	/**
	 * Puts an element in the cache 
	 * @param cacheNameEnum Enumeration of the cache
	 * @param elementKey Key of the element to be stored in the cache
	 * @param elementValue ArrayList of the elements that are going to be stored in the cache     
	 */
	public void putElement( CacheNameEnum cacheNameEnum, String elementKey, Object elementValue )
	{
		CacheWrapper cache = caches.get( cacheNameEnum );
		cache.put( elementKey, elementValue );
	}

	/**
	 * Returns an element of the cache 
	 * @param cacheNameEnum Enumeration of the cache
	 * @param elementKey Key of the element to be retrieved from the cache
	 */
	public Object getElement( CacheNameEnum cacheNameEnum, String elementKey )
	{
		CacheWrapper cache = caches.get( cacheNameEnum );
		Object object = cache.get( elementKey );
		return object;
	}

	/**
	 * @param cacheNameEnum The desired cache
	 * @return The keys of the cache
	 */
	public List< String > getKeys( CacheNameEnum cacheNameEnum )
	{
		CacheWrapper cacheWrapper = caches.get( cacheNameEnum );
		return cacheWrapper.getKeys( );
	}



}
