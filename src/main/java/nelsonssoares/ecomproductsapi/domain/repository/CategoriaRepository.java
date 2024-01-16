package nelsonssoares.ecomproductsapi.domain.repository;

import nelsonssoares.ecomproductsapi.domain.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
