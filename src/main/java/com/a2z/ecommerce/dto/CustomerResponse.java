package com.a2z.ecommerce.dto;

import com.a2z.ecommerce.model.Review;
import com.a2z.ecommerce.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {


    private Long customerId;
    private User user;
    private List<Review> reviews;
}
