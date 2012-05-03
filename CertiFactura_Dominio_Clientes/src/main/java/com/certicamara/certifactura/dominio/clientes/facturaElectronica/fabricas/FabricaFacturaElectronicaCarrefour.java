package com.certicamara.certifactura.dominio.clientes.facturaElectronica.fabricas;

import java.util.HashMap;

import com.certicamara.certifactura.dominio.clientes.facturaElectronica.FacturaElectronicaCarrefour;
import com.certicamara.certifactura.dominio.clientes.facturaElectronica.dtos.FacturaElectronicaCarrefourDTO;
import com.certicamara.certifactura.dominio.conceptos.facturaElectronica.FacturaElectronica;
import com.certicamara.certifactura.dominio.conceptos.facturaElectronica.fabricas.FabricaFacturaElectronica;
import com.certicamara.certifactura.dominio.ddd.IFabricaCanonico;
import com.certicamara.certifactura.dominio.ddd.IFabricaCliente;
import com.certicamara.certifactura.dominio.dtos.FacturaElectronicaDTO;
import com.certicamara.certifactura.infraestructura.utilitarios.Utilitario;

/**
 * CertiFactura Certicámara S.A. FacturaElectronicaCarrefourFactory
 * 
 * @author Seven4N Ltda. Apr 24, 2012
 */
public class FabricaFacturaElectronicaCarrefour implements IFabricaCliente< FacturaElectronicaCarrefour, FacturaElectronicaCarrefourDTO >
{

	// ------------------------------
	// Atributos
	// ------------------------------

	// ------------------------------
	// Constructores
	// ------------------------------

	// ------------------------------
	// Métodos
	// ------------------------------

	// ------------------------------
	// Métodos Privados
	// ------------------------------

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.certicamara.certifactura.dominio.ddd.Factory#create(java.lang.Object)
	 */
	@Override
	public FacturaElectronicaCarrefour create( FacturaElectronicaCarrefourDTO dto )
	{
		FacturaElectronicaCarrefour factura = new FacturaElectronicaCarrefour( );
		IFabricaCanonico< FacturaElectronica, FacturaElectronicaDTO > factory = new FabricaFacturaElectronica( );
		FacturaElectronica facturaCanonica = factory.create( dto.getFacturaCanonica( ) );
		factura.setFacturaCanonica( facturaCanonica );
		factura.setContenedor( dto.getContenedor( ) );

		return factura;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.certicamara.certifactura.dominio.ddd.IFactory#create(java.lang.String
	 * )
	 */
	@Override
	public FacturaElectronicaCarrefour create(HashMap< String, Object > mapaCliente )
	{
		FacturaElectronicaCarrefour facturaElectronicaCarrefour = new FacturaElectronicaCarrefour( );
		Utilitario.establecerAtributosPorReflexion( facturaElectronicaCarrefour, mapaCliente );
		return facturaElectronicaCarrefour;
	}

}
