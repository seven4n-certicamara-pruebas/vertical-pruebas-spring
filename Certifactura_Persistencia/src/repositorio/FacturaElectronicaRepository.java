package repositorio;

import mappers.FacturaElectronicaDataMapper;

import com.certicamara.certifactura.dominio.dtos.FacturaElectronicaDTO;
import com.certicamara.certifactura.persitencia.contrato.IRepository;
import com.certicamara.certifactura.persitencia.dboObject.FacturaElectronicaCanonicaDBO;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;


public class FacturaElectronicaRepository implements IRepository< FacturaElectronicaDTO, FacturaElectronicaCanonicaDBO >
{
	String collectionName="FacturaElectronica"; 
	FacturaElectronicaDataMapper facturaElectronicaDataMapper=new FacturaElectronicaDataMapper( );
	
	DB baseDatos;
	
	public void setBaseDatos(DB base){
		baseDatos=base;
	}
	public DBCollection getCollection(String name){
		return baseDatos.getCollection( name );
	}

	@Override
	public void guardar( FacturaElectronicaDTO entidad )
	{
		FacturaElectronicaCanonicaDBO facturaElectronicaCanonicaDBO=new FacturaElectronicaCanonicaDBO( entidad );
		getCollection( collectionName ).insert(facturaElectronicaCanonicaDBO );		
	}

	@Override
	public void actualizar( FacturaElectronicaDTO entidad ) throws Exception
	{
		FacturaElectronicaCanonicaDBO facturaElectronicaCanonicaDBO=new FacturaElectronicaCanonicaDBO( entidad );
		BasicDBObject query = new BasicDBObject();
		query.put("consecutivoIdentificador", entidad.getConsecutivoIdentificador( ));
		DBCursor cur = getCollection( collectionName ).find(query);
		if (cur.hasNext( )){
			getCollection( collectionName ).update(cur.next( ),facturaElectronicaCanonicaDBO );
		}
		else{
			throw new Exception("No se encontro la factura electrónica para actualizar" );
		}		
	}

	@Override
	public FacturaElectronicaDTO buscar( FacturaElectronicaCanonicaDBO llave ) throws Exception
	{			
		FacturaElectronicaCanonicaDBO facturaElectronicaCanonicaDBO;
		BasicDBObject query = new BasicDBObject();
		query.put("consecutivoIdentificador", llave.get( "consecutivoIdentificador" ));
		DBCursor cur = getCollection( collectionName ).find(query);
		if (cur.hasNext( )){
			facturaElectronicaCanonicaDBO=(FacturaElectronicaCanonicaDBO)cur.next( );
		}
		else{
			throw new Exception("No se encontro la factura electrónica" );
		}
		FacturaElectronicaDTO facturaElectronicaDTO=new FacturaElectronicaDTO( );
		facturaElectronicaDTO=facturaElectronicaDataMapper.obtenerFacturaElectronicaDto( facturaElectronicaCanonicaDBO );
		return facturaElectronicaDTO;
	}
	
}
