package nelsonssoares.ecomproductsapi.services;

import nelsonssoares.ecomproductsapi.domain.dtos.CategoriaDTO;
import nelsonssoares.ecomproductsapi.domain.entities.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface CategoryService {
    ResponseEntity<Categoria> save(CategoriaDTO catDto);

    ResponseEntity<Categoria> getCategoryById(Long id);

    ResponseEntity<Page<Categoria>> listAllCategories(Pageable paginacao);

    ResponseEntity<CategoriaDTO> updateCategory(Long id, CategoriaDTO categoria);

    ResponseEntity<Categoria> delete(Long id);
}
