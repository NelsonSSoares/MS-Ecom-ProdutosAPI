package nelsonssoares.ecomproductsapi.services.impl;

import nelsonssoares.ecomproductsapi.domain.dtos.SubCategoriaDTO;
import nelsonssoares.ecomproductsapi.domain.entities.SubCategoria;
import nelsonssoares.ecomproductsapi.services.SubCategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class SubCategoryServiceImpl implements SubCategoryService {
    @Override
    public ResponseEntity<Page<SubCategoria>> getAll(Pageable paginacao) {
        return null;
    }

    @Override
    public ResponseEntity<SubCategoria> save(SubCategoriaDTO subDto) {
        return null;
    }

    @Override
    public ResponseEntity<SubCategoria> updateSubCategory(Integer id, SubCategoriaDTO subCatDto) {
        return null;
    }

    @Override
    public ResponseEntity<SubCategoria> delete(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<List<SubCategoria>> findByCategoryById(Integer id) {
        return null;
    }
}
