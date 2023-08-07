package com.green.jpaexam.product;

import com.green.jpaexam.product.model.ProductEntity;
import com.green.jpaexam.product.model.ProductRes;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductDaoImpl implements ProductDao {

    private final ProductRepository rep;

    @Override
    public ProductRes saveProduct(ProductEntity p) {
        ProductEntity result = rep.save(p);
        return ProductRes.builder()
                .name(result.getName())
                .number(result.getNumber())
                .price(result.getPrice())
                .stock(result.getStock())
                .build();
    }

    @Override
    public List<ProductRes> getProductAll() {
        return rep.findAll(Sort.by(Sort.Direction.DESC, "number")).stream().map(item ->
                ProductRes.builder()
                        .number(item.getNumber())
                        .stock(item.getStock())
                        .name(item.getName())
                        .price(item.getPrice())
                        .build()
        ).toList();
    }

    @Override
    public ProductRes getProduct(Long number) {
        Optional<ProductEntity> opt = rep.findById(number);
        if (!opt.isPresent()) {
            return null;
        }
        ProductEntity entity = opt.get();

        return ProductRes.builder()
                .number(entity.getNumber())
                .stock(entity.getStock())
                .price(entity.getPrice())
                .name(entity.getName())
                .build();
    }

    @Override
    public ProductRes updProduct(ProductEntity p) {
        Optional<ProductEntity> opt = rep.findById(p.getNumber());
        if (!opt.isPresent()) {
            return null;
        }
        ProductEntity entity = opt.get();

        entity.setName(p.getName());
        entity.setStock(p.getStock());
        entity.setPrice(p.getPrice());

        ProductEntity result = rep.save(entity);
        return ProductRes.builder()
                .number(result.getNumber())
                .stock(result.getStock())
                .price(result.getPrice())
                .name(result.getName()).build();
    }

    @Override
    public void delProduct(Long number) {
        rep.deleteById(number);
    }

//    private ProductEntity
}
