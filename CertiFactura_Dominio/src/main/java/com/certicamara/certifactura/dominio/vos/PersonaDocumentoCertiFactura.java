package com.certicamara.certifactura.dominio.vos;

import com.certicamara.certifactura.infraestructura.dto.DataTransferObject;
import com.certicamara.certifactura.infraestructura.enums.EnumNaturalezaPersona;
import com.certicamara.certifactura.infraestructura.enums.EnumTipoDocumentoIdentificacion;

/**
 * CertiFactura
 * Certicámara S.A.
 * PersonaDocumentoCertiFactura
 * @author Seven4N Ltda.
 * May 10, 2012
 */
public class PersonaDocumentoCertiFactura implements DataTransferObject
{
	//------------------------------
	//        Atributos
	//------------------------------
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8641817221295039095L;
	private EnumNaturalezaPersona naturaleza;
	private EnumTipoDocumentoIdentificacion tipoDocumento;
	private String numeroIdentificacion;
	
	
	
	//------------------------------
	//        Constructores
	//------------------------------
	
	/**
	 * Constructor
	 */
	public PersonaDocumentoCertiFactura( EnumNaturalezaPersona naturaleza, EnumTipoDocumentoIdentificacion tipoDocumento, String numeroIdentificacion )
	{
		super( );
		this.naturaleza = naturaleza;
		this.tipoDocumento = tipoDocumento;
		this.numeroIdentificacion = numeroIdentificacion;
	}

	//------------------------------
	//          Métodos
	//------------------------------
	
	/**
	 * @return the naturaleza
	 */
	public EnumNaturalezaPersona getNaturaleza( )
	{
		return naturaleza;
	}
	/**
	 * @param naturaleza the naturaleza to set
	 */
	public void setNaturaleza( EnumNaturalezaPersona naturaleza )
	{
		this.naturaleza = naturaleza;
	}
	/**
	 * @return the tipoDocumento
	 */
	public EnumTipoDocumentoIdentificacion getTipoDocumento( )
	{
		return tipoDocumento;
	}
	/**
	 * @param tipoDocumento the tipoDocumento to set
	 */
	public void setTipoDocumento( EnumTipoDocumentoIdentificacion tipoDocumento )
	{
		this.tipoDocumento = tipoDocumento;
	}
	/**
	 * @return the numeroIdentificacion
	 */
	public String getNumeroIdentificacion( )
	{
		return numeroIdentificacion;
	}
	/**
	 * @param numeroIdentificacion the numeroIdentificacion to set
	 */
	public void setNumeroIdentificacion( String numeroIdentificacion )
	{
		this.numeroIdentificacion = numeroIdentificacion;
	}


	//------------------------------
	//       Métodos Privados
	//------------------------------
}





