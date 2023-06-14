package com.yugandhar.jps.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yugandhar.entity.Product;

@Repository
public interface ProductsRepository extends CrudRepository<Product, Integer> {

		@Override
		List<Product> findAll();
}
