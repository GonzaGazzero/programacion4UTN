package com.ejer8.seguridad.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String username;
    private String password;
    private Role role;

    public enum Role {
        ROLE_LECTOR,
        ROLE_BIBLIOTECARIO,
        ROLE_ADMIN
    }
}
