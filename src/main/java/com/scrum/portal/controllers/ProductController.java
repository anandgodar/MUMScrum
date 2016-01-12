package com.scrum.portal.controllers;


import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scrum.portal.dto.Product;
import com.scrum.portal.model.ProductFormBean;

import com.scrum.portal.services.ProductService;

@Controller
@RequestMapping(value="/product")
public class ProductController {
	@Autowired
	ProductService productservice;

	@RequestMapping(value = "/saveproduct", method = RequestMethod.GET)
	public String createproduct(Model model) {
		
		model.addAttribute("actionTitle", "Add Product");
		model.addAttribute("actionText", "/product/CreateProduct");
		model.addAttribute("page", "product/CreateProduct");
		return "Container";
	}

	@RequestMapping(value = "/CreateProduct", method = RequestMethod.POST)
	public String createproduct(@ModelAttribute("product") ProductFormBean productModel,Model model) {
		
		productservice.createNewProduct(productModel);
		return "redirect:/product/listproduct";
		
	}

	@RequestMapping(value = "/listproduct", method = RequestMethod.GET)
	public String listproduct(Model model) {
		List<Product> products = productservice.listAllProduct();
		model.addAttribute("listproduct", products);
		model.addAttribute("page", "product/listproduct");
		return "Container";
		
	}
	
	
	@RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
	public String editProduct(@PathVariable("id")int Id,@ModelAttribute("product") ProductFormBean product,Model model) throws IllegalAccessException, InvocationTargetException
	{
		
		Product myProduct = productservice.findProductById(Id);
		model.addAttribute("actionText", "/product/updateproduct");
		model.addAttribute("product", myProduct);
		model.addAttribute("page", "product/CreateProduct");
		model.addAttribute("actionTitle", "Edit Product");
		return "Container";    
		
	}
	
	@RequestMapping(value="/updateproduct",method=RequestMethod.POST)
	public String updateproduct(@ModelAttribute("product") ProductFormBean product,Model model) throws IllegalAccessException, InvocationTargetException
	{

		
		if(productservice.updateProduct(product)){
			
			return "redirect:/product/listproduct";
		}
	
		model.addAttribute("page", "product/CreateProduct");
	
		return "Container";
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String deleteProduct(@PathVariable("id") int Id) throws IllegalAccessException, InvocationTargetException
	{
		
		productservice.deletebyId(Id);
			
		return "redirect:/product/listproduct";
		
	}


}
