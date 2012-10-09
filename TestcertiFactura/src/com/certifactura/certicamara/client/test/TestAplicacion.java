package com.certifactura.certicamara.client.test;

import com.certicamara.certifactura.batch.dominio.facturaComputador.MasivoFacturaComputador;
import com.certicamara.certifactura.batch.dominio.facturaElectronica.MasivoFacturaElectronica;
import com.certicamara.certifactura.infraestructura.utilitarios.GeneradorXsd;

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
	public static void main2( String[ ] args )
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
//		ApplicationContext ctx = new ClassPathXmlApplicationContext( "com/certicamara/certifactura/aplicacion/aplication-context.xml" );
//		GeneradorFuncionalidades generador = ( GeneradorFuncionalidades ) ctx.getBean( "generadorFuncionalidades" );
//
//		// GestorComandos gestor = new GestorComandos( );
//			generador.ejecutar( );

	}
	
	public static void main( String[ ] args )
	{
		try
		{
			GeneradorXsd.generarEsquema( MasivoFacturaComputador.class );
			//GeneradorXsd.generarEsquema( FacturaElectronicaTest.class);
		}
		catch ( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
