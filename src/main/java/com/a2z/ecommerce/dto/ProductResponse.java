package com.a2z.ecommerce.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private Long productId;
    private String productType;
    private String brand;
    private String imageUrl;
    private String description;
    private String price;
    private int quantityAvailable;
}
