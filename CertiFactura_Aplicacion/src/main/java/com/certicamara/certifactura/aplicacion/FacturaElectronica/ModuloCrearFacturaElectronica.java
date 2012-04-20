package com.certicamara.certifactura.aplicacion.FacturaElectronica;

import com.google.inject.AbstractModule;

public class ModuloCrearFacturaElectronica extends AbstractModule {

	private String nombreCliente;

	private static final String RUTA_CLASSES = "com.certicamara.certifactura.aplicacion.FacturaElectronica.";

	public ModuloCrearFacturaElectronica(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	@Override
	protected void configure() {
		try {
			bind(GeneradorFacturaElectronica.class).to((Class<? extends GeneradorFacturaElectronica>) Class.forName(RUTA_CLASSES + nombreCliente));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
