package com.certicamara.certifactura.dominio.clientes.facturaElectronica.repositorios;



import com.certicamara.certifactura.dominio.clientes.facturaElectronica.dtos.FacturaElectronicaCarrefourDTO;
import com.certicamara.certifactura.dominio.ddd.IRepositorio;
import com.certicamara.certifactura.infraestructura.excepciones.ExcepcionNegocio;
import com.certicamara.certifactura.infraestructura.excepciones.ExcepcionTecnica;
import com.certicamara.certifactura.persistencia.clientes.facturaElectronica.vos.FacturaElectronicaCarrefourVO;
import com.certicamara.certifactura.persistencia.vos.IVo;


/**
 * Clase encargada de Manejar un repositorio de facturas electronicas de carrefour
 * @author hansen 
 */
public class RepositorioFacturaElectronicaCarrefour extends IRepositorio< FacturaElectronicaCarrefourDTO >
{
	
	/**
	 * Constructor encargado de inicializar un repositorio
	 * @param collectionName Nombre de la colección donde se va almacenar las facturas
	 * @param bdName Nombre de la base de datos 
	 */
	
	public RepositorioFacturaElectronicaCarrefour( String collectionName, String bdName ){
		super( collectionName, bdName );
	}
	
	/**
	 * Constructor encargado de inicializar un repositorio
	 * @param collectionName Nombre de la colección donde se va almacenar las facturas
	 * @param bdName Nombre de la base de datos 
	 */
	
	public RepositorioFacturaElectronicaCarrefour( String collectionName ){
		super( collectionName );
	}
	
	/**
	 * Método encargado de guardar una fáctura
	 * @param facturaElectronicaCarrefourDTO Factura electrónica carrefour 
	 */
	
	public void guardar(FacturaElectronicaCarrefourDTO facturaElectronicaCarrefourDTO){
		guardar(facturaElectronicaCarrefourDTO , new FacturaElectronicaCarrefourVO( facturaElectronicaCarrefourDTO.getId( ) ),FacturaElectronicaCarrefourDTO.class );
	}
	
	/**
	 * Método encargado de actualizar una fáctura
	 * @param facturaElectronicaCarrefourDTO Factura electrónica carrefour
	 */
	
	public void actualizar(FacturaElectronicaCarrefourDTO facturaElectronicaCarrefourDTO){	
		actualizar( facturaElectronicaCarrefourDTO, new FacturaElectronicaCarrefourVO(facturaElectronicaCarrefourDTO.getId( )),FacturaElectronicaCarrefourDTO.class);
	}
	
	/* (non-Javadoc)
	 * @see com.certicamara.certifactura.dominio.ddd.IRepositorio#buscar(com.certicamara.certifactura.persistencia.vos.IVo, java.lang.Class)
	 */
	
	@Override
	public FacturaElectronicaCarrefourDTO buscar( IVo vo, Class< FacturaElectronicaCarrefourDTO > c ) 
	{
		try {
			FacturaElectronicaCarrefourDTO facturaElectronicaCarrefourDTO = super.buscar( vo, c );
			if (null == facturaElectronicaCarrefourDTO )
				throw new ExcepcionNegocio(" en RepositorioFacturaElectronicaCarrefour.buscar No se encontro la factura buscada " , new Exception( ));
			else
				return facturaElectronicaCarrefourDTO;
		}
		catch(RuntimeException e){
			throw new ExcepcionTecnica( e.getClass( ).getSimpleName( )+" en RepositorioFacturaElectronicaCarrefour.buscar "+e.getMessage( ), e);
		}
		
	}
	

}
