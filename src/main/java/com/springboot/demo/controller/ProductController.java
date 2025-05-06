package com.springboot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.demo.entity.Product;
import com.springboot.demo.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	
	// add mapping for "/list"
	@GetMapping("/list")
	public String employeeList(Model model) {
	
		// get employees from data base
		List<Product> products = productService.findAll();
		
		// add to the spring model
		model.addAttribute("products", products);
	 
		return "products/list-products";
	}
	
	// add mapping for "/add" to add new employees
	@GetMapping("/add")
	public String addEmployee(Model model) {
		
		// create model attribute to bind form data
		Product product = new Product();
		
		model.addAttribute("products", product);
		
		return "products/product-form";
	}
	
	@GetMapping("/adds")
	public String adduser(Model model) {
		
		// create model attribute to bind form data
		Product product = new Product();
		
		model.addAttribute("products", product);
		
		return "admin/adduser";
	}
	
	@GetMapping("/update")
	public String updateEmployee(@RequestParam("Id") int id, Model model) {
		
		// get the employee from the service
		Product product = productService.findById(id);
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("products", product);
		
		// send over to our form
		return "products/product-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("Id") int id) {

		// delete employee
		productService.deleteById(id);

		// return to list
		return "redirect:/products/list";
	}

	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("product") Product product) {
		
		// save the employee
		productService.save(product);
		
		// use a redirect to prevent duplicated submissions
		return "redirect:/products/list";
	}
}
