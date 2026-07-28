package com.soa.service;

import java.util.List;

import com.soa.dto.ProductDto;

public interface APIService {
	ProductDto displayProductById(int id);
	List<ProductDto> displayallProducts();
}
