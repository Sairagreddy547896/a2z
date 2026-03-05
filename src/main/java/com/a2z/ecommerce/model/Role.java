package com.a2z.ecommerce.model;

import jakarta.persistence.*;


@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="role_id")
    private User user;
}
