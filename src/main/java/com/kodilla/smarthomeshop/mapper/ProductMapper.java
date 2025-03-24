package com.kodilla.smarthomeshop.mapper;

import com.kodilla.smarthomeshop.domain.Product;
import com.kodilla.smarthomeshop.domain.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductMapper {

    public List<ProductDto> mapToProductDtoList(final List<Product> products) {
        return products.stream()
                    .map(this::mapToProductDto)
                    .toList();
    }

    public Product mapToProduct (final ProductDto productDto) {
        return new Product(
                productDto.getComponentlist_id(),
                productDto.getBrand(),
                productDto.getModel(),
                productDto.getVoltege(),
                productDto.getPower(),
                productDto.getProtocol(),
                productDto.getPrice(),
                productDto.getCurrent());
    }

    public ProductDto mapToProductDto (final Product product) {
        return new ProductDto(
                product.getComponentlist_id(),
                product.getBrand(),
                product.getModel(),
                product.getVoltege(),
                product.getPower(),
                product.getProtocol(),
                product.getPrice(),
                product.getCurrent());
    }
}


