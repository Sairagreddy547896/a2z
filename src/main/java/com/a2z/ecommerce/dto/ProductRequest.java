package com.a2z.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductRequest {

    @NotBlank(message = "productType required")
    private String productType;
    @NotBlank(message = "brand name required")
    private String brand;
    @NotBlank(message = "image url is required")
    private String imageUrl;
    @NotBlank(message = "description required")
    private String description;
    @NotNull(message = "price cannot be null")
    private String price;
    private int quantityAvailable;

}
