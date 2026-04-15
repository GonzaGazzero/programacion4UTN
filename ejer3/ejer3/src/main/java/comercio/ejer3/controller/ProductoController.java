package comercio.ejer3.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import comercio.ejer3.dto.ProductoRequestDTO;
import comercio.ejer3.dto.ProductoResponseDTO;
import comercio.ejer3.service.ProductoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public ResponseEntity<ProductoResponseDTO> crearProducto(
            @Valid @RequestBody ProductoRequestDTO dto) {

        ProductoResponseDTO response = productoService.crearProducto(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Location", "/api/productos/" + response.getId())
                .body(response);
    }
}
