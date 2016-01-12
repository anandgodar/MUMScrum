package com.scrum.portal.services;

import java.util.Date;
import java.util.List;

import com.scrum.portal.dto.Product;
import com.scrum.portal.model.ProductFormBean;;

public interface ProductService {

	
	public void createNewProduct(ProductFormBean product);
	
	public List<Product> listAllProduct();

	public Product findProductById(int id);

	public boolean updateProduct(ProductFormBean product);
	public void deletebyId(int id);
}
