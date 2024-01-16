package nelsonssoares.ecomproductsapi.domain.repository;

import nelsonssoares.ecomproductsapi.domain.entities.SubCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoriaRepository extends JpaRepository<SubCategoria, Long> {
}
