package com.certicamara.certifactura.aplicacion.FacturaElectronica.dto;

public class FacturaElectronica {

	private String nit;
	
	private String nombre;

	public FacturaElectronica(String nit, String nombre) {
		super();
		this.nit = nit;
		this.nombre = nombre;
	}

	public String getNit() {
		return nit;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return "FacturaElectronica [nit=" + nit + ", nombre=" + nombre + "]";
	}
}
