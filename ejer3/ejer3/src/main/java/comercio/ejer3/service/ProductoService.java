package comercio.ejer3.service;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import comercio.ejer3.dto.ProductoRequestDTO;
import comercio.ejer3.dto.ProductoResponseDTO;
import comercio.ejer3.model.Producto;

@Service
public class ProductoService {

    private final AtomicLong idGenerator = new AtomicLong(1);

    public ProductoResponseDTO crearProducto(ProductoRequestDTO dto) {

        Producto producto = new Producto();
        producto.setId(idGenerator.getAndIncrement());
        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());
        producto.setCodigoSKU(dto.getCodigoSKU());
        producto.setFechaRegistro(LocalDateTime.now());

        ProductoResponseDTO response = new ProductoResponseDTO();
        response.setId(producto.getId());
        response.setNombre(producto.getNombre());
        response.setPrecio(producto.getPrecio());
        response.setStock(producto.getStock());
        response.setCodigoSKU(producto.getCodigoSKU());
        response.setFechaRegistro(producto.getFechaRegistro());

        response.setEstadoStock(calcularEstadoStock(producto.getStock()));

        return response;
    }

    private String calcularEstadoStock(Integer stock) {
        if (stock == 0) return "SIN STOCK";
        if (stock < 10) return "STOCK BAJO";
        return "DISPONIBLE";
    }
}

