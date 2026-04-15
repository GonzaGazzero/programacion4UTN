package comercio.ejer3.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Producto {

	private Long id;
	private String nombre;
	private String descripcion;
	private BigDecimal precio;
	private Integer stock;
	private String emailProveedor;
	private LocalDate fechaVencimiento;
	private String codigoSKU;
	private LocalDateTime fechaRegistro;
}
