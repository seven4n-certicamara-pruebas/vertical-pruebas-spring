package com.company.prueba.service;

import java.io.Serializable;
import java.util.List;

import com.company.prueba.domain.Product;

public interface ProductManager extends Serializable {

    public void increasePrice(int percentage);
    
    public List<Product> getProducts();

}