package com.certicamara.certifactura.persistencia.clientes.facturaElectronica.vos;

public class FacturaElectronicaCarrefourVO
{
	private Object id;
	public FacturaElectronicaCarrefourVO( Object id1){
		id=id1;
	}
	public Object getId( )
	{
		return id;
	}

	public void setId( Object id )
	{
		this.id = id;
	} 
}
