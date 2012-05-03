package com.certicamara.certifactura.dominio.ddd;



/**
 * CertiFactura
 * Certicámara S.A.
 * Factory
 * @author Seven4N Ltda.
 * Apr 20, 2012
 */
public interface IFabricaCanonico<T,DTO>
{
	public T create(DTO dto);
}





