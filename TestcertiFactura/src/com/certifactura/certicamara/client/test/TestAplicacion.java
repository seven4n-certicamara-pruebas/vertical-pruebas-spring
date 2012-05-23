package com.certifactura.certicamara.client.test;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.certicamara.certifactura.aplicacion.GestorComandos;
import com.certicamara.certifactura.aplicacion.comandos.facturaElectronica.ComandoExpedirFacturaElectronicaDTO;
import com.certicamara.certifactura.dominio.conceptos.documento.ImpuestoDeduccionCertiFactura;
import com.certicamara.certifactura.dominio.conceptos.documento.ProductoCertiFactura;
import com.certicamara.certifactura.dominio.dtos.FacturaElectronicaDTO;
import com.certicamara.certifactura.dominio.vos.AdquirienteVO;
import com.certicamara.certifactura.dominio.vos.ObligadoFacturarVO;
import com.certicamara.certifactura.dominio.vos.RangoNumeracionVO;
import com.certicamara.certifactura.dominio.vos.ResolucionFacturacionVO;
import com.certicamara.certifactura.infraestructura.enums.EnumNaturalezaPersona;
import com.certicamara.certifactura.infraestructura.enums.EnumTipoDocumentoIdentificacion;
import com.certicamara.certifactura.infraestructura.excepciones.ExcepcionCertiFactura;
import com.certicamara.certifactura.infraestructura.excepciones.ExcepcionNegocio;
import com.certicamara.certifactura.infraestructura.excepciones.ExcepcionTecnica;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;

/**
 * CertiFactura Certicámara S.A. TestAplicación
 * 
 * @author Seven4N Ltda. Apr 24, 2012
 */
public class TestAplicacion
{

	/**
	 * Constructor
	 */
	public TestAplicacion( )
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main( String[ ] args )
	{
		// TODO Auto-generated method stub
		TestAplicacion test = new TestAplicacion( );
		// test.test( );
		// test.testExcepciones( );
		try
		{
			test.testCrearFacturaElectronica( );
			//test.test222();
		}
		catch ( Exception e )
		{
			e.printStackTrace( );
		}
		// test.testGSon( );
		// System.out.println(test.primeraEnMayuscula( "steven" ));

	}


	
	private void testCrearFacturaElectronica() throws JsonGenerationException, JsonMappingException, IOException{
		FacturaElectronicaDTO facturaCanonicaDTO = new FacturaElectronicaDTO( );

		facturaCanonicaDTO.setNumeroFactura( null);
		facturaCanonicaDTO.setEstado( "Entregada" );
		facturaCanonicaDTO.setFechaExpedicion( new Date( ) );
		facturaCanonicaDTO.setMoneda( "pesos" );
		facturaCanonicaDTO.setFormaPago( "chevere" );
		facturaCanonicaDTO.setObservaciones( "es una factura" );
		facturaCanonicaDTO.setTotalFactura( 100.0 );
		facturaCanonicaDTO.setTotalMasIVA( 105.5 );
		
		AdquirienteVO adquiriente = new AdquirienteVO( );
		adquiriente.setNaturaleza( EnumNaturalezaPersona.NATURAL );
		adquiriente.setNumeroIdentificacion( "80822188" );
		adquiriente.setTipoDocumento(EnumTipoDocumentoIdentificacion.CEDULA_CIUDADANIA);
		
		ObligadoFacturarVO obligado = new ObligadoFacturarVO( );
		obligado.setNaturaleza( EnumNaturalezaPersona.JURIDICA );
		obligado.setNumeroIdentificacion( "800321654-1" );
		obligado.setTipoDocumento(EnumTipoDocumentoIdentificacion.NIT);
		
		facturaCanonicaDTO.setObligadoAFacturar( obligado );
		facturaCanonicaDTO.setAdquiriente( adquiriente );
		
		ResolucionFacturacionVO resolucion = new ResolucionFacturacionVO( );
		resolucion.setFechaExpedicion( new Date( ) );
		resolucion.setIdentificador( "RESOLUCIONXXXXFE");
		resolucion.setPrefijo( "BOG" );
		resolucion.setTipoFacturacion( "FE");
		
		RangoNumeracionVO rango = new RangoNumeracionVO( );
		rango.setRangoFinal( 1000 );
		rango.setRangoInicial( 0);
		
		ProductoCertiFactura producto = new ProductoCertiFactura( );
		producto.setCantidad( 1);
		producto.setDescripcion( "Coca-cola" );
		producto.setIdentificador( "coca1" );
		producto.setImpuestosDeducciones(new LinkedList<ImpuestoDeduccionCertiFactura>());
		producto.setValorUnitario( 2500.0 );
		
		LinkedList<ProductoCertiFactura> productos = new LinkedList< ProductoCertiFactura >( );
		productos.add( producto );
		
		facturaCanonicaDTO.setProductos( productos );
		
		facturaCanonicaDTO.setResolucionFacturacion( resolucion );
		facturaCanonicaDTO.setRangoNumeracionFacturacion( rango );
		
		
		ObjectMapper mapper = new ObjectMapper();
		String cadenaJsonFacturaCanonica = mapper.writeValueAsString( facturaCanonicaDTO );
		
		HashMap< String, Object > mapaFacturaCliente = new HashMap< String, Object >( );
		mapaFacturaCliente.put( "contenedor", "Contenedor192932" );
		String cadenaJsonFacturaCliente = mapper.writeValueAsString( mapaFacturaCliente );
		
		ComandoExpedirFacturaElectronicaDTO comandoCrear = new ComandoExpedirFacturaElectronicaDTO( cadenaJsonFacturaCanonica, cadenaJsonFacturaCliente,"Carrefour" );

		ApplicationContext ctx = new ClassPathXmlApplicationContext( "com/certicamara/certifactura/aplicacion/aplication-context.xml" );
		GestorComandos gestorComandos = ( GestorComandos ) ctx.getBean( "gestorComandos" );

		// GestorComandos gestor = new GestorComandos( );
		try
		{
			gestorComandos.recibirComando( comandoCrear );
		}
		
		catch ( ExcepcionCertiFactura e )
		{
			if( e instanceof ExcepcionTecnica)
			{
				System.err.println( "================= Excepción Técnica =================" );
				// TODO Auto-generated catch block
				e.printStackTrace( );
			}
			if( e instanceof ExcepcionNegocio)
			{
				System.err.println( "================= Excepción Negocio =================" );
				// TODO Auto-generated catch block
				e.printStackTrace( );
			}
		}
	}
}
