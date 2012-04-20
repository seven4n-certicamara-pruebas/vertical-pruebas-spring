package com.certicamara.certifactura.aplicacion.FacturaElectronica.dto;

import java.util.Date;

public class FacturaElectronica {

private Integer idConsecutivo;
	
	private Date fecha;
	
	private Integer idEmisor;
	
	private Integer idReceptor;
	
	private String estado;
	
	public FacturaElectronica(Integer idConsecutivo, Date fecha,
			Integer idEmisor, Integer idReceptor, String estado) {
		super();
		this.idConsecutivo = idConsecutivo;
		this.fecha = fecha;
		this.idEmisor = idEmisor;
		this.idReceptor = idReceptor;
		this.estado = estado;
	}

	public Integer getIdConsecutivo() {
		return idConsecutivo;
	}

	public void setIdConsecutivo(Integer idConsecutivo) {
		this.idConsecutivo = idConsecutivo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getIdEmisor() {
		return idEmisor;
	}

	public void setIdEmisor(Integer idEmisor) {
		this.idEmisor = idEmisor;
	}

	public Integer getIdReceptor() {
		return idReceptor;
	}

	public void setIdReceptor(Integer idReceptor) {
		this.idReceptor = idReceptor;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "FacturaElectronica [idConsecutivo=" + idConsecutivo
				+ ", fecha=" + fecha + ", idEmisor=" + idEmisor
				+ ", idReceptor=" + idReceptor + ", estado=" + estado + "]";
	}
	
}
