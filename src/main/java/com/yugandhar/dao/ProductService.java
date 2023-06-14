package com.yugandhar.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yugandhar.entity.Product;
import com.yugandhar.jps.repository.ProductsRepository;

@Service
public class ProductService {

	@Autowired
	private ProductsRepository productsRepository;

	public List<Product> getProducts() {
		return productsRepository.findAll();
	}
}
