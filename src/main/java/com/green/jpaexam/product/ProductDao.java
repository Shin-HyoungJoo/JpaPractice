package com.green.jpaexam.product;

import com.green.jpaexam.product.model.ProductEntity;

public interface ProductDao {
    ProductEntity saveProduct(ProductEntity p);
}