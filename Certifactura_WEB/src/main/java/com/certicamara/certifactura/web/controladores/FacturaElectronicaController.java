package com.certicamara.certifactura.web.controladores;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.certicamara.certifactura.aplicacion.Comando;
import com.certicamara.certifactura.aplicacion.GestorComandos;
import com.certicamara.certifactura.aplicacion.FacturaElectronica.ComandoCrearFacturaElectronica;
import com.certicamara.certifactura.dominio.dtos.FacturaElectronicaDTO;
import com.certicamara.certifactura.web.dominio.FacturaElectronicaDominio;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;



/**
 * CertiFactura
 * Certicámara S.A.
 * FacturaElectronicaController
 * @author Seven4N Ltda.
 * Apr 19, 2012
 * 
 * Controlador de las peticiones de una factura electronica
 * 
 */
@Controller
@RequestMapping("/factura/electronica/**")
public class FacturaElectronicaController {
	
	
	@Autowired
	GestorComandos gestorComandos;
	
	/**
	 * Constructor del controlador
	 */
	public FacturaElectronicaController(){
		
	}
	
	
	/**
	 * Muestra la pagina que permite crear una factura electronica
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/factura/electronica", method = {RequestMethod.GET,RequestMethod.POST} )
    public String index(HttpServletRequest request, ModelMap modelMap) {
		SimpleDateFormat sf = new SimpleDateFormat( "MM/dd/yyyy" );		
		String contextPath = request.getServletContext( ).getContextPath( );
		Date fechaActual = Calendar.getInstance( ).getTime( );	
		String fechaFormateada = sf.format( fechaActual );
		modelMap.put( "contextPath", contextPath );
		modelMap.put( "fechaActual", fechaFormateada );
    	return "facturaElectronica/crearFacturaElectronica";
    }
	
	
	/**
	 * Crea una factura electronica con los datos que se han cargado en la pagina de creacion
	 * 
	 * @param facturaElectronica
	 * @param result
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/factura/electronica/crear", method = {RequestMethod.GET,RequestMethod.POST} )
    public String crearFactura(
    		@ModelAttribute("facturaElectronicaDominio") FacturaElectronicaDTO facturaElectronica,
    	    BindingResult result, Model model,
    		HttpServletRequest request, 
    		HttpServletResponse response) {
		String xml = null;
		try{
			XStream xstream = new XStream(new JettisonMappedXmlDriver());	
			xstream.setMode(XStream.NO_REFERENCES);
			xstream.alias("FacturaElectronica", FacturaElectronicaDTO.class);
			xml = xstream.toXML(facturaElectronica);
			Comando comando = (Comando)new ComandoCrearFacturaElectronica(xml, "Exito");
			gestorComandos.recibirComando(comando);
		}catch( Exception ex ){
			ex.printStackTrace();
		}		
		return null;
		
	}
	
	

}
