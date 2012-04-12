package com.certicamara.pruebas.cache;

import java.util.List;

import com.certicamara.pruebas.cache.constants.CacheNameEnum;

public interface ICertiFacturaAdministradorCaches {
	
	//-----------------------------------------------------------------
    // Methods
    //-----------------------------------------------------------------
	
	/**
     * Removes an element from a specific cache by its key 
     * @param cacheNameEnum Enumeration of the cache
     * @param elementKey Key of the element to be removed 
     */	
	public void removeElement(CacheNameEnum cacheNameEnum, String elementKey) ;

	/**
     * Clear a cache 
     * @param cacheNameEnum Enumeration of the cache to be cleared     
     */	
	public void clear(CacheNameEnum cacheNameEnum);
	
	/**
     * Returns the number of elements in a specific cache 
     * @param cacheNameEnum Enumeration of the cache
     * @return int number of elementos contained in the CacheNameEnum
     */	
	public int getNumElements(CacheNameEnum cacheNameEnum);
	
	/**
     * Puts an element in the cache 
     * @param cacheNameEnum Enumeration of the cache
     * @param elementKey Key of the element to be stored in the cache
     * @param elementValue ArrayList of the elements that are going to be stored in the cache     
     */	
	public void putElement(CacheNameEnum cacheNameEnum, String elementKey, Object elementValue);

	/**
     * Returns an element of the cache 
     * @param cacheNameEnum Enumeration of the cache
     * @param elementKey Key of the element to be retrieved from the cache
     */	
	public Object getElement(CacheNameEnum cacheNameEnum, String elementKey);
	
	/**
	 * @param cacheNameEnum
	 * @return
	 */
	public List< String > getKeys( CacheNameEnum cacheNameEnum );

}
