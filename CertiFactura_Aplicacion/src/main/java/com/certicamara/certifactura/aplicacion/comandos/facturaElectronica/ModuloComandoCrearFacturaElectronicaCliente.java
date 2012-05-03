package com.certicamara.certifactura.aplicacion.comandos.facturaElectronica;

import com.certicamara.certifactura.dominio.conceptos.facturaElectronica.IComandoCrearFacturaElectronica;
import com.certicamara.certifactura.infraestructura.constantes.ConstantesInyeccionCertiFactura;
import com.certicamara.certifactura.infraestructura.excepciones.ExcepcionTecnica;
import com.google.inject.AbstractModule;

/**
 * CertiFactura
 * Certicámara S.A.
 * ModuloCrearFacturaElectronicaCliente
 * @author Seven4N Ltda.
 * Apr 19, 2012
 */
public class ModuloComandoCrearFacturaElectronicaCliente extends AbstractModule
{

	/**
	 * String con el nombre del cliente
	 */
	private String nombreCliente;

	
	/**
	 * Constructor
	 * @param nombreCliente String con el nombre del Cliente
	 * 
	 */
	public ModuloComandoCrearFacturaElectronicaCliente( String nombreCliente )
	{
		this.nombreCliente = nombreCliente;
	}

	@SuppressWarnings ( { "unchecked", "rawtypes" } )
	@Override
	protected void configure( )
	{
		String clase = ConstantesInyeccionCertiFactura.RUTA_CLASSES_COMANDOS_CREAR_FACTURA_ELECTRONICA + nombreCliente;
		try
		{
			bind( IComandoCrearFacturaElectronica.class ).to( ( Class< ? extends IComandoCrearFacturaElectronica> ) Class.forName( clase ) );
		}
		catch ( ClassNotFoundException excepcion )
		{
			throw new ExcepcionTecnica( "En ModuloComandoCrearFacturaElectronicaCliente, realizando el bind de IComandoCrearFacturaElectronica, no se encontró la clase "+clase, excepcion );
		}
	}

}
