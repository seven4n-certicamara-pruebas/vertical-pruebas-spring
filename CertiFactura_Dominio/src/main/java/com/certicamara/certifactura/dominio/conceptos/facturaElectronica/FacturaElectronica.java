package com.certicamara.certifactura.dominio.conceptos.facturaElectronica;

import java.lang.reflect.Field;
import java.util.Date;

import co.s4n.osp.exceptions.BusinessException;
import co.s4n.osp.state.EntityState;

import com.certicamara.certifactura.dominio.conceptos.documento.DocumentoCertiFactura;
import com.certicamara.certifactura.dominio.conceptos.facturaElectronica.repositorios.RepositorioFacturaElectronica;
import com.certicamara.certifactura.dominio.dtos.FacturaElectronicaDTO;
import com.certicamara.certifactura.dominio.vos.Adquiriente;
import com.certicamara.certifactura.dominio.vos.ObligadoFacturar;
import com.certicamara.certifactura.infraestructura.excepciones.ExcepcionCertiFactura;

/**
 * CertiFactura
 * Certicámara S.A.
 * FacturaElectronica
 * @author Seven4N Ltda.
 * Apr 20, 2012
 */
public class FacturaElectronica extends DocumentoCertiFactura implements IFacturaElectronica
{


	//------------------------------
	//        Atributos
	//------------------------------
	private String numeroFactura;

	private ObligadoFacturar obligadoAFacturar;
	private Adquiriente adquiriente;

	private String resolucionFacturacion;
	private String rangoNumeracionFacturacion;

	private Date fechaExpedicion;

	private Double totalFactura;
	private Double totalMasIVA;

	private String moneda;

	private String formaPago;

	private String observaciones;


	//private Collection<NotaCreditoElectronica> notasDebito;

	//------------------------------
	//        Constructores
	//------------------------------

	/**
	 * Constructor
	 */
	public FacturaElectronica( String id )
	{
		super( id );
	}


	//------------------------------
	//          Métodos
	//------------------------------


	/* (non-Javadoc)
	 * @see com.certicamara.certifactura.dominio.conceptos.facturaElectronica.IFacturaElectronica#crearFacturaElectronica()
	 */
	@Override
	public void expedirFacturaElectronica( ) throws ExcepcionCertiFactura
	{
		System.out.println("EN FacturaElectronica.crearFacturaElectronica()");
		String prefijoColeccion = this.getAdquiriente( ).getTipoDocumento( )+this.getAdquiriente( ).getNumeroIdentificacion( );
		RepositorioFacturaElectronica repositorioFacturaElectronica = new RepositorioFacturaElectronica( prefijoColeccion );
		repositorioFacturaElectronica.guardar( this.obtenerDTO( ) );

	}

