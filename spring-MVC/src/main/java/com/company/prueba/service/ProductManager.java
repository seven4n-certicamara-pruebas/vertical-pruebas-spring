package com.company.prueba.service;

import java.io.Serializable;
import java.util.List;
import com.company.prueba.domain.Product;

//Esta clase define el servicio ProductManager, el cual es el responsable de gestionar los productos

public interface ProductManager extends Serializable {
	//Incrementa el precio de todos los productos
    public void increasePrice(int percentage);
    //Recupera todos los productos
    public List<Product> getProducts();

}