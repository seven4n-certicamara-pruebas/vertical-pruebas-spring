package com.certicamara.certifactura.persistencia.vo;

public class FacturaElectronicaVO
{
	private Object id;
	public FacturaElectronicaVO( Object id1){
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
