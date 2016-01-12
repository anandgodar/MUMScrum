package com.scrum.portal.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scrum.portal.dto.Employee;
import com.scrum.portal.dto.Product;
import com.scrum.portal.dto.Sprint;
import com.scrum.portal.model.EmployeeFormBean;
import com.scrum.portal.model.ProductFormBean;
import com.scrum.portal.repositories.ProductRepository;
import com.scrum.portal.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void createNewProduct(ProductFormBean product) {
		Product productEntity = new Product();
		productEntity.setDescription(product.getDescription());
		productEntity.setTitle(product.getTitle());
		//productEntity.setCreatedDate(product.getCreatedDate());
		//productEntity.setCreatedBy(product.getCreatedBy());
		productRepository.save(productEntity);

	}

	@Override
	public List<Product> listAllProduct() {
		return productRepository.findAll();
		
	}

	@Override
	public Product findProductById(int id) {
		return productRepository.findOne(id);
	}

	@Override
	public boolean updateProduct(ProductFormBean product) {
		Product productEntity = new Product();
		productEntity.setDescription(product.getDescription());
		productEntity.setTitle(product.getTitle());
		productEntity.setId(product.getId());

		if(productRepository.save(productEntity)!=null){
			return true;
		}
		
		return false;

	}

	@Override
	public void deletebyId(int id) {
		productRepository.delete(id);

	}

}
