package com.certicamara.certifactura.dominio.vos;

import com.certicamara.certifactura.infraestructura.enums.EnumNaturalezaPersona;
import com.certicamara.certifactura.infraestructura.enums.EnumTipoDocumentoIdentificacion;

/**
 * CertiFactura
 * Certicámara S.A.
 * ObligadoFacturar
 * @author Seven4N Ltda.
 * May 10, 2012
 */
public class ObligadoFacturar extends PersonaDocumentoCertiFactura
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1417970243622623699L;

	
	//------------------------------
	//        Atributos
	//------------------------------

	//------------------------------
	//        Constructores
	//------------------------------
	
	/**
	 * Constructor
	 */
	public ObligadoFacturar( EnumNaturalezaPersona naturaleza, EnumTipoDocumentoIdentificacion tipoDocumento, String numeroIdentificacion )
	{
		super( naturaleza, tipoDocumento, numeroIdentificacion );
		// TODO Auto-generated constructor stub
	}

	//------------------------------
	//          Métodos
	//------------------------------

	//------------------------------
	//       Métodos Privados
	//------------------------------
}





