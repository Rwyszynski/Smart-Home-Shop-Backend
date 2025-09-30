package com.kodilla.smarthomeshop.domain.util;

import com.kodilla.smarthomeshop.domain.dto.AllProductDto;
import com.kodilla.smarthomeshop.domain.dto.CreateProductDto;
import com.kodilla.smarthomeshop.domain.dto.ProductSuccessfullyDeleted;
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
class ProductController {

    private final SmartHomeFacade smartHomeFacade;
    private final ProductMapper productMapper;

    @GetMapping
    public ResponseEntity<AllProductDto> getAllProducts(@PageableDefault(page = 0, size = 10)
                                                            @RequestParam(required = false) Pageable pageable) {
        List<Product> products = smartHomeFacade.getAllProducts(pageable);
        return ResponseEntity.ok(new AllProductDto(productMapper.mapToProductDtoList(products)));
    }

    @GetMapping(value = "/{productId}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long productId) throws ProductNotFoundException {
        return ResponseEntity.ok(productMapper.mapToProductDto(smartHomeFacade.getProducts(productId)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateProductDto> createProduct(@RequestBody CreateProductDto productDto) {
        Product product = productMapper.mapToProduct(productDto);
        product.setComponent_id(null);
        Product saved = smartHomeFacade.saveProduct(product);
        return ResponseEntity.ok(productMapper.mapToCreateProductDto(saved));
    }

    @PutMapping
    public ResponseEntity<CreateProductDto> updateProduct(@RequestBody CreateProductDto productDto) {
        Product product = productMapper.mapToProduct(productDto);
        Product savedProduct = smartHomeFacade.saveProduct(product);
        return ResponseEntity.ok(productMapper.mapToCreateProductDto(savedProduct));
    }

    @DeleteMapping(value = "/{productId}")
    public ResponseEntity<ProductSuccessfullyDeleted> deleteProduct(@PathVariable Long productId) throws ProductNotFoundException {
        smartHomeFacade.deleteProduct(productId);
        return ResponseEntity.ok(new ProductSuccessfullyDeleted("Usunięto produkt z id " + productId));
    }

    @GetMapping("/{type}")
    public ResponseEntity<AllProductDto> getProductsByType(@PathVariable String type) {
        List<Product> productByType = smartHomeFacade.getProductsByType(type);
        return ResponseEntity.ok(new AllProductDto(productMapper.mapToProductDtoList(productByType)));
    }

    @GetMapping("/{name}")
    public ResponseEntity<AllProductDto> getProductsByName(@PathVariable String name) {
        List<Product> productByName = smartHomeFacade.getProductsByName(name);
        return ResponseEntity.ok(new AllProductDto(productMapper.mapToProductDtoList(productByName)));
    }
}