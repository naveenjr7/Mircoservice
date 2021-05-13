package com.learn.mircroservice.product.Service;

import com.learn.mircroservice.product.Model.Product;
import com.learn.mircroservice.product.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product save(Product product) {
        productRepository.save(product);
        return product;
    }

    public Product get(String name) {
        return productRepository.findByName(name);
    }
}
