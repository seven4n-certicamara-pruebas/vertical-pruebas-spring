package com.certicamara.pruebas.cache;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import com.certicamara.pruebas.cache.estrategias.IEstrategiaCargaCache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class CacheWrapper {
	//-------------------
	//  Attributes
	//-------------------

	/**
	 * CacheManager from Ehcache
	 */
	private CacheManager cacheManager;

	/**
	 * Cache name to be referenced in the instance of the wrapper
	 */
	private final String cacheName;

	/**
	 * Load strategy 
	 */
	private IEstrategiaCargaCache loadStrategy;

	/**
	 * Resource stream de la configuracion del cache
	 */
	private final static InputStream CACHE_RESOURCE_CERTIFACTURA = CacheWrapper.class.getResourceAsStream( "certicamara_ehcache.xml" );

	//-------------------
	// Constructors
	//-------------------

	/**
	 * Default Constructor
	 * @param cacheName Cache name to be referenced in the instance of the wrapper
	 */
	public CacheWrapper( String cacheName, IEstrategiaCargaCache loadStrategy )
	{
		this.cacheName = cacheName;
		this.loadStrategy = loadStrategy;
	}

	//-------------------
	//  Methods
	//-------------------

	/**
	 * @return The cache keys
	 */
	public List< String > getKeys( )
	{
		return getCache( ).getKeys( );
	}
	
	/**
	 * Inserts an element into the cache
	 * @param key Key of the element to be inserted
	 * @paran value Value of the element to be inserted
	 */
	public void put( String key, Object value )
	{
		Cache cache = getCache( );
		cache.acquireWriteLockOnKey(key);
		try {

			cache.put( new Element( key, value ) );
		}
		finally
		{
			cache.releaseWriteLockOnKey(key);
		}
	}

	/**
	 *	 
	 * Retrieves an element from the cache instantiated
	 * @param key Key of the element to be retrieved
	 * @return Object the element from the cache
	 */
	public Object get( String key )
	{
		Element element;
		Cache cache =  getCache( );

		cache.acquireReadLockOnKey( key );
		try
		{
			element = cache.get( key );
		}
		finally
		{
			cache.releaseReadLockOnKey( key );
		}

		if ( element != null )
		{
			return element.getObjectValue( );
		}
		else
		{
			loadData( );
			Element elementAfterLoad;
			cache.acquireReadLockOnKey( key );
			try
			{
				elementAfterLoad = getCache( ).get( key );
			}
			finally
			{
				cache.releaseReadLockOnKey( key );
			}

			return elementAfterLoad == null ? null : elementAfterLoad.getValue( );
		}


	}

	/**
	 *	 
	 * Removes an element from the cacje
	 * @param key Key of the element to be removed
	 */
	public void remove( String key )
	{
		getCache( ).remove( key );
	}

	/**
	 *	 
	 * Size of the cache instantiated
	 * @return int the size of the cache
	 */
	public int size( )
	{
		return getCache( ).getSize( );
	}

	/**
	 *	 
	 * Clears all the elements of the cache instantiated
	 */
	public void clear( )
	{
		getCache( ).removeAll( );
		getCache( ).flush( );
	}

	/**
	 *	 
	 * Shuts down the instance of the cache manager
	 */
	public void shutdown( )
	{
		cacheManager.shutdown( );
	}

	//-------------------
	//Private Methods
	//-------------------

	/**
	 *	 
	 * Getter of the cache
	 * The cache is obtained from the cache manager, based on the name of the cache of the instance
	 * @return Cache Instance of the cache.
	 */
	private Cache getCache( )
	{
		Iterator< CacheManager > allCaches = CacheManager.ALL_CACHE_MANAGERS.iterator( );
		CacheManager cacheManager = null;
		while ( allCaches.hasNext( ) )
		{
			CacheManager cacheManagerIter = ( CacheManager ) allCaches.next( );
			if(cacheManagerIter.getName( ).equals("CertiFacturaCacheManager")){
				cacheManager = cacheManagerIter;
			}			
		}
		if (cacheManager == null){
			cacheManager = new CacheManager( CACHE_RESOURCE_CERTIFACTURA );
			CacheManager.ALL_CACHE_MANAGERS.add( cacheManager );
		}
		return cacheManager.getCache( this.cacheName );

	}

	/**
	 * Loads the basic data
	 */
	private void loadData( )
	{
		loadStrategy.loadData( this );
	}
}
