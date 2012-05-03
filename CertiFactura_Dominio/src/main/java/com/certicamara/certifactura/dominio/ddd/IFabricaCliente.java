package com.certicamara.certifactura.dominio.ddd;

import java.util.HashMap;


/**
 * CertiFactura
 * Certicámara S.A.
 * Factory
 * @author Seven4N Ltda.
 * Apr 20, 2012
 */
public interface IFabricaCliente<T,DTO>
{
	public T create(DTO dto);
	public T create(HashMap< String, Object > mapaCliente);
}





