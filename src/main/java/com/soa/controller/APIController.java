package com.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soa.dto.ProductDto;
import com.soa.service.APIService;

@RestController
@RequestMapping("/fakestore")
public class APIController {
	@Autowired
	private APIService service;
	
	
	@GetMapping("/displayall")
	public List<ProductDto> displayall(){
		return service.displayallProducts();
		}
	@GetMapping("/display/{id}")
	public ProductDto displayproductbyId(@PathVariable int id) {
		return service.displayProductById(id);
	}
}
