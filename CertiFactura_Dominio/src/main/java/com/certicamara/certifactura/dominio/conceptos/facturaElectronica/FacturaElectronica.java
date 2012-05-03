package com.certicamara.certifactura.dominio.conceptos.facturaElectronica;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * CertiFactura
 * Certicámara S.A.
 * FacturaElectronica
 * @author Seven4N Ltda.
 * Apr 20, 2012
 */
public class FacturaElectronica implements IFacturaElectronica
{


	//------------------------------
	//        Atributos
	//------------------------------

	private String consecutivoIdentificador;
	private Date fecha;
	private String identificacionEmisor;
	private String identificacionReceptor;
	private String estado;
	//private Collection<Productos> productos;
	
	//private Collection<NotaCreditoElectronica> notasDebito;

	//------------------------------
	//        Constructores
	//------------------------------
	/**
	 * Constructor
	 */
	public FacturaElectronica( )
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor
	 */
	public FacturaElectronica( String consecutivoIdentificador, Date fecha, String identificacionEmisor, String identificacionReceptor, String estado )
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
	 * @see com.certicamara.certifactura.dominio.conceptos.facturaElectronica.IFacturaElectronica#crearFacturaElectronica()
	 */
	@Override
	public void crearFacturaElectronica( )
	{
		System.out.println("crearFacturaElectronica en FacturaElectronica");
		
		System.out.println(this.toString( ));
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.certicamara.certifactura.dominio.conceptos.facturaElectronica.IFacturaElectronica#entregarFacturaElectronica()
	 */
	@Override
	public void entregarFacturaElectronica( )
	{
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.certicamara.certifactura.dominio.conceptos.facturaElectronica.IFacturaElectronica#aceptarFacturaElectronica()
	 */
	@Override
	public void aceptarFacturaElectronica( )
	{
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.certicamara.certifactura.dominio.conceptos.facturaElectronica.IFacturaElectronica#agregarNotaDebitoElectronica()
	 */
	@Override
	public void agregarNotaDebitoElectronica( )
	{
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.certicamara.certifactura.dominio.conceptos.facturaElectronica.IFacturaElectronica#entregarNotaDebitoElectronica()
	 */
	@Override
	public void entregarNotaDebitoElectronica( )
	{
		// TODO Auto-generated method stub

	}
	

	//------------------------------
	//       Métodos Privados
	//------------------------------
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString( )
	{
		Field[ ] declaredFields = super.getClass( ).getDeclaredFields( );
		for ( Field field : declaredFields )
		{
			try
			{
				System.out.println("Att: "+field.getName( )+"="+field.get(this));
			}
			catch ( IllegalArgumentException e )
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch ( IllegalAccessException e )
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		// TODO Auto-generated method stub
		return super.toString( );
	}
}
