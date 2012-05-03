package com.certicamara.certifactura.dominio.conceptos.documento;

import java.util.Collection;

/**
 * CertiFactura
 * Certicámara S.A.
 * ProductoCertiFactura
 * @author Seven4N Ltda.
 * Apr 20, 2012
 */
public class ProductoCertiFactura
{
	//------------------------------
	//        Atributos
	//------------------------------
	private String identificador;
	private String descripcion;
	private Double valorUnitario;
	private int cantidad;
	private Collection< ImpuestoDeduccionCertiFactura > impuestosDeducciones;
	
	

	//------------------------------
	//        Constructores
	//------------------------------
	/**
	 * Constructor
	 */
	public ProductoCertiFactura( String identificador, String descripcion, Double valorUnitario, int cantidad )
	{
		super( );
		this.identificador = identificador;
		this.descripcion = descripcion;
		this.valorUnitario = valorUnitario;
		this.cantidad = cantidad;
	}
	
	/**
	 * Constructor
	 */
	public ProductoCertiFactura( )
	{
		// TODO Auto-generated constructor stub
	}
	

	//------------------------------
	//          Métodos
	//------------------------------
	/**
	 * @return the identificador
	 */
	public String getIdentificador( )
	{
		return identificador;
	}
	/**
	 * @param identificador the identificador to set
	 */
	public void setIdentificador( String identificador )
	{
		this.identificador = identificador;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion( )
	{
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion( String descripcion )
	{
		this.descripcion = descripcion;
	}
	/**
	 * @return the valorUnitario
	 */
	public Double getValorUnitario( )
	{
		return valorUnitario;
	}
	/**
	 * @param valorUnitario the valorUnitario to set
	 */
	public void setValorUnitario( Double valorUnitario )
	{
		this.valorUnitario = valorUnitario;
	}
	/**
	 * @return the cantidad
	 */
	public int getCantidad( )
	{
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad( int cantidad )
	{
		this.cantidad = cantidad;
	}

	
	public Collection< ImpuestoDeduccionCertiFactura > getImpuestosDeducciones( )
	{
		return impuestosDeducciones;
	}

	public void setImpuestosDeducciones( Collection< ImpuestoDeduccionCertiFactura > impuestosDeducciones )
	{
		this.impuestosDeducciones = impuestosDeducciones;
	}
	
	
	//------------------------------
	//       Métodos Privados
	//------------------------------
}





