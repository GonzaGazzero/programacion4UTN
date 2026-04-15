package comercio.ejer3.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoResponseDTO {
    private Long id;
    private String nombre;
    private BigDecimal precio;
    private Integer stock;
    private String codigoSKU;
    private LocalDateTime fechaRegistro;
    private String estadoStock;
}
