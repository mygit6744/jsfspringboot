package com.yugandhar.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.yugandhar.dao.ProductService;
import com.yugandhar.entity.Product;


@ManagedBean (value = "productList")
@RequestScoped
public class ProductListController extends SpringBeanAutowiringSupport{
    
    private List<Product> products = new ArrayList<>();
    
	@Autowired
	private ProductService productService;
	
	
    public void setProducts(List<Product> products) {
		this.products = products;
	}


	public List<Product> getProducts() {
		products = productService.getProducts();
        return products;
    }
}
