package com.certicamara.certifactura.aplicacion.FacturaElectronica;

import com.certicamara.certifactura.aplicacion.FacturaElectronica.dto.FacturaElectronica;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

/**
 * CertiFactura
 * Certicámara S.A.
 * GeneradorFacturaElectronicaExito
 * @author Seven4N Ltda.
 * Apr 19, 2012
 */
public class GeneradorFacturaElectronicaExito implements GeneradorFacturaElectronica
{

	@Override
	public void crearFacturaElectronica( String cadenaJson )
	{
		
		XStream xstream = new XStream( new JettisonMappedXmlDriver( ) );
		xstream.alias( "FacturaElectronica", FacturaElectronica.class );
		FacturaElectronica factura = ( FacturaElectronica ) xstream.fromXML( cadenaJson );
		System.out.println( "Se genero la factura" );
		System.out.println( factura );

	}

}
