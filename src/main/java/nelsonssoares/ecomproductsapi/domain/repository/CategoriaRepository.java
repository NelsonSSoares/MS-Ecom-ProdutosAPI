package nelsonssoares.ecomproductsapi.domain.repository;

import nelsonssoares.ecomproductsapi.domain.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
