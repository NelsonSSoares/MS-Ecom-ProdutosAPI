package nelsonssoares.ecomproductsapi.domain.repository;

import nelsonssoares.ecomproductsapi.domain.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
    @Query(value = "select * from produto p where p.nome_produto like :nome%", nativeQuery = true)
    List<Produto> findByName(@Param("nome") String nome);
}

