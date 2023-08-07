package com.green.jpaexam.product.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

// 데이터가 같으면 동등성
// 객체가 같으면 동일성
@Data
@Table(name = "t_product")
@EqualsAndHashCode
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    @Id //PK다
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTOINCREMENT하겠다
    private Long number;

    @Column(nullable = false)   //컬럼이다
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer stock;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @CreationTimestamp
    private LocalDateTime updatedAt;
}