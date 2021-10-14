package com.SpringJPASpringboot;

import java.util.List;

import org.springframework.data.domain.Page;



public interface ProductService {
public List<Product>getProducts();
		
	
	public Product getProduct(long id);
	
	public Product addProduct(Product product);
	
	public Product updateProduct(Product product);

    public void deleteProduct(long parseLong);
    
    Page<Product> findpaginated(int pageNo,int pageSize);
	
}