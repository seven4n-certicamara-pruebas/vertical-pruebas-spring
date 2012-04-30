package contrato;

public interface IRepository<T, Dto> extends Repository<T, Dto>
{
	boolean save(T entity);
}
