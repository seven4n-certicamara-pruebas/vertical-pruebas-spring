package com.company.pruebas.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.company.prueba.domain.Product;

public class ProductTests {

    private Product product;

    @Before
    public void setUp() throws Exception {
        product = new Product();
    }

    @Test
    public void testSetAndGetDescription() {
        String testDescription = "aDescription";
        Assert.assertNull(product.getDescription());
        product.setDescription(testDescription);
        Assert.assertEquals(testDescription, product.getDescription());
    }

    @Test
    public void testSetAndGetPrice() {
        double testPrice = 100.00;
        Assert.assertEquals(0, 0, 0);    
        product.setPrice(testPrice);
        Assert.assertEquals(testPrice, product.getPrice(), 0);
    }

}