package dboObject;

import java.util.Date;

import com.mongodb.BasicDBObject;

/**
 * CertiFactura
 * Certicámara S.A.
 * FacturaElectronicaDominio
 * @author Seven4N Ltda.
 * Apr 23, 2012
 */
public class FacturaElectronicaCanonicaDBO extends BasicDBObject {
	
		

	private Integer idConsecutivo;
	
	private Date fecha;
	
	private Integer idEmisor;
	
	private Integer idReceptor;
	
	private String estado;	
	
//	private List<ProductoDominio> productos;
	

	public Integer getIdConsecutivo( )
	{
		return idConsecutivo;
	}

	public void setIdConsecutivo( Integer idConsecutivo )
	{
		this.idConsecutivo = idConsecutivo;
	}

	public Date getFecha( )
	{
		return fecha;
	}

	public void setFecha( Date fecha )
	{
		this.fecha = fecha;
	}

	public Integer getIdEmisor( )
	{
		return idEmisor;
	}

	public void setIdEmisor( Integer idEmisor )
	{
		this.idEmisor = idEmisor;
	}

	public Integer getIdReceptor( )
	{
		return idReceptor;
	}

	public void setIdReceptor( Integer idReceptor )
	{
		this.idReceptor = idReceptor;
	}

	public String getEstado( )
	{
		return estado;
	}

	public void setEstado( String estado )
	{
		this.estado = estado;
	}

}
