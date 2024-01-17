package nelsonssoares.ecomproductsapi.services.impl;

import lombok.RequiredArgsConstructor;
import nelsonssoares.ecomproductsapi.domain.dtos.CategoriaDTO;
import nelsonssoares.ecomproductsapi.domain.entities.Categoria;
import nelsonssoares.ecomproductsapi.services.CategoryService;
import nelsonssoares.ecomproductsapi.usecases.category.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final SaveCategory saveCategory;
    private final GetCategoryById getCategoryById;
    private final GetAllCategories getAllCategories;
    private final UpdateCategory updateCategory;
    private final DeleteCategory deleteCategory;

    @Override
    public ResponseEntity<Categoria> save(CategoriaDTO catDto) {

        Categoria categoria = saveCategory.executeSaveCategory(catDto);

        return ResponseEntity.ok(categoria);
    }

    @Override
    public ResponseEntity<Categoria> getCategoryById(Long id) {

        Categoria categoria = getCategoryById.executeFindCategoryById(id);

        return categoria != null ? ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Page<Categoria>> listAllCategories(Pageable paginacao) {
        Page<Categoria> categorias = getAllCategories.executeFindAllCategories(paginacao);
        return ResponseEntity.ok(categorias);
    }

    @Override
    public ResponseEntity<CategoriaDTO> updateCategory(Long id, CategoriaDTO categoria) {

        CategoriaDTO categoriaAtualizada = updateCategory.executeUpdateCategory(id, categoria);

        return categoriaAtualizada != null ? ResponseEntity.ok(categoriaAtualizada) : ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Categoria> delete(Long id) {

        deleteCategory.executeDeleteCategory(id);

        return ResponseEntity.noContent().build();
    }
}
