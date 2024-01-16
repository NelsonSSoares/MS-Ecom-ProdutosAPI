package nelsonssoares.ecomproductsapi.services;

import nelsonssoares.ecomproductsapi.domain.dtos.ProdutoDTO;
import nelsonssoares.ecomproductsapi.domain.entities.Produto;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    ResponseEntity<Produto> salvar(ProdutoDTO prodDto);

    ResponseEntity<Produto> buscarPorId(Integer id);

    ResponseEntity<List<ProdutoDTO>> buscarTodos(Pageable paginacao);

    ResponseEntity<List<ProdutoDTO>> buscarPorNome(String nome);

    ResponseEntity<Produto> atualizarProduto(Integer id, ProdutoDTO prodDto);

    ResponseEntity<Produto> deletarProduto(Integer id);
}
