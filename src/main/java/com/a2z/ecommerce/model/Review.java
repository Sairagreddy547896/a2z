package com.a2z.ecommerce.model;

import jakarta.persistence.*;

import java.time.LocalDate;

public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    private String comment;
    private int rating;

    private LocalDate reviewDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

}
