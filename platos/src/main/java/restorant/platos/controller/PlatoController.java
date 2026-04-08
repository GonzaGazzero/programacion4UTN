package restorant.platos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import restorant.platos.model.Plato;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;



@RestController
@RequestMapping("/platos")
public class PlatoController {
    private List<Plato> platos = new ArrayList<>();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Plato crearPlato(@RequestBody Plato plato) {
        validatePlato(plato);

        if (buscarPorNumeroInterno(plato.getNumeroPlato()) != null) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "El número de plato ya existe: " + plato.getNumeroPlato()
            );
        }

        platos.add(plato);
        return plato;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Plato> obtenerPlatos() {
        return platos;
    }

    @GetMapping("/{numeroPlato}")
    @ResponseStatus(HttpStatus.OK)
    public Plato obtenerPlatoPorNumero(@PathVariable Integer numeroPlato) {
        Plato plato = buscarPorNumeroInterno(numeroPlato);
        if (plato == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "No se encontr[o el plato Nro " + numeroPlato
            );
        }
        return plato;
    }

    private Plato buscarPorNumeroInterno (Integer numeroPlato) {
        for (Plato p : platos) {
            if (p.getNumeroPlato().equals(numeroPlato)) {
                return p;
            }
        }
        return null;
    }

    private void validatePlato(Plato plato) {
        if (plato.getNumeroPlato() == null || plato.getNombre() == null || plato.getPrecio() == null) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,"Número de plato, nombre y precio son obligatorios"
            );
        }
    }
}
