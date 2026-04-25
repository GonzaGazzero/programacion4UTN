package com.club.sociosclub.repository;

import com.club.sociosclub.entity.Socio;
import org.springframework.data.repository.CrudRepository;

public interface SocioRepository extends CrudRepository<Socio, Long> {
    boolean existsByDni(String dni);
}
