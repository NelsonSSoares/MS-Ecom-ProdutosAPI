package nelsonssoares.ecomproductsapi.services;

import nelsonssoares.ecomproductsapi.domain.dtos.SubCategoriaDTO;
import nelsonssoares.ecomproductsapi.domain.entities.SubCategoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SubCategoryService {

    ResponseEntity<Page<SubCategoria>> getAll(Pageable paginacao);
    ResponseEntity<SubCategoria> save(SubCategoriaDTO subDto);
    ResponseEntity<SubCategoria> updateSubCategory(Integer id, SubCategoriaDTO subCatDto);
    ResponseEntity<SubCategoria> delete(Integer id);
    ResponseEntity<SubCategoria> findBySubCategoryById(Integer id);


}
