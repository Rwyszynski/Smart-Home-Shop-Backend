package com.kodilla.smarthomeshop.service;

import com.kodilla.smarthomeshop.controller.ProductNotFoundException;
import com.kodilla.smarthomeshop.domain.Product;
import com.kodilla.smarthomeshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(Long id) throws ProductNotFoundException {
        return productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

    public Product save(Product product) {return productRepository.save(product);}

    public void deleteProduct(Long productId) throws ProductNotFoundException {
        productRepository.deleteById(productId);
    }
}
