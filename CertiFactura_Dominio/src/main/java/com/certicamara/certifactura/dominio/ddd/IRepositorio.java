package com.certicamara.certifactura.dominio.ddd;

import java.net.UnknownHostException;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.certicamara.certifactura.infraestructura.constantes.ConstantesPersistenciaCertiFactura;
import com.certicamara.certifactura.infraestructura.excepciones.ExcepcionNegocio;
import com.certicamara.certifactura.infraestructura.excepciones.ExcepcionTecnica;
import com.certicamara.certifactura.persistencia.vos.IVo;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;


/**
 * Clase abstracta que implementa la lógica de un repositorio basico, con las operaciones de guardar, actualizar y buscar 
 * @author hansen
 *
 * @param <T> Tipo de Entidad que se va a almacenar
 */
public abstract class IRepositorio<T> 
{
	////////////////////////////////////////////////////
	// Atributos
	////////////////////////////////////////////////////	
	

	private String collectionName;
	private String bdName;
	MongoOperations mongoOperations;
	
	////////////////////////////////////////////////////
	// Métodos
	////////////////////////////////////////////////////
	
	
	/**
	 * @param collectionName Nombre de la colección
	 * @param bdName Nombre de la base de datos
	 */
	
	public IRepositorio( String collectionName, String bdName ) {
		setBdName( bdName );
		setCollectionName( collectionName );	
		iniciarIRepositorio( );
	}
	
	public IRepositorio( String collectionName ) {
		setBdName( ConstantesPersistenciaCertiFactura.NOMBRE_BASE_DATOS_CERTIFACTURA );
		setCollectionName( collectionName );	
		iniciarIRepositorio( );
	}
	
	/**
	 * Método encargado de persistir un elemento
	 * @param entidad que se va a persistir
	 * @param vo con el id del elemento
	 * @param clase La clase del elemento que se va a persistir
	 * @exception ExcepciónNegocio Ya existe un elemento con el mismo id
	 */
	public void guardar( T entidad, IVo vo, Class<T> clase ) throws ExcepcionNegocio {
		T entidadEncontrada = buscar( vo, clase );
		if 	( null == entidadEncontrada ){
			mongoOperations.save( entidad, collectionName );
		}
		else{
			throw new ExcepcionNegocio( " En IRepositorio: Ya existe un elemento con el mismo Id ",new Exception( ) );
		}
			
	}
	
	/**
	 * Método encargado de actualizar un elemento existente
	 * @param elemento Elemento que va a reemplazar el existente
	 * @param vo VO con el id del elemento a actualizar
	 * @param clase La clase del elemento que se va a actualizar
	 * @throws ExcepcionTecnica
	 */
	
	public void actualizar( T elemento, IVo vo, Class<T> clase ) throws ExcepcionTecnica
	{		
		try
		{
			buscar( vo , clase );
			guardar( elemento , vo , clase );
		}
		catch ( ExcepcionTecnica e )
		{
			throw new ExcepcionTecnica( e.getClass( ).getSimpleName( ) + " en RepositorioFacturaElectronicaCarrefour.actualizar: No se encontró la entidad " + e.getMessage( ) ,e );
		}
		
	}
	
	
	/**
	 * @param vo con el id del elemento a buscar
	 * @param clase Clase del elemento que se va a buscar
	 * @return elemento encontrado o null en caso contrario
	 */
	public T buscar( IVo vo , Class<T> clase )
	{		
		T elemento = null;
		elemento =  mongoOperations.findById( vo.getId( ), clase , collectionName );
		return elemento;
	}
	
	/**
	 * Método encargado de inicializar el repositorio y obtener la conexión a la base de datos
	 * @throws ExcepcionTecnica UnknownHostException
	 * @throws ExcepcionTecnica MongoException
	 */
	
	public void iniciarIRepositorio( ) throws ExcepcionTecnica
	{
		try
		{
			MongoTemplate template = new MongoTemplate( new SimpleMongoDbFactory( new Mongo( ), bdName ) );
			template.setWriteConcern( WriteConcern.SAFE );
			mongoOperations = template;
		}
		catch ( UnknownHostException e )
		{
			throw new ExcepcionTecnica( e.getClass( ).getSimpleName( )+" En IRepositorio: " + e.getMessage( ),e );
		}
		catch ( MongoException e )
		{
			throw new ExcepcionTecnica( e.getClass( ).getSimpleName( )+" En IRepositorio: " + e.getMessage( ),e );
		}
		
	}
	
	
	/**
	 * @param collectionName Nombre de la colección
	 */
	private void setCollectionName( String collectionName )
	{
		this.collectionName = collectionName;
	}
	
	
	/**
	 * @param bdName Nombre de la base de datos
	 */
	
	private void setBdName( String bdName )
	{
		this.bdName = bdName;
	}
	
}

