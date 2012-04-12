package com.company.prueba.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.company.prueba.service.ProductManager;

/*
 * En esta clase almacenaremos una referencia a la clase ProductManager.
 * También añadimos código para permitir al controlador pasar la información sobre los 
 * productos a la vista. 
 *  
 * */

@Controller
public class InventoryController {

	protected final Log logger = LogFactory.getLog(getClass());
	/*
	 * Anotaremos la referencia con @Autowired para que Spring la pueda inyectar
	 * automáticamente cuando detecte el componente.
	 */
	@Autowired
	private ProductManager productManager;

	@RequestMapping(value = "/hello.htm")
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String now = (new Date()).toString();
		logger.info("Returning hello view with " + now);

		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("now", now);
		myModel.put("products", this.productManager.getProducts());

		return new ModelAndView("hello", "model", myModel);
	}

	/*
	 * El método getModelAndView() ahora devuelve tanto un Map con la fecha y
	 * hora como una lista de productos.
	 */

	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}
}