package com.a2z.ecommerce.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequest {

    private String comment;
    private int rating;
    private LocalDate reviewDate;
    private Long customerId;
    private Long productId;
}
