package com.certicamara.certifactura.dominio.ddd;


public interface IRepositorio<T, VO> 
{	
	void guardar(T entidad);
	void actualizar(T entidad) throws Exception;
	T buscar(VO llave) throws Exception;
}

