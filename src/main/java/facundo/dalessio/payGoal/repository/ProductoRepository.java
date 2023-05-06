package facundo.dalessio.payGoal.repository;

import facundo.dalessio.payGoal.models.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {

    Optional<ProductoEntity> findByNombre(String nombre);
}
