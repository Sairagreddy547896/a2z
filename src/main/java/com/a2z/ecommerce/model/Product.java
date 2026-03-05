package com.a2z.ecommerce.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productType;
    private String brand;
    private String imageUrl;
    private String description;
    private String price;
    private int quantityAvailable;

    @OneToMany(mappedBy = "product",
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    private List<Review> reviews;
}
