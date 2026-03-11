package com.a2z.ecommerce.dto;

import com.a2z.ecommerce.model.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class RoleRequest {

    private Long id;

    private String roleName;
    private User user;
}
