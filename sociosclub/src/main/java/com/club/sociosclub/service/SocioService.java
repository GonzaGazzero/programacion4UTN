package com.club.sociosclub.service;

import com.club.sociosclub.dto.SocioRequestDTO;
import com.club.sociosclub.dto.SocioResponseDTO;
import com.club.sociosclub.dto.DireccionDTO;
import com.club.sociosclub.entity.Socio;
import com.club.sociosclub.exception.DniDuplicadoException;
import com.club.sociosclub.repository.SocioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class SocioService {

    private final SocioRepository socioRepository;

    public SocioService(SocioRepository socioRepository) {
        this.socioRepository = socioRepository;
    }

    public SocioResponseDTO crearSocio(SocioRequestDTO dto) {
        if (socioRepository.existsByDni(dto.getDni())) {
            throw new DniDuplicadoException();
        }

        Socio socio = new Socio();
        socio.setNombre(dto.getNombre());
        socio.setApellido(dto.getApellido());
        socio.setDni(dto.getDni());
        socio.setEmail(dto.getEmail());
        socio.setPassword(dto.getPassword());
        socio.setFechaNacimiento(dto.getFechaNacimiento());
        socio.setFechaRegistro(LocalDateTime.now());

        if (dto.getDireccion() != null) {
            socio.setCalle(dto.getDireccion().getCalle());
            socio.setCiudad(dto.getDireccion().getCiudad());
            socio.setProvincia(dto.getDireccion().getProvincia());
            socio.setCodigoPostal(dto.getDireccion().getCodigoPostal());
        }

        Socio savedSocio = socioRepository.save(socio);
        return mapToResponseDTO(savedSocio);
    }

    public SocioResponseDTO actualizarSocio(Long id, SocioRequestDTO dto) {
        Socio socio = socioRepository.findById(id).orElseThrow(() -> new RuntimeException("Socio not found"));
        
        socio.setNombre(dto.getNombre());
        socio.setApellido(dto.getApellido());
        if (dto.getEmail() != null) {
            socio.setEmail(dto.getEmail());
        }
        if (dto.getFechaNacimiento() != null) {
            socio.setFechaNacimiento(dto.getFechaNacimiento());
        }
        if (dto.getDireccion() != null) {
            socio.setCalle(dto.getDireccion().getCalle());
            socio.setCiudad(dto.getDireccion().getCiudad());
            socio.setProvincia(dto.getDireccion().getProvincia());
            socio.setCodigoPostal(dto.getDireccion().getCodigoPostal());
        }

        Socio savedSocio = socioRepository.save(socio);
        return mapToResponseDTO(savedSocio);
    }

    public SocioResponseDTO mapToResponseDTO(Socio socio) {
        SocioResponseDTO responseDTO = new SocioResponseDTO();
        responseDTO.setId(socio.getId());
        responseDTO.setNombre(socio.getNombre());
        responseDTO.setApellido(socio.getApellido());
        responseDTO.setEmail(socio.getEmail());
        responseDTO.setFechaRegistro(socio.getFechaRegistro());

        if (socio.getFechaVencimientoMembresia() == null) {
            responseDTO.setEstadoMembresia("SIN MEMBRESIA");
        } else if (socio.getFechaVencimientoMembresia().isBefore(LocalDate.now())) {
            responseDTO.setEstadoMembresia("VENCIDO");
        } else {
            responseDTO.setEstadoMembresia("ACTIVO");
        }

        DireccionDTO direccionDTO = new DireccionDTO();
        direccionDTO.setCalle(socio.getCalle());
        direccionDTO.setCiudad(socio.getCiudad());
        direccionDTO.setProvincia(socio.getProvincia());
        direccionDTO.setCodigoPostal(socio.getCodigoPostal());
        responseDTO.setDireccion(direccionDTO);

        return responseDTO;
    }
}
