package com.certicamara.certifactura.web.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/factura/electronica/**")
public class FacturaElectronicaController {
	
	public FacturaElectronicaController(){
		
	}
	
	
	@RequestMapping(value = "/factura/electronica", method = {RequestMethod.GET,RequestMethod.POST} )
    public String index(ModelMap modelMap) {
		System.out.println("Index Factura Electronica");

    	return "facturaElectronica/crearFacturaElectronica";
    }
	
	

}
