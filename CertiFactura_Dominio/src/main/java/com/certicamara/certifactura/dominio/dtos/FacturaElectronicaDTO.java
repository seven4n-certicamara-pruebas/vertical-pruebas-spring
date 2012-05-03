package com.certicamara.certifactura.dominio.dtos;

import java.util.Date;

/**
 * CertiFactura
 * Certicámara S.A.
 * FacturaElectronica
 * @author Seven4N Ltda.
 * Apr 20, 2012
 */
public class FacturaElectronicaDTO
{


	//------------------------------
	//        Atributos
	//------------------------------

	private String consecutivoIdentificador;
	private Date fecha;
	private String identificacionEmisor;
	private String identificacionReceptor;
	//private Collection<Productos> productos;
	private String estado;
	//private Collection<NotaCreditoElectronica> notasDebito;

	//------------------------------
	//        Constructores
	//------------------------------
	/**
	 * Constructor
	 */
	public FacturaElectronicaDTO( )
	{
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor
	 */
	public FacturaElectronicaDTO( String consecutivoIdentificador, Date fecha, String identificacionEmisor, String identificacionReceptor, String estado )
	{
		super( );
		this.consecutivoIdentificador = consecutivoIdentificador;
		this.fecha = fecha;
		this.identificacionEmisor = identificacionEmisor;
		this.identificacionReceptor = identificacionReceptor;
		this.estado = estado;
	}

	//------------------------------
	//          Métodos
	//------------------------------

	/**
	 * @return the consecutivoIdentificador
	 */
	public String getConsecutivoIdentificador( )
	{
		return consecutivoIdentificador;
	}
	/**
	 * @param consecutivoIdentificador the consecutivoIdentificador to set
	 */
	public void setConsecutivoIdentificador( String consecutivoIdentificador )
	{
		this.consecutivoIdentificador = consecutivoIdentificador;
	}
	/**
	 * @return the fecha
	 */
	public Date getFecha( )
	{
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha( Date fecha )
	{
		this.fecha = fecha;
	}
	/**
	 * @return the identificacionEmisor
	 */
	public String getIdentificacionEmisor( )
	{
		return identificacionEmisor;
	}
	/**
	 * @param identificacionEmisor the identificacionEmisor to set
	 */
	public void setIdentificacionEmisor( String identificacionEmisor )
	{
		this.identificacionEmisor = identificacionEmisor;
	}
	/**
	 * @return the identificacionReceptor
	 */
	public String getIdentificacionReceptor( )
	{
		return identificacionReceptor;
	}
	/**
	 * @param identificacionReceptor the identificacionReceptor to set
	 */
	public void setIdentificacionReceptor( String identificacionReceptor )
	{
		this.identificacionReceptor = identificacionReceptor;
	}
	/**
	 * @return the estado
	 */
	public String getEstado( )
	{
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado( String estado )
	{
		this.estado = estado;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString( )
	{
		return "FacturaElectronicaDTO [consecutivoIdentificador=" + consecutivoIdentificador + ", fecha=" + fecha + ", identificacionEmisor=" + identificacionEmisor + ", identificacionReceptor=" + identificacionReceptor + ", estado=" + estado + "]";
	}
	
	
	//------------------------------
	//       Métodos Privados
	//------------------------------
}
