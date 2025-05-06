package com.springboot.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.dao.CompanyRepository;
import com.springboot.demo.entity.Company;

@Service
public class CompanyServiceImpl implements CompanyService {


	@Autowired
	private CompanyRepository companyRepository;
	

	
	@Override
	public List<Company> findAll() {
		return companyRepository.findAll();
	}

	@Override
	public Company findById(int theId) {
		Optional<Company> result = companyRepository.findById(theId);
		
		Company company = null;
		
		if (result.isPresent()) {
			company = result.get();
		}
		else {
			// we didn't find the company
			throw new RuntimeException("Did not find company id - " + theId);
		}
		
		return company;
	}

	@Override
	public void save(Company company) {
		companyRepository.save(company);
	}

	@Override
	public void deleteById(int theId) {
		companyRepository.deleteById(theId);
	}

	
}
