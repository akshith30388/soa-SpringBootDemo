package com.soa.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.soa.dto.ProductDto;

@Service
public class APIServiceImpl implements APIService {
    @Autowired
    private RestTemplate template;

    private String apiurl = "https://fakestoreapi.com/products";

    public List<ProductDto> displayallProducts() {

        ProductDto[] data = template.getForObject(apiurl, ProductDto[].class);

        return Arrays.asList(data);
    }

  
    public ProductDto displayProductById(int id) {

        return template.getForObject(apiurl + "/" + id, ProductDto.class);
    }
}