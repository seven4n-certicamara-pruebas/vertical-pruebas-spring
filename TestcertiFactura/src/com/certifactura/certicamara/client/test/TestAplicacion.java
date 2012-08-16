package com.certifactura.certicamara.client.test;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.certicamara.certifactura.aplicacion.GestorComandos;
import com.certicamara.certifactura.aplicacion.comandos.facturaElectronica.ComandoExpedirFacturaElectronicaDTO;
import com.certicamara.certifactura.aplicacion.generador.GeneradorFuncionalidades;
import com.certicamara.certifactura.dominio.conceptos.documento.ProductoCertiFactura;
import com.certicamara.certifactura.dominio.dtos.FacturaElectronicaDTO;
import com.certicamara.certifactura.dominio.dtos.numeracion.RangoNumeracionDTO;
import com.certicamara.certifactura.dominio.dtos.numeracion.ResolucionFacturacionDTO;
import com.certicamara.certifactura.dominio.dtos.persona.AdquirienteDTO;
import com.certicamara.certifactura.dominio.dtos.persona.ObligadoFacturarDTO;
import com.certicamara.certifactura.infraestructura.enums.EnumNaturalezaPersona;
import com.certicamara.certifactura.infraestructura.enums.EnumTipoDocumentoIdentificacion;
import com.certicamara.certifactura.infraestructura.excepciones.ExcepcionCertiFactura;
import com.certicamara.certifactura.infraestructura.excepciones.ExcepcionNegocio;
import com.certicamara.certifactura.infraestructura.excepciones.ExcepcionTecnica;
import com.certicamara.certifactura.test.dominio.conceptos.CreadorRolesFuncionalidades;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
			test.crearFuncionalidades( );
			//test.test222();
		}
		catch ( Exception e )
		{
			e.printStackTrace( );
		}
		// test.testGSon( );
		// System.out.println(test.primeraEnMayuscula( "steven" ));

	}


	
//	private void testCrearFacturaElectronica() throws JsonGenerationException, JsonMappingException, IOException{
//		FacturaElectronicaDTO facturaCanonicaDTO = new FacturaElectronicaDTO( );
//
//		facturaCanonicaDTO.setNumeroFactura( null );
//		facturaCanonicaDTO.setEstado( "Iniciada" );
//		facturaCanonicaDTO.setFechaExpedicion( new Date( ) );
//		facturaCanonicaDTO.setMoneda( "Pesos" );
//		facturaCanonicaDTO.setFormaPago( "Efectivo" );
//		facturaCanonicaDTO.setObservaciones( "Factura Prueba Marcial" );
//		facturaCanonicaDTO.setTotalFactura( 100.0 );
//		facturaCanonicaDTO.setTotalMasIVA( 105.5 );
//		
//		AdquirienteDTO adquiriente = new AdquirienteDTO( );
//		adquiriente.setNaturaleza( EnumNaturalezaPersona.NATURAL );
//		adquiriente.setNumeroIdentificacion( "80822188" );
//		adquiriente.setTipoDocumento(EnumTipoDocumentoIdentificacion.CEDULA_CIUDADANIA);
//		
//		ObligadoFacturarDTO obligado = new ObligadoFacturarDTO( );
//		obligado.setNaturaleza( EnumNaturalezaPersona.JURIDICA );
//		obligado.setNumeroIdentificacion( "123456789" );
//		obligado.setTipoDocumento(EnumTipoDocumentoIdentificacion.NIT);
//		
//		facturaCanonicaDTO.setObligadoAFacturar( obligado );
//		facturaCanonicaDTO.setAdquiriente( adquiriente );
//		
//		ResolucionFacturacionDTO resolucion = new ResolucionFacturacionDTO( );
//		resolucion.setFechaExpedicion( new Date( ) );
//		resolucion.setIdentificador( "RESOLUCIONXXXX");
//		resolucion.setPrefijo( "BOG" );
//		resolucion.setTipoFacturacion( "FE");
//		
//		RangoNumeracionDTO rango = new RangoNumeracionDTO( );
//		rango.setRangoFinal( 1000 );
//		rango.setRangoInicial( 0);
//		
//		ProductoCertiFactura producto = new ProductoCertiFactura( );
//		producto.setCantidad( 1);
//		producto.setDescripcion( "Coca-cola" );
//		producto.setIdentificador( "coca1" );
//		//producto.setImpuestosDeducciones(new LinkedList<ImpuestoDeduccionCertiFactura>());
//		producto.setValorUnitario( 2500.0 );
//		
//		LinkedList<ProductoCertiFactura> productos = new LinkedList< ProductoCertiFactura >( );
//		productos.add( producto );
//		
//		facturaCanonicaDTO.setProductos( productos );
//		
//		facturaCanonicaDTO.setResolucionFacturacion( resolucion );
//		facturaCanonicaDTO.setRangoNumeracionFacturacion( rango );
//		
//		
//		ObjectMapper mapper = new ObjectMapper();
//		String cadenaJsonFacturaCanonica = mapper.writeValueAsString( facturaCanonicaDTO );
//		
//		HashMap< String, Object > mapaFacturaCliente = new HashMap< String, Object >( );
//		mapaFacturaCliente.put( "contenedor", "Contenedor192932" );
//		String cadenaJsonFacturaCliente = mapper.writeValueAsString( mapaFacturaCliente );
//		
//		ComandoExpedirFacturaElectronicaDTO comandoCrear = new ComandoExpedirFacturaElectronicaDTO( cadenaJsonFacturaCanonica, cadenaJsonFacturaCliente,"Carrefour" );
//
//		ApplicationContext ctx = new ClassPathXmlApplicationContext( "com/certicamara/certifactura/aplicacion/aplication-context.xml" );
//		GestorComandos gestorComandos = ( GestorComandos ) ctx.getBean( "gestorComandos" );
//
//		// GestorComandos gestor = new GestorComandos( );
//		try
//		{
//			gestorComandos.recibirComando( comandoCrear );
//		}
//		
//		catch ( ExcepcionCertiFactura e )
//		{
//			if( e instanceof ExcepcionTecnica)
//			{
//				System.err.println( "================= Excepción Técnica =================" );
//				// TODO Auto-generated catch block
//				e.printStackTrace( );
//			}
//			if( e instanceof ExcepcionNegocio)
//			{
//				System.err.println( "================= Excepción Negocio =================" );
//				// TODO Auto-generated catch block
//				e.printStackTrace( );
//			}
//		}
//	}
	
	public void crearFuncionalidades()
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext( "com/certicamara/certifactura/aplicacion/aplication-context.xml" );
		GeneradorFuncionalidades generador = ( GeneradorFuncionalidades ) ctx.getBean( "generadorFuncionalidades" );

		// GestorComandos gestor = new GestorComandos( );
			generador.ejecutar( );

	}
}
