package com.ejer8.seguridad;

import com.ejer8.seguridad.model.User;
import com.ejer8.seguridad.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final AuthService authService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        authService.addUser(User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin123"))
                .role(User.Role.ROLE_ADMIN)
                .build());

        authService.addUser(User.builder()
                .username("biblio")
                .password(passwordEncoder.encode("biblio123"))
                .role(User.Role.ROLE_BIBLIOTECARIO)
                .build());

        authService.addUser(User.builder()
                .username("lector")
                .password(passwordEncoder.encode("lector123"))
                .role(User.Role.ROLE_LECTOR)
                .build());

        System.out.println("Initial users created: admin/admin123, biblio/biblio123, lector/lector123");
    }
}
