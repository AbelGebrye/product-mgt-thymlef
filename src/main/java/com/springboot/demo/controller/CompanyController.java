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

import com.springboot.demo.entity.Company;
import com.springboot.demo.service.CompanyService;
import com.springboot.demo.service.ProductService;

@Controller
@RequestMapping("/companys")
public class CompanyController {
	@Autowired
	private CompanyService companyService;

	
	@GetMapping("/users")
	public String getUser() {
		return "You are using Https";
	}
	
	// add mapping for "/list"
	@GetMapping("/list")
	public String companyList(Model model) {
	
		// get employees from data base
		List<Company> products = companyService.findAll();
		
		// add to the spring model
		model.addAttribute("Company", products);
	 
		return "companys/list-companys";
	}
	
	// add mapping for "/add" to add new employees
	@GetMapping("/add")
	public String addCompany(Model model) {
		
		// create model attribute to bind form data
		Company company = new Company();
		
		model.addAttribute("Company", company);
		
	
		return "companys/company-form";
	}
	
	@GetMapping("/update")
	public String updateEmployee(@RequestParam("Id") int id, Model model) {
		
		// get the employee from the service
		Company company = companyService.findById(id);
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("Company", company);
		
		// send over to our form
		return "companys/company-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("Id") int id) {

		// delete employee
		companyService.deleteById(id);

		// return to list
		return "redirect:/products/list";
	}

	
	@PostMapping("/save")
	public String saveCompany(@ModelAttribute("Company") Company company) {
		
		// save the employee
		companyService.save(company);
		
		// use a redirect to prevent duplicated submissions
		return "redirect:/companys/list";
	}
}
