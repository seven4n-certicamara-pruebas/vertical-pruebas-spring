package com.certifactura.certicamara.client.test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.certicamara.certifactura.dominio.dtos.acuerdoFacturacion.AcuerdoFacturacionElectronicaXMLDTO;
import com.certicamara.certifactura.infraestructura.excepciones.ExcepcionTecnica;
import com.certicamara.certifactura.infraestructura.utilitarios.GeneradorXsd;
import com.certicamara.certifactura.infraestructura.utilitarios.Utilitario;
import com.google.common.base.Charsets;
import com.google.common.io.Files;

/**
 * CertiFactura
 * Certicámara S.A.
 * Test
 * @author Seven4N Ltda.
 * Jun 19, 2012
 */
public class Test
{

	/**
	 * @param args
	 */
	public static void main( String[ ] args )
	{
//		Date date = new Date();
//		// Some examples
//		Format formatter = new SimpleDateFormat("MM/dd/yy 'Hora' HH:mm:ss ");
//		String fechaAcuerdo = formatter.format(date);
//		System.out.println(fechaAcuerdo);
//
//		URL urlEsquema = Test.class.getResource("/com/certifactura/certicamara/client/test/acuerdoBase.txt");
//
//		try
//		{
//			String textoBasico = Files.toString( new File( urlEsquema.toURI( ) ), Charsets.UTF_8 );
////			textoBasico.replace( ConstantesAcuerdoFacturacion.NOMBRE_ADQUIRIENTE, datosAadquiriente.getNombre( ));
////			textoBasico.replace( ConstantesAcuerdoFacturacion.DOCUMENTO_ADQUIRIENTE, datosAadquiriente.getTipoDocumento( )+" No "+datosAadquiriente.getNumeroIdentificacion( ));
////			textoBasico.replace( ConstantesAcuerdoFacturacion.DIRECCION_ADQUIRENTE, datosAadquiriente.getDireccion( ));
////
////			textoBasico.replace( ConstantesAcuerdoFacturacion.NOMBRE_OBLIGADO_FACTURAR, datosObligadoFacturar.getNombre( ));
////			textoBasico.replace( ConstantesAcuerdoFacturacion.DOCUMENTO_OBLIGADO_FACTURAR, datosObligadoFacturar.getTipoDocumento( )+" No "+datosAadquiriente.getNumeroIdentificacion( ));
////			textoBasico.replace( ConstantesAcuerdoFacturacion.DIRECCION_OBLIGADO_FACTURAR, datosObligadoFacturar.getDireccion( ));
////
////			//TODO PONER EN FORMATO MM/DD/YYY Hora: HH:MM:SS
////			Date date = new Date();
////			// Some examples
////			Format formatter = new SimpleDateFormat("MM/dd/yy 'Hora' HH:mm:ss ");
////			String fechaAcuerdo = formatter.format(date);
//
////			textoBasico.replace( ConstantesAcuerdoFacturacion.FECHA_ACUERDO,fechaAcuerdo );
//
//			System.out.println(textoBasico);
//		}
//		catch ( IOException e )
//		{
//			e.printStackTrace( );
//		}
//		catch ( URISyntaxException e )
//		{
//			e.printStackTrace( );
//		}
		
//		try
//		{
//			GeneradorXsd.generarEsquema( AcuerdoFacturacionElectronicaXMLDTO.class );
//		}
//		catch ( Exception e )
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String contrasena = Long.toHexString(Double.doubleToLongBits(Math.random()));
//		System.out.println(contrasena);
		
		String password = "s4n";
		try
		{
			String hash = Utilitario.calcularSHA256( password );
			System.out.println("hash_"+hash);
		}
		catch ( ExcepcionTecnica e )
		{
			e.printStackTrace();
		}

	}
	//------------------------------
	//        Atributos
	//------------------------------

	//------------------------------
	//        Constructores
	//------------------------------

	//------------------------------
	//          Métodos
	//------------------------------

	//------------------------------
	//       Métodos Privados
	//------------------------------
}





