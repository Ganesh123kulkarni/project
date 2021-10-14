package com.SpringJPASpringboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MyController {


	@Autowired
	private ProductService productService;
	
	
	@GetMapping("/products")
	public List<Product> getProducts(){
		
		return this.productService.getProducts();
	}
	  
	@GetMapping("/products/{id}")
	public Product getProduct(@PathVariable String id) {
		return this.productService.getProduct(Long.parseLong(id));
	}
	
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product product) {
		
		return this.productService.addProduct(product);
	}
	
	@PutMapping("/products")
	public Product updateCourse(@RequestBody Product product) {
		return this.productService.updateProduct(product);	
		}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable String id){
		
		try {
			this.productService.deleteProduct(Long.parseLong(id));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//pagination
	
}
