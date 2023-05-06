package facundo.dalessio.payGoal.models.response;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class ProductoResponse {

    private String nombre;
    private String descripcion;
    private Float precio;
    private Integer cantidad;

}
