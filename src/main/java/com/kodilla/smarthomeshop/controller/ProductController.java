package com.kodilla.smarthomeshop.controller;

import com.kodilla.smarthomeshop.domain.Product;
import com.kodilla.smarthomeshop.domain.ProductDto;
import com.kodilla.smarthomeshop.mapper.ProductMapper;
import com.kodilla.smarthomeshop.repository.ProductRepository;
import com.kodilla.smarthomeshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
@CrossOrigin("*")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(productMapper.mapToProductDtoList(products));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createProduct(@RequestBody ProductDto productDto) {
        Product product = productMapper.mapToProduct(productDto);
        productService.save(product);
        return ResponseEntity.ok().build();
    }

}
