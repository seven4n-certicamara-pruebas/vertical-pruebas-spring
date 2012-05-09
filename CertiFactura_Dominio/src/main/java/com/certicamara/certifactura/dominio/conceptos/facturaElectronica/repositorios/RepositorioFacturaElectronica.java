package com.certicamara.certifactura.dominio.conceptos.facturaElectronica.repositorios;


import com.certicamara.certifactura.dominio.ddd.IRepositorio;
import com.certicamara.certifactura.dominio.dtos.FacturaElectronicaDTO;
import com.certicamara.certifactura.infraestructura.excepciones.ExcepcionNegocio;
import com.certicamara.certifactura.infraestructura.excepciones.ExcepcionTecnica;
import com.certicamara.certifactura.persistencia.vos.FacturaElectronicaVO;
import com.certicamara.certifactura.persistencia.vos.IVo;


public class RepositorioFacturaElectronica extends IRepositorio< FacturaElectronicaDTO >
{		
	/**
	 * Constructor encargado de inicializar un repositorio
	 * @param collectionName Nombre de la colección donde se va almacenar las facturas
	 * @param bdName Nombre de la base de datos 
	 */
	
	public RepositorioFacturaElectronica( String collectionName, String bdName )
	{
		super( collectionName, bdName );		
	}
	
	/**
	 * Método encargado de guardar una fáctura
	 * @param facturaElectronicaCarrefourDTO Factura electrónica carrefour 
	 */	
	
	public void guardar(FacturaElectronicaDTO facturaElectronicaDTO){
		guardar( facturaElectronicaDTO, new FacturaElectronicaVO( facturaElectronicaDTO.getId( ) ), FacturaElectronicaDTO.class );
	}
	
	/**
	 * Método encargado de actualizar una fáctura
	 * @param facturaElectronicaCarrefourDTO Factura electrónica carrefour
	 */
	
	public void actualizar( FacturaElectronicaDTO facturaElectronicaDTO ){
		actualizar( facturaElectronicaDTO, new FacturaElectronicaVO( facturaElectronicaDTO.getId( ) ), FacturaElectronicaDTO.class );
	}
	
	@Override
	public FacturaElectronicaDTO buscar( IVo vo, Class< FacturaElectronicaDTO > c ) 
	{
		try {
			FacturaElectronicaDTO facturaElectronicaDTO = super.buscar( vo, c );
			if (null == facturaElectronicaDTO )
				throw new ExcepcionNegocio(" en RepositorioFacturaElectronica.buscar No se encontro la factura buscada " , new Exception( ));
			else
				return facturaElectronicaDTO;
		}
		catch(RuntimeException e){
			throw new ExcepcionTecnica( e.getClass( ).getSimpleName( )+" en RepositorioFacturaElectronica.buscar "+e.getMessage( ), e);
		}
		
	}

	
}
