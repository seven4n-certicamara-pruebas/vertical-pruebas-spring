package com.certicamara.certifactura.dominio.ddd;

/**
 * CertiFactura
 * Certicámara S.A.
 * Entity
 * @author Seven4N Ltda.
 * Apr 20, 2012
 */
public abstract class Entity {
	
	private String id;

	public String getId( )
	{
		return id;
	}

	public void setId( String id )
	{
		this.id = id;
	}
	
	abstract public boolean isSameEntityAs(Entity Entity);

}
