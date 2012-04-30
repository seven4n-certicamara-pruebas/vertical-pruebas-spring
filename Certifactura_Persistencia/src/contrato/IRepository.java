package contrato;


public interface IRepository<T, Dto> 
{	
	void guardar(T entidad);
	void actualizar(T entidad) throws Exception;
	T buscar(Dto llave) throws Exception;
}

