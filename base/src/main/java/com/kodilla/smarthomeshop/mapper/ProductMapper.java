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
                productDto.component_id(),
                productDto.brand(),
                productDto.model(),
                productDto.voltage(),
                productDto.power(),
                productDto.protocol(),
                productDto.current(),
                productDto.price(),
                productDto.url(),
                productDto.type());
    }

    public ProductDto mapToProductDto (final Product product) {
        return new ProductDto(
                product.getComponent_id(),
                product.getBrand(),
                product.getModel(),
                product.getVoltage(),
                product.getPower(),
                product.getProtocol(),
                product.getCurrent(),
                product.getPrice(),
                product.getUrl(),
                product.getType());
    }
}


