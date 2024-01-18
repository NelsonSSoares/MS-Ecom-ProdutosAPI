package nelsonssoares.ecomproductsapi.services.impl;

import lombok.RequiredArgsConstructor;
import nelsonssoares.ecomproductsapi.domain.dtos.SubCategoriaDTO;
import nelsonssoares.ecomproductsapi.domain.entities.SubCategoria;
import nelsonssoares.ecomproductsapi.services.SubCategoryService;
import nelsonssoares.ecomproductsapi.usecases.subcategory.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubCategoryServiceImpl implements SubCategoryService {

    private final SaveSubCategory saveSubCategory;
    private final UpdateSubCategory updateSubCategory;
    private final DeleteSubCategory deleteSubCategory;
    private final GetAllSubCategories getAllSubCategories;
    private final GetSubCategoryById getSubCategoryById;


    @Override
    public ResponseEntity<Page<SubCategoria>> getAll(Pageable paginacao) {
        Page<SubCategoria> subCategorias = getAllSubCategories.executeFindAllSubCategories(paginacao);
        return ResponseEntity.ok().body(subCategorias);
    }

    @Override
    public ResponseEntity<SubCategoria> save(SubCategoriaDTO subDto) {
        SubCategoria subCategoria = saveSubCategory.executeSaveSubCategory(subDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(subCategoria);
    }

    @Override
    public ResponseEntity<SubCategoria> updateSubCategory(Integer id, SubCategoriaDTO subCatDto) {

        SubCategoria subCategoria = updateSubCategory.executeUpdateSubCategory(id, subCatDto);
        return subCategoria != null ? ResponseEntity.ok().body(subCategoria) : ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<SubCategoria> delete(Integer id) {

        return deleteSubCategory.executeDeleteSubCategory(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<SubCategoria> findBySubCategoryById(Integer id) {

        return getSubCategoryById.executeFindSubCategoryById(id) != null ? ResponseEntity.ok().body(getSubCategoryById.executeFindSubCategoryById(id)) : ResponseEntity.notFound().build();
    }
}
