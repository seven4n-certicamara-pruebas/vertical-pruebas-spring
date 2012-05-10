package com.certicamara.certifactura.servicios.implementacion;



import java.rmi.RemoteException;
import java.util.HashMap;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.certicamara.certifactura.aplicacion.GestorComandos;
import com.certicamara.certifactura.aplicacion.comandos.IComandoDTO;
import com.certicamara.certifactura.aplicacion.comandos.facturaElectronica.ComandoCrearFacturaElectronicaDTO;
import com.certicamara.certifactura.dominio.dtos.FacturaElectronicaDTO;
import com.certicamara.certifactura.servicios.IServiciosFacturaElectronica;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * CertiFactura
 * Certicámara S.A.
 * ServiciosFacturaImplementacion
 * @author Seven4N Ltda.
 * Apr 27, 2012
 */
@WebService(endpointInterface = "com.certicamara.certifactura.servicios.IServiciosFacturaElectronica", targetNamespace = "http://www.certicamara.com/certifactura/ws")
public class ServiciosFacturaImplementacion implements IServiciosFacturaElectronica
{

	@Autowired
	GestorComandos gestorComandos;	


	/* (non-Javadoc)
	 * @see com.certicamara.certifactura.servicios.IserviciosFacturaElectronica#entregarFacturaElectronica(java.lang.String, java.lang.String)
	 */
	@Override
	public void entregarFacturaElectronica( String idEmisor,  String idFactura )
	{
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.certicamara.certifactura.servicios.IServiciosFacturaElectronica#crearFacturaElectronica(java.lang.String, com.certicamara.certifactura.servicios.FacturaElectronicaDTO, java.lang.Object)
	 */
	@Override
	public void crearFacturaElectronica( String idEmisor, FacturaElectronicaDTO facturaElectronicaCanonica, Object camposAdicionales ) throws RemoteException
	{
		try{			
			ObjectMapper mapper = new ObjectMapper();
			HashMap< String, Object > mapaFacturaCliente = new HashMap< String, Object >( );
            mapaFacturaCliente.put( "contenedor", "Contenedor192932" );
            String cadenaJsonFacturaCliente = mapper.writeValueAsString( mapaFacturaCliente );			
			String cadenaJsonFacturaCanonica = mapper.writeValueAsString( facturaElectronicaCanonica );
			IComandoDTO comando = new ComandoCrearFacturaElectronicaDTO(cadenaJsonFacturaCanonica, cadenaJsonFacturaCliente, "Carrefour" );
			//gestorComandos.recibirComando(comando);
		}catch( Exception ex ){
			ex.printStackTrace( );
		}
		
	}


}
