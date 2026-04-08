package restorant.platos.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Plato {

    private Integer numeroPlato;
    private String nombre;
    private Double precio;
    private String descripcion;

    public Plato() {
    }
    

    public Plato(Integer numeroPlato, String nombre, Double precio, String descripcion) {
        this.numeroPlato = numeroPlato;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }
}
