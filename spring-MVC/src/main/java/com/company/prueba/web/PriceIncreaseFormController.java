package com.company.prueba.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.company.prueba.service.PriceIncrease;
import com.company.prueba.service.ProductManager;

/*
 * Esta clase actuará como controlador de las peticiones de incremento de precio realizadas desde 
 * el formulario. 
 *  
 * */

@Controller
@RequestMapping(value = "/priceincrease.htm")
public class PriceIncreaseFormController {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	/*
	 * Spring inyectará automáticamente al controlador del formulario la
	 * referencia al servicio ProductManager gracias a la anotació @Autowired.
	 */

	@Autowired
	private ProductManager productManager;

	/*
	 * El método onSubmit(..) será invocado cuando el usuario envíe del
	 * formulario a través del método POST. El uso de la anotación @Valid
	 * permitirá validar el incremento introducido y volverá a mostrar el
	 * formulario en caso de que éste no sea válido.
	 */

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(PriceIncrease priceIncrease, BindingResult result) {
		if (result.hasErrors()) {
			return "priceincrease";
		}

		int increase = priceIncrease.getPercentage();
		logger.info("Increasing prices by " + increase + "%.");

		productManager.increasePrice(increase);

		return "redirect:/hello.htm";
	}

	/*
	 * El método formBackingObject() será invocado antes de que el formulario se
	 * muestre al usuario (petición GET) y rellenará el campo con un incremento
	 * por defecto de un 15%.
	 */

	@RequestMapping(method = RequestMethod.GET)
	protected PriceIncrease formBackingObject(HttpServletRequest request)
			throws ServletException {
		PriceIncrease priceIncrease = new PriceIncrease();
		priceIncrease.setPercentage(15);
		return priceIncrease;
	}

	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}

	public ProductManager getProductManager() {
		return productManager;
	}

}