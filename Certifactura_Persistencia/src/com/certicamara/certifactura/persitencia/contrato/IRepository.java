package contrato;


public interface IRepository<T, DBo> 
{	
	void guardar(T entidad);
	void actualizar(T entidad) throws Exception;
	T buscar(DBo llave) throws Exception;
}

