package com.certicamara.pruebas.cache.constants;

public enum CacheNameEnum {
	//-------------------------
		//     Enumeration
		//-------------------------

		/**
		 * Cache Enumerator for the table	 
		 */
		CERTIFACTURA_CLIENTES("CERTIFACTURA_CLIENTES", 0);

		//-------------------------
		//      Attributes
		//-------------------------

		/**
		 * Name of the cache, represents the table name	 
		 */	
		private final String cacheName;

		/**
		 * Ordinal of the enumerator	 
		 */	
		private final int ordinal;


		//-----------------------------------------------------------------
		// Constructor
		//-----------------------------------------------------------------	

		/**
		 * Default Constructor
		 * @param cacheName
		 * @param ordinal
		 */
		CacheNameEnum( String cacheName, int ordinal )
		{
			this.cacheName = cacheName;
			this.ordinal = ordinal;
		}

		//-----------------------------------------------------------------
		// Methods
		//-----------------------------------------------------------------

		/**
		 * Getter of the name of the cache
		 * @return The cache name
		 */
		public String getCacheName( ) 
		{
			return cacheName;
		}

		/**
		 * Getter of the ordinal
		 * @return The ordinal
		 */
		public int getOrdinal( ) 
		{
			return ordinal;
		}
}
