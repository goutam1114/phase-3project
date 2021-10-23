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

import com.simplilearn.webservice.entity.Order;
import com.simplilearn.webservice.exceptions.InvalidProductException;
import com.simplilearn.webservice.exceptions.ProductNotFoundException;
import com.simplilearn.webservice.repository.OrderRepository;

@RestController
@RequestMapping("/api")
public class OrderController {
	@Autowired
	OrderRepository oRepo;


	@GetMapping("/order")
	public List<Order> getProducts() {
		List<Order> list= oRepo.findAll();
		if(!list.isEmpty()) {
			return list;
		}
		throw new ProductNotFoundException("Order list is Empty");

	}

	@GetMapping("/order/{id}")
	public Order getProducts(@PathVariable("id") long id) {
		Order fetchedOrder = oRepo.findById(id).orElseThrow(() -> {
			throw new ProductNotFoundException("order does not exist with id " + id);
		});
		return fetchedOrder;
	}

	@PostMapping("/order")
	public Order addProduct(@RequestBody(required=false) Order orderObj ) {
		if(orderObj !=null) {
			return oRepo.save(orderObj);
		}
		throw new InvalidProductException("Order creation failed ! missing project object !");
	}
	@PutMapping("/order")
	public Order updateProduct(@RequestBody Order orderObj) {
		// step 1: find product
		Order fetchedOrder = oRepo.findById(orderObj.getId()).orElseThrow(() -> {
			throw new ProductNotFoundException("Product does not exist with id " + orderObj.getId());
		});
		// step 2: Map updating fields
		fetchedOrder.setName(orderObj.getName());
		fetchedOrder.setPrice(orderObj.getPrice());
		fetchedOrder.setDescription(orderObj.getDescription());
		// step 3: update
		return oRepo.save(orderObj);

	}

	@DeleteMapping("/order/{id}")
	public void deleteProduct(@PathVariable("id") long id) {
		// step 1: find product
		Order fetchedOrder = oRepo.findById(id).orElseThrow(() -> {
			throw new ProductNotFoundException("Order does not exist with id " + id);
		});
		// step 2: delete
		oRepo.delete( fetchedOrder);
	}

}
