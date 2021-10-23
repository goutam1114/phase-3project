package com.simplilearn.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.webservice.entity.Customer;
import com.simplilearn.webservice.exceptions.InvalidProductException;
import com.simplilearn.webservice.exceptions.ProductNotFoundException;
import com.simplilearn.webservice.repository.CustomerRespository;

@RestController
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	CustomerRespository cRepo;


	@GetMapping("/customer")
	public List<Customer> getProducts() {
		List<Customer> list= cRepo.findAll();
		if(!list.isEmpty()) {
			return list;
		}
		throw new ProductNotFoundException("Product list is Empty");

	}

	@GetMapping("/customer/{id}")
	public Customer getProducts(@PathVariable("id") long id) {
		Customer fetchedCustomer = cRepo.findById(id).orElseThrow(() -> {
			throw new ProductNotFoundException("Customer does not exist with id " + id);
		});
		return fetchedCustomer;
	}

	@PostMapping("/customer")
	public Customer addCustomer(@RequestBody(required=false) Customer customerObj) {
		if(customerObj !=null) {
			return cRepo.save(customerObj);
		}
		throw new InvalidProductException("Customer creation failed ! missing project object !");
	}
	@PutMapping("/customer")
	public Customer updateCustomer(@RequestBody Customer customerObj) {
		// step 1: find product
		Customer fetchedCustomer = cRepo.findById(customerObj.getId()).orElseThrow(() -> {
			throw new ProductNotFoundException("Customer does not exist with id " + customerObj.getId());
		});
		// step 2: Map updating fields
		fetchedCustomer.setName(customerObj.getName());
		fetchedCustomer.setMail(customerObj.getMail());
		
		// step 3: update
		return cRepo.save(fetchedCustomer);

	}

	@DeleteMapping("/customer/{id}")
	public void deleteCustomer(@PathVariable("id") long id) {
		// step 1: find product
		Customer fetchedCustomer = cRepo.findById(id).orElseThrow(() -> {
			throw new ProductNotFoundException("Customer does not exist with id " + id);
		});
		// step 2: delete
		cRepo.delete(fetchedCustomer);
	}

}
