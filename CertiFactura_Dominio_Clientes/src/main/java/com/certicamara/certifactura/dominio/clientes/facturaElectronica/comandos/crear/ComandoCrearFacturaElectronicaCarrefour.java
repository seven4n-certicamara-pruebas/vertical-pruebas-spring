package com.certicamara.certifactura.dominio.clientes.facturaElectronica.comandos.crear;

import java.util.HashMap;

import com.certicamara.certifactura.dominio.clientes.facturaElectronica.FacturaElectronicaCarrefour;
import com.certicamara.certifactura.dominio.clientes.facturaElectronica.fabricas.FabricaFacturaElectronicaCarrefour;
import com.certicamara.certifactura.dominio.conceptos.facturaElectronica.FacturaElectronica;
import com.certicamara.certifactura.dominio.conceptos.facturaElectronica.IComandoCrearFacturaElectronica;
import com.certicamara.certifactura.dominio.conceptos.facturaElectronica.fabricas.FabricaFacturaElectronica;
import com.certicamara.certifactura.dominio.dtos.FacturaElectronicaDTO;

/**
 * CertiFactura
 * Certicámara S.A.
 * ComandoCrearFacturaElectronicaCarrefour
 * @author Seven4N Ltda.
 * Apr 27, 2012
 */
public class ComandoCrearFacturaElectronicaCarrefour implements IComandoCrearFacturaElectronica
{

	/* (non-Javadoc)
	 * @see com.certicamara.certifactura.dominio.clientes.facturaElectronica.fachada.IFachadaServiciosFacturaElectronica#crearFacturaElectronica(com.certicamara.certifactura.dominio.dtos.FacturaElectronicaDTO, java.util.HashMap)
	 */
	@Override
	public void crearFacturaElectronica( FacturaElectronicaDTO facturaElectronicaCanonicaDTO, HashMap< String, Object > mapaCliente )
	{
		//Crear factura electronica cliente
		FabricaFacturaElectronicaCarrefour factoryCarrefour = new FabricaFacturaElectronicaCarrefour( );
		FabricaFacturaElectronica factoryCanonica = new FabricaFacturaElectronica( );
		
		//Crear factura electronica canónica
		FacturaElectronica facturaElectronicaCanonica = factoryCanonica.create( facturaElectronicaCanonicaDTO );
		FacturaElectronicaCarrefour facturaElectronicaCliente = factoryCarrefour.create( mapaCliente );
		
		//establecer factura canónica
		facturaElectronicaCliente.setFacturaCanonica( facturaElectronicaCanonica );
		
		//llamar servicio
		facturaElectronicaCliente.crearFacturaElectronica( );
		
	}

	
}





