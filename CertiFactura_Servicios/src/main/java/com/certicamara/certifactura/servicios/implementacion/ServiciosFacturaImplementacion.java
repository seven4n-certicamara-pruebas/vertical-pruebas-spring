package com.certicamara.certifactura.servicios.implementacion;



import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import com.certicamara.certifactura.aplicacion.Comando;
import com.certicamara.certifactura.aplicacion.GestorComandos;
import com.certicamara.certifactura.aplicacion.FacturaElectronica.ComandoCrearFacturaElectronica;
import com.certicamara.certifactura.dominio.dtos.FacturaElectronicaDTO;
import com.certicamara.certifactura.dto.FacturaElectronicaParticularDTO;
import com.certicamara.certifactura.servicios.IServiciosFacturaElectronica;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * CertiFactura
 * Certicámara S.A.
 * ServiciosFacturaImplementacion
 * @author Seven4N Ltda.
 * Apr 27, 2012
 */
@WebService(endpointInterface = "com.certicamara.certifactura.servicios.IServiciosFacturaElectronica")
public class ServiciosFacturaImplementacion implements IServiciosFacturaElectronica
{

	@Autowired
	GestorComandos gestorComandos;
	
	/* (non-Javadoc)
	 * @see com.certicamara.certifactura.servicios.IserviciosFacturaElectronica#crearFacturaElectronica(java.lang.String, com.certicamara.certifactura.dominio.dtos.FacturaElectronicaDTO, java.util.Map)
	 */
	@Override
	public void crearFacturaElectronica( String idEmisor, FacturaElectronicaDTO facturaCanonicaDTO,  FacturaElectronicaParticularDTO facturaParticular)
	{
		try{			
			ObjectMapper mapper = new ObjectMapper();
			String cadenaJsonFacturaCanonica = mapper.writeValueAsString( facturaCanonicaDTO );		
			Comando comando = (Comando)new ComandoCrearFacturaElectronica(cadenaJsonFacturaCanonica, "Exito");			
			gestorComandos.recibirComando(comando);
		}catch( Exception ex ){
			
		}
		
	}

	/* (non-Javadoc)
	 * @see com.certicamara.certifactura.servicios.IserviciosFacturaElectronica#entregarFacturaElectronica(java.lang.String, java.lang.String)
	 */
	@Override
	public void entregarFacturaElectronica( String idEmisor,  String idFactura )
	{
		// TODO Auto-generated method stub
		
	}

}
