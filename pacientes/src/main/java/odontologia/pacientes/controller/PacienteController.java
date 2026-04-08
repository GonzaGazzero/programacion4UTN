package odontologia.pacientes.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import odontologia.pacientes.model.Paciente;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    private List<Paciente> pacientes = new ArrayList<>();
    private Long idCont = 1L;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente crearPaciente(@RequestBody Paciente paciente) {
        validarPaciente(paciente);

        if (buscarPacienteDni(paciente.getDni())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Ya existe un paciente con el mismo DNI" + paciente.getDni());
        }
        paciente.setId(idCont++);
        pacientes.add(paciente);
        return paciente;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Paciente> obtenerPacientes() {
        return pacientes;
    }

    @GetMapping("/menores")
    @ResponseStatus(HttpStatus.OK)
    public List<Paciente> obtenerPacientesMenores() {
        List <Paciente> pacientesMenores = new ArrayList<>();
        for (Paciente p : pacientes) {
            if (menorEdad(p.getFechaNac())) {
                pacientesMenores.add(p);
            }
        }
        if (pacientesMenores.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No se encontraron pacientes menores de edad");
        }
        return pacientesMenores;
    }


    private void validarPaciente(Paciente paciente) {
        if (paciente.getDni() == null || paciente.getNombre() == null || paciente.getApellido() == null
                || paciente.getFechaNac() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Faltan datos obligatorios del paciente");
        }
    }

    private boolean buscarPacienteDni(Integer dni) {
        for (Paciente p : pacientes) {
            if (p.getDni().equals(dni)) {
                return true;
            }
        }
        return false;
    }

    private boolean menorEdad(LocalDate fechaNac) {
        int edad = Period.between(fechaNac, LocalDate.now()).getYears();
        return edad < 18;
    }

}
