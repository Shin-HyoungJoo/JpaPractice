package com.green.jpaexam.product;

import com.green.jpaexam.product.model.ProductDto;
import com.green.jpaexam.product.model.ProductEntity;
import com.green.jpaexam.product.model.ProductRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductDao dao;

    public ProductRes saveProduct(ProductDto dto) {
        ProductEntity entity = ProductEntity.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .stock(dto.getStock())
                .build();
        ProductEntity result = dao.saveProduct(entity);
        return ProductRes.builder()
                .number(result.getNumber())
                .name(result.getName())
                .price(result.getPrice())
                .stock(result.getStock())
                .build();
    }
}