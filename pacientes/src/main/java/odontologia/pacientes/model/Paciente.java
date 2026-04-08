package odontologia.pacientes.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Paciente {
    
    private Long id;
    private Integer dni;
    private String nombre;
    private String apellido;
    private LocalDate fechaNac;

    public Paciente() {
    }


    public Paciente(Long id, Integer dni, String nombre, String apellido, LocalDate fechaNac) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
    }
}
