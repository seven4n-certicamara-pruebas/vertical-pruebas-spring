package com.certicamara.pruebas.cache.estrategias;

import com.certicamara.pruebas.cache.CacheWrapper;

public class EstrategiaCargaClientes implements IEstrategiaCargaCache {

	@Override
	public void loadData(CacheWrapper cacheWrapper) {
		// TODO Auto-generated method stub
		cacheWrapper.put("marcial", "Cliente Marcial");
		cacheWrapper.put("marcela", "Cliente Marcela");
		cacheWrapper.put("hansen", "Cliente Hansen");
		cacheWrapper.put("steven", "Cliente Steven");
	}

}
