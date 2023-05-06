package facundo.dalessio.payGoal.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Builder
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class ProductoRequest {
    @NonNull
    @NotEmpty(message = "El nombre no puede ser null")
    @NotBlank(message = "El nombre no puede estar en blanco")
    private String nombre;

    @NonNull
    @NotEmpty(message = "La descripcion no puede ser null")
    @NotBlank(message = "La descripcion no puede estar en blanco")
    private String descripcion;

    @NonNull
    private Float precio;

    @NonNull
    private Integer cantidad;
}