	/* (non-Javadoc)
	 * @see com.certicamara.certifactura.dominio.conceptos.facturaElectronica.IFacturaElectronica#aceptarFacturaElectronica()
	 */
	@Override
	public void aceptarFacturaElectronica( ) throws ExcepcionCertiFactura
	{
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.certicamara.certifactura.dominio.conceptos.facturaElectronica.IFacturaElectronica#entregarFacturaElectronica()
	 */
	@Override
	public void entregarFacturaElectronica( ) throws ExcepcionCertiFactura
	{
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.certicamara.certifactura.dominio.conceptos.facturaElectronica.IFacturaElectronica#rechazarFacturaElectronica()
	 */
	@Override
	public void rechazarFacturaElectronica( ) throws ExcepcionCertiFactura
	{
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.certicamara.certifactura.dominio.conceptos.facturaElectronica.IFacturaElectronica#anularFacturaElectronica()
	 */
	@Override
	public void anularFacturaElectronica( ) throws ExcepcionCertiFactura
	{
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.certicamara.certifactura.dominio.conceptos.facturaElectronica.IFacturaElectronica#agregarNotaDebitoElectronica()
	 */
	@Override
	public void agregarNotaDebitoElectronica( ) throws ExcepcionCertiFactura
	{
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.certicamara.certifactura.dominio.conceptos.facturaElectronica.IFacturaElectronica#entregarNotaDebitoElectronica()
	 */
	@Override
	public void entregarNotaDebitoElectronica( ) throws ExcepcionCertiFactura
	{
		// TODO Auto-generated method stub

	}

	public String getEstado()
	{
		return this.getState( ).getName( );
	}

	/**
	 * @return the numeroFactura
	 */
	public String getNumeroFactura( )
	{
		return numeroFactura;
	}


	/**
	 * @param numeroFactura the numeroFactura to set
	 */
	public void setNumeroFactura( String numeroFactura )
	{
		this.numeroFactura = numeroFactura;
	}


	/**
	 * @return the obligadoAFacturar
	 */
	public ObligadoFacturar getObligadoAFacturar( )
	{
		return obligadoAFacturar;
	}


	/**
	 * @param obligadoAFacturar the obligadoAFacturar to set
	 */
	public void setObligadoAFacturar( ObligadoFacturar obligadoAFacturar )
	{
		this.obligadoAFacturar = obligadoAFacturar;
	}


	/**
	 * @return the adquiriente
	 */
	public Adquiriente getAdquiriente( )
	{
		return adquiriente;
	}


	/**
	 * @param adquiriente the adquiriente to set
	 */
	public void setAdquiriente( Adquiriente adquiriente )
	{
		this.adquiriente = adquiriente;
	}


	/**
	 * @return the resolucionFacturacion
	 */
	public String getResolucionFacturacion( )
	{
		return resolucionFacturacion;
	}


	/**
	 * @param resolucionFacturacion the resolucionFacturacion to set
	 */
	public void setResolucionFacturacion( String resolucionFacturacion )
	{
		this.resolucionFacturacion = resolucionFacturacion;
	}


	/**
	 * @return the rangoNumeracionFacturacion
	 */
	public String getRangoNumeracionFacturacion( )
	{
		return rangoNumeracionFacturacion;
	}


	/**
	 * @param rangoNumeracionFacturacion the rangoNumeracionFacturacion to set
	 */
	public void setRangoNumeracionFacturacion( String rangoNumeracionFacturacion )
	{
		this.rangoNumeracionFacturacion = rangoNumeracionFacturacion;
	}


	/**
	 * @return the fechaExpedicion
	 */
	public Date getFechaExpedicion( )
	{
		return fechaExpedicion;
	}


	/**
	 * @param fechaExpedicion the fechaExpedicion to set
	 */
	public void setFechaExpedicion( Date fechaExpedicion )
	{
		this.fechaExpedicion = fechaExpedicion;
	}


	/**
	 * @return the totalFactura
	 */
	public Double getTotalFactura( )
	{
		return totalFactura;
	}


	/**
	 * @param totalFactura the totalFactura to set
	 */
	public void setTotalFactura( Double totalFactura )
	{
		this.totalFactura = totalFactura;
	}


	/**
	 * @return the totalMasIVA
	 */
	public Double getTotalMasIVA( )
	{
		return totalMasIVA;
	}


	/**
	 * @param totalMasIVA the totalMasIVA to set
	 */
	public void setTotalMasIVA( Double totalMasIVA )
	{
		this.totalMasIVA = totalMasIVA;
	}


	/**
	 * @return the moneda
	 */
	public String getMoneda( )
	{
		return moneda;
	}


	/**
	 * @param moneda the moneda to set
	 */
	public void setMoneda( String moneda )
	{
		this.moneda = moneda;
	}


	/**
	 * @return the formaPago
	 */
	public String getFormaPago( )
	{
		return formaPago;
	}


	/**
	 * @param formaPago the formaPago to set
	 */
	public void setFormaPago( String formaPago )
	{
		this.formaPago = formaPago;
	}


	/**
	 * @return the observaciones
	 */
	public String getObservaciones( )
	{
		return observaciones;
	}


	/**
	 * @param observaciones the observaciones to set
	 */
	public void setObservaciones( String observaciones )
	{
		this.observaciones = observaciones;
	}



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

	public FacturaElectronicaDTO obtenerDTO(){
		//TODO COMPLETAR
		FacturaElectronicaDTO facturaElectronicaDTO = new FacturaElectronicaDTO( );
		
		facturaElectronicaDTO.setId( this.getId( ) );

		return facturaElectronicaDTO;
	}

	/* (non-Javadoc)
	 * @see co.s4n.osp.EntityWithStates#setState(co.s4n.osp.state.EntityState)
	 */
	@Override
	protected void setState( EntityState newState ) throws BusinessException
	{
		// TODO Auto-generated method stub

	}


	//------------------------------
	//       Métodos Privados
	//------------------------------



}
