package com.kodilla.smarthomeshop.controller;

import com.kodilla.smarthomeshop.domain.*;
import com.kodilla.smarthomeshop.mapper.ProductMapper;
import com.kodilla.smarthomeshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    private final ProductMapper productMapper;

    @GetMapping
    public ResponseEntity<AllProductDto> getAllProducts(@PageableDefault(page = 0, size = 10)
                                                            @RequestParam(required = false) Pageable pageable) {
        List<Product> products = productService.getAllProducts(pageable);
        return ResponseEntity.ok(new AllProductDto(productMapper.mapToProductDtoList(products)));
    }

    @GetMapping(value = "/{productId}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long productId) throws ProductNotFoundException {
        return ResponseEntity.ok(productMapper.mapToProductDto(productService.getProduct(productId)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        Product product = productMapper.mapToProduct(productDto);
        productService.save(product);
        return ResponseEntity.ok(productDto);
    }

    @PutMapping
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto) {
        Product product = productMapper.mapToProduct(productDto);
        Product savedProduct = productService.save(product);
        return ResponseEntity.ok(productMapper.mapToProductDto(savedProduct));
    }

    @DeleteMapping(value = "/{productId}")
    public ResponseEntity<ProductSuccessfullyDeleted> deleteProduct(@PathVariable Long productId) throws ProductNotFoundException {
        productService.deleteProduct(productId);
        return ResponseEntity.ok(new ProductSuccessfullyDeleted("Usunięto produkt z id " + productId));
    }
}