package com.certicamara.certifactura.dominio.conceptos.facturaElectronica.fabricas;

import com.certicamara.certifactura.dominio.conceptos.facturaElectronica.FacturaElectronica;
import com.certicamara.certifactura.dominio.ddd.IFabricaCanonico;
import com.certicamara.certifactura.dominio.dtos.FacturaElectronicaDTO;

/**
 * CertiFactura
 * Certicámara S.A.
 * FacturaElectronicaFactory
 * @author Seven4N Ltda.
 * Apr 24, 2012
 */
public class FabricaFacturaElectronica implements IFabricaCanonico< FacturaElectronica, FacturaElectronicaDTO>
{


	//------------------------------
	//        Atributos
	//------------------------------

	//------------------------------
	//        Constructores
	//------------------------------

	//------------------------------
	//          Métodos
	//------------------------------

	/* (non-Javadoc)
	 * @see com.certicamara.certifactura.dominio.ddd.Factory#create(java.lang.Object)
	 */
	@Override
	public FacturaElectronica create( FacturaElectronicaDTO dto )
	{
		//TODO OJO MIRAR QUE ID SE LE DA
		FacturaElectronica factura = new FacturaElectronica(dto.getId( ) );

		return factura;
	}

	//------------------------------
	//       Métodos Privados
	//------------------------------
}





