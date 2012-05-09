package com.certicamara.certifactura.persistencia.clientes.facturaElectronica.vos;

import com.certicamara.certifactura.persistencia.vos.IVo;

public class FacturaElectronicaCarrefourVO implements IVo<String>
{
	private String id;
	public FacturaElectronicaCarrefourVO( String id1){
		id=id1;
	}
	public String getId( )
	{
		return id;
	}

	public void setId( String id )
	{
		this.id = id;
	} 
}
