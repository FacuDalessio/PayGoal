package facundo.dalessio.payGoal.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.sql.Timestamp;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Table(name = "productos")
@SQLDelete(sql= "UPDATE productos SET soft_delete = true WHERE producto_id=?")
@Where(clause = "soft_delete=false")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producto_id")
    private Long id;

    @NonNull
    @NotEmpty(message = "El nombre no puede ser null")
    @NotBlank(message = "El nombre no puede estar en blanco")
    @Column(nullable = false)
    private String nombre;

    @NonNull
    @NotEmpty(message = "La descripcion no puede ser null")
    @NotBlank(message = "La descripcion no puede estar en blanco")
    @Column(nullable = false)
    private String descripcion;

    @NonNull
    @Column(nullable = false)
    private Float precio;

    @NonNull
    @Column(nullable = false)
    private Integer cantidad;

    @CreationTimestamp
    private Timestamp timestamp;

    @Column(name = "soft_delete")
    @Builder.Default
    private boolean deleted = Boolean.FALSE;
}
