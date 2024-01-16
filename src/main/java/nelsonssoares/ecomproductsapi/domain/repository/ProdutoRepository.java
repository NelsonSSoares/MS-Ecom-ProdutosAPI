package nelsonssoares.ecomproductsapi.domain.repository;

import nelsonssoares.ecomproductsapi.domain.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
}
