package com.company.pruebas.web;

import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.company.prueba.service.SimpleProductManager;
import com.company.prueba.web.InventoryController;

/*
 * Esta clase proporciona un ProductManager y extrae el valor de 'now' desde el modelo Map.
 * 
 */
public class InventoryControllerTests {

	@Test
	public void testHandleRequestView() throws Exception {
		InventoryController controller = new InventoryController();
		controller.setProductManager(new SimpleProductManager());
		ModelAndView modelAndView = controller.handleRequest(null, null);
		Assert.assertEquals("hello", modelAndView.getViewName());
		Assert.assertNotNull(modelAndView.getModel());
		Map modelMap = (Map) modelAndView.getModel().get("model");
		String nowValue = (String) modelMap.get("now");
		Assert.assertNotNull(nowValue);
	}
}