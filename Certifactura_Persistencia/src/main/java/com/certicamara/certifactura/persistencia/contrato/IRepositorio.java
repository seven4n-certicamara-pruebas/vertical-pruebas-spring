package com.certicamara.certifactura.persistencia.contrato;


public interface IRepositorio<T, DBo> 
{	
	void guardar(T entidad);
	void actualizar(T entidad) throws Exception;
	T buscar(DBo llave) throws Exception;
}

