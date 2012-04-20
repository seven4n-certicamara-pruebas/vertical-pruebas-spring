package com.certicamara.certifactura.aplicacion;

public abstract class ComandoTest<T> {
	
	protected T instancia;
	
	protected String cadenaJson;
	
	public ComandoTest(T instancia, String cadenaJson) {
		super();
		this.instancia = instancia;
		this.cadenaJson = cadenaJson;
	}

	public abstract void ejecutar();

}
