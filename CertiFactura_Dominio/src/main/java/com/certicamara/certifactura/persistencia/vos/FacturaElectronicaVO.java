package com.certicamara.certifactura.persistencia.vos;

public class FacturaElectronicaVO implements IVo<String>
{
	private String id;
	public FacturaElectronicaVO( String id1){
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
