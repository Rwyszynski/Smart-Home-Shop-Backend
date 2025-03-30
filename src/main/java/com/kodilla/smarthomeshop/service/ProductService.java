package com.kodilla.smarthomeshop.service;

import com.kodilla.smarthomeshop.domain.Product;
import com.kodilla.smarthomeshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product save(Product product) {return productRepository.save(product);}
}
