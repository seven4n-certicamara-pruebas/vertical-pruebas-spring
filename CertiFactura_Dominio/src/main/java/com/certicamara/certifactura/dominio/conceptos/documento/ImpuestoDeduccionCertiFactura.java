package com.certicamara.certifactura.dominio.conceptos.documento;

/**
 * CertiFactura
 * Certicámara S.A.
 * ImpuestoDeduccionCertiFactura
 * @author Seven4N Ltda.
 * Apr 20, 2012
 */
public class ImpuestoDeduccionCertiFactura
{
	//------------------------------
	//        Atributos
	//------------------------------
	private String descripcion;
	private Double valorPorcentaje;
	private String tipo;
	

	//------------------------------
	//        Constructores
	//------------------------------
	/**
	 * Constructor
	 */
	public ImpuestoDeduccionCertiFactura( )
	{
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor
	 */
	public ImpuestoDeduccionCertiFactura( String descripcion, Double valorPorcentaje, String tipo )
	{
		super( );
		this.descripcion = descripcion;
		this.valorPorcentaje = valorPorcentaje;
		this.tipo = tipo;
	}

	//------------------------------
	//          Métodos
	//------------------------------
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
	 * @return the valorPorcentaje
	 */
	public Double getValorPorcentaje( )
	{
		return valorPorcentaje;
	}
	/**
	 * @param valorPorcentaje the valorPorcentaje to set
	 */
	public void setValorPorcentaje( Double valorPorcentaje )
	{
		this.valorPorcentaje = valorPorcentaje;
	}
	/**
	 * @return the tipo
	 */
	public String getTipo( )
	{
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo( String tipo )
	{
		this.tipo = tipo;
	}





	//------------------------------
	//       Métodos Privados
	//------------------------------
}





