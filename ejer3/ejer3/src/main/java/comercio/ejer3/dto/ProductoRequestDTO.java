package comercio.ejer3.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoRequestDTO {
    @NotBlank(message = "{producto.nombre.notblank}")
    @Size(min = 3, max = 100, message = "{producto.nombre.size}")
    private String nombre;

    @Size(max = 500, message = "{producto.descripcion.size}")
    private String descripcion;

    @NotNull(message = "{producto.precio.notnull}")
    @Positive(message = "{producto.precio.positive}")
    @DecimalMax(value = "99999.99", message = "{producto.precio.decimalmax}")
    private BigDecimal precio;

    @NotNull(message = "{producto.stock.notnull}")
    @Min(value = 0, message = "{producto.stock.min}")
    @Max(value = 9999, message = "{producto.stock.max}")
    private Integer stock;

    @NotBlank(message = "{producto.emailproveedor.notblank}")
    @Email(message = "{producto.emailproveedor.email}")
    private String emailProveedor;

    @Future(message = "{producto.fechavencimiento.future}")
    private LocalDate fechaVencimiento;

    @Pattern(regexp = "[A-Z]{3}-\\d{4}", message = "{producto.codigosku.pattern}")
    private String codigoSKU;
}
