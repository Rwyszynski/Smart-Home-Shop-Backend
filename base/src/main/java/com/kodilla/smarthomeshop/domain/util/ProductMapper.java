package com.kodilla.smarthomeshop.domain.util;

import com.kodilla.smarthomeshop.domain.dto.CreateProductDto;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
class ProductMapper {

    public List<ProductDto> mapToProductDtoList(final List<Product> products) {
        return products.stream()
                    .map(this::mapToProductDto)
                    .toList();
    }

    public Product mapToProduct (final CreateProductDto productDto) {
        return new Product(
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

    public CreateProductDto mapToCreateProductDto(Product saved) {
        return new CreateProductDto(
            saved.getBrand(),
            saved.getModel(),
            saved.getVoltage(),
            saved.getPower(),
            saved.getProtocol(),
            saved.getCurrent(),
            saved.getPrice(),
            saved.getUrl(),
            saved.getType());
    }


}


