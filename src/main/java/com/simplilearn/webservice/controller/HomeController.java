package com.simplilearn.webservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@GetMapping(value = "/")
	public String indexMapping() {
		return "Server is up & running";
	}
	@GetMapping(value = "/hi")
	public String hi() {
		return "Hi Have a Good Day";
		
	}
	@GetMapping(value = "/hello")
	public String hello(@RequestParam("name")String name) {
		return "hello"+name;
		
	}
	@GetMapping(value = "/gd")
	public String home() {
		return "This Is Home";
	}
	@GetMapping(value = "/message/{id}")
	public String msg(@PathVariable("id") int id) {
		if(id==1001) {
		 return "This is message with id"+id;	
		}
		return "No message found";
		
	}

}
