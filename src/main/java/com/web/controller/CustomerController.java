package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.Customer;
import com.web.repo.CustomerRepo;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerRepo customerRepo;

	@PostMapping("/save")
	public Customer save(@RequestBody Customer cd)
	{
		return customerRepo.save(cd);
	}
}
