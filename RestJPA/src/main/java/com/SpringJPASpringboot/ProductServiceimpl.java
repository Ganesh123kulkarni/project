package com.SpringJPASpringboot;






import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;




@Service
public class ProductServiceimpl implements ProductService  {

	@Autowired
    private ProductDao productDao;
	
	public ProductServiceimpl() {
		
		
		
	}
	
	@Override
	public List<Product> getProducts() {
        return productDao.findAll() ;
	}

	@Override
	public Product getProduct(long id) {
		
		return productDao.findById(id).get();
	}

	@Override
	public Product addProduct(Product product) {
		productDao.save(product);
		return product;
	}

	@Override
	public Product updateProduct(Product product) {
	    productDao.save(product);	
		return product;
	}

public void deleteProduct(long parseLong) {
  Product entity = productDao.getById(parseLong);
  productDao.delete(entity);
    }

@Override
public Page<Product> findpaginated(int pageNo, int pageSize) {
	Pageable pageable= PageRequest.of(pageNo - 1, pageSize);
	return this.productDao.findAll(pageable);
}
	
	
	
	
}
