package nelsonssoares.ecomproductsapi.services;

import nelsonssoares.ecomproductsapi.domain.dtos.ProdutoDTO;
import nelsonssoares.ecomproductsapi.domain.entities.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    ResponseEntity<Produto> save(ProdutoDTO prodDto);

    ResponseEntity<Produto> getById(Integer id);

    ResponseEntity<Page<ProdutoDTO>> getAllProducts(Pageable paginacao);

    ResponseEntity<List<ProdutoDTO>> getByName(String nome);

    ResponseEntity<Produto> updateProduct(Integer id, ProdutoDTO prodDto);

    ResponseEntity<Produto> deleteProduct(Integer id);
}
