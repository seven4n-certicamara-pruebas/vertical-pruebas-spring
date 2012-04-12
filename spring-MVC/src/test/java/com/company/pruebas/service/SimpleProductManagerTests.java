package com.company.pruebas.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.company.prueba.domain.Product;
import com.company.prueba.service.SimpleProductManager;

/*
 * Esta clase implementa la interface ProductManager.
 * 
 */
public class SimpleProductManagerTests {

	private SimpleProductManager productManager;

	private List<Product> products;

	private static int PRODUCT_COUNT = 2;

	private static Double CHAIR_PRICE = new Double(20.50);
	private static String CHAIR_DESCRIPTION = "Chair";

	private static String TABLE_DESCRIPTION = "Table";
	private static Double TABLE_PRICE = new Double(150.10);

	private static int POSITIVE_PRICE_INCREASE = 10;

	@Before
	public void setUp() throws Exception {
		productManager = new SimpleProductManager();
		products = new ArrayList<Product>();

		// stub up a list of products
		Product product = new Product();
		product.setDescription("Chair");
		product.setPrice(CHAIR_PRICE);
		products.add(product);

		product = new Product();
		product.setDescription("Table");
		product.setPrice(TABLE_PRICE);
		products.add(product);

		productManager.setProducts(products);

	}

	@Test
	public void testGetProductsWithNoProducts() {
		productManager = new SimpleProductManager();
		Assert.assertNull(productManager.getProducts());
	}

	@Test
	public void testGetProducts() {
		List<Product> products = productManager.getProducts();
		Assert.assertNotNull(products);
		Assert.assertEquals(PRODUCT_COUNT, productManager.getProducts().size());

		Product product = products.get(0);
		Assert.assertEquals(CHAIR_DESCRIPTION, product.getDescription());
		Assert.assertEquals(CHAIR_PRICE, product.getPrice());

		product = products.get(1);
		Assert.assertEquals(TABLE_DESCRIPTION, product.getDescription());
		Assert.assertEquals(TABLE_PRICE, product.getPrice());
	}

	@Test
	public void testIncreasePriceWithNullListOfProducts() {
		try {
			productManager = new SimpleProductManager();
			productManager.increasePrice(POSITIVE_PRICE_INCREASE);
		} catch (NullPointerException ex) {
			Assert.fail("Products list is null.");
		}
	}

	@Test
	public void testIncreasePriceWithEmptyListOfProducts() {
		try {
			productManager = new SimpleProductManager();
			productManager.setProducts(new ArrayList<Product>());
			productManager.increasePrice(POSITIVE_PRICE_INCREASE);
		} catch (Exception ex) {
			Assert.fail("Products list is empty.");
		}
	}

	@Test
	public void testIncreasePriceWithPositivePercentage() {
		productManager.increasePrice(POSITIVE_PRICE_INCREASE);
		double expectedChairPriceWithIncrease = 22.55;
		double expectedTablePriceWithIncrease = 165.11;

		List<Product> products = productManager.getProducts();
		Product product = products.get(0);
		Assert.assertEquals(expectedChairPriceWithIncrease, product.getPrice(),
				0);

		product = products.get(1);
		Assert.assertEquals(expectedTablePriceWithIncrease, product.getPrice(),
				0);
	}
}