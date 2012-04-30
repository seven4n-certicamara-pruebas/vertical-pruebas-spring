package repositorio;

import mappers.FacturaElectronicaCarrefourDataMapper;
import mappers.FacturaElectronicaDataMapper;


import com.certicamara.certifactura.dominio.clientes.facturaElectronica.dtos.FacturaElectronicaCarrefourDTO;
import com.certicamara.certifactura.persitencia.contrato.IRepository;
import com.certicamara.certifactura.persitencia.dboObject.FacturaElectronicaCarrefourDBO;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;


public class FacturaElectronicaCarrefourRepository implements IRepository< FacturaElectronicaCarrefourDTO, FacturaElectronicaCarrefourDBO >
{
	String collectionName="FacturaElectronicaCarrefour"; 
	FacturaElectronicaCarrefourDataMapper facturaElectronicaCarrefourDataMapper=new FacturaElectronicaCarrefourDataMapper( );
	
	DB baseDatos;
	
	public void setBaseDatos(DB base){
		baseDatos=base;
	}
	public DBCollection getCollection(String name){
		return baseDatos.getCollection( name );
	}

	@Override
	public void guardar( FacturaElectronicaCarrefourDTO entidad )
	{
		FacturaElectronicaCarrefourDBO facturaElectronicaCarrefourDBO=new FacturaElectronicaCarrefourDBO( entidad );
		getCollection( collectionName ).insert(facturaElectronicaCarrefourDBO );		
	}

	@Override
	public void actualizar( FacturaElectronicaCarrefourDTO entidad ) throws Exception
	{
		FacturaElectronicaCarrefourDBO facturaElectronicaCarrefourDBO=new FacturaElectronicaCarrefourDBO( entidad );
		
		FacturaElectronicaCarrefourDBO  query = new FacturaElectronicaCarrefourDBO();
		query.put("contenedor", entidad.getContenedor( ));
		DBCursor cur = getCollection( collectionName ).find(query);
		if (cur.hasNext( )){
			getCollection( collectionName ).update(cur.next( ),facturaElectronicaCarrefourDBO );
		}
		else{
			throw new Exception("No se encontro la factura electrónica para actualizar" );
		}		
	}
	
	
	public void actualizar( FacturaElectronicaCarrefourDTO vieja, FacturaElectronicaCarrefourDTO nueva) throws Exception
	{		
		FacturaElectronicaCarrefourDBO facturaNueva=new FacturaElectronicaCarrefourDBO( nueva );
		FacturaElectronicaCarrefourDBO query = new FacturaElectronicaCarrefourDBO();
		query.put("contenedor", vieja.getContenedor( ));
		DBCursor cur = getCollection( collectionName ).find(query);
		if (cur.hasNext( )){
			getCollection( collectionName ).update(cur.next( ),facturaNueva );
		}
		else{
			throw new Exception("No se encontro la factura electrónica para actualizar" );
		}		
	}

	@Override
	public FacturaElectronicaCarrefourDTO buscar( FacturaElectronicaCarrefourDBO llave ) throws Exception
	{			
		FacturaElectronicaCarrefourDBO facturaElectronicaCarrefourDBO;
		BasicDBObject query = new BasicDBObject();
		query.put("consecutivoIdentificador", llave.get( "consecutivoIdentificador" ));
		DBCursor cur = getCollection( collectionName ).find(query);
		if (cur.hasNext( )){
			facturaElectronicaCarrefourDBO=(FacturaElectronicaCarrefourDBO)cur.next( );
		}
		else{
			throw new Exception("No se encontro la factura electrónica" );
		}
		FacturaElectronicaCarrefourDTO facturaElectronicaCarrefourDTO=new FacturaElectronicaCarrefourDTO( );
		facturaElectronicaCarrefourDTO=facturaElectronicaCarrefourDataMapper.obtenerFacturaElectronicaCarrefourDto( facturaElectronicaCarrefourDBO );
		return facturaElectronicaCarrefourDTO;
	}
	
}
