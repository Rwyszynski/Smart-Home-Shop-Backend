package com.kodilla.smarthomeshop.service;

import com.kodilla.smarthomeshop.controller.ProductNotFoundException;
import com.kodilla.smarthomeshop.domain.Product;
import com.kodilla.smarthomeshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Product getProduct(Long id) throws ProductNotFoundException {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Nie znaleliono produktu z id " + id));
    }

    public Product save(Product product) {return productRepository.save(product);}

    public void deleteProduct(Long productId) throws ProductNotFoundException {
        productRepository.deleteById(productId);
    }

    public List<Product> getProductsByType(String type) {
        return productRepository.findByType(type);
    }

    public List<Product> getProductsByName(String name) {
        return productRepository.findByBrandIgnoreCaseContainingOrModelIgnoreCaseContaining(name, name);
    }
}
