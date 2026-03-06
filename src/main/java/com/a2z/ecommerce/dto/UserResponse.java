package com.a2z.ecommerce.dto;

import com.a2z.ecommerce.model.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {


    private Long userId;
    private String userName;
    private String userEmail;
    private String password;
    private String phoneNumber;
    private String address;
    private Set<Role> userRoles;
}
