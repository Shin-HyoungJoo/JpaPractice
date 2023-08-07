package com.green.jpaexam.product.model;

import lombok.Data;

@Data
public class ProductDto {
    private final String name;
    private final int price;
    private final int stock;
}