package com.certicamara.certifactura.web.dominio;

import java.util.Date;
import java.util.List;

public class NotaDebitoElectronicaDominio {
	
	private FacturaElectronicaDominio facturaElectronica;
	
	private Date fecha;
	
	private List<ProductoDominio> productos;
	
	private String estado;

	public FacturaElectronicaDominio getFacturaElectronica() {
		return facturaElectronica;
	}

	public void setFacturaElectronica(FacturaElectronicaDominio facturaElectronica) {
		this.facturaElectronica = facturaElectronica;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<ProductoDominio> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductoDominio> productos) {
		this.productos = productos;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	

}
