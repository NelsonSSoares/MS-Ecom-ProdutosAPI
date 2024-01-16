package nelsonssoares.ecomproductsapi.services;

import nelsonssoares.ecomproductsapi.domain.dtos.CategoriaDTO;
import nelsonssoares.ecomproductsapi.domain.entities.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface CategoryService {
    ResponseEntity<CategoriaDTO> salvar(CategoriaDTO catDto);

    ResponseEntity<Categoria> buscarPorCategoriaId(Integer id);

    ResponseEntity<Page<Categoria>> listarTodasCategorias(Pageable paginacao);

    ResponseEntity<CategoriaDTO> alterarCategoria(Integer id, CategoriaDTO categoria);

    ResponseEntity<Categoria> excluir(Integer id);
}
