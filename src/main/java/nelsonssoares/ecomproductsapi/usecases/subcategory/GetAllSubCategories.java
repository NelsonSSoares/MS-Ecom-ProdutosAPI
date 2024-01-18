package nelsonssoares.ecomproductsapi.usecases.subcategory;


import lombok.RequiredArgsConstructor;
import nelsonssoares.ecomproductsapi.domain.entities.SubCategoria;
import nelsonssoares.ecomproductsapi.domain.repository.SubCategoriaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllSubCategories {
    private final SubCategoriaRepository subCategoriaRepository;

    public Page<SubCategoria> executeFindAllSubCategories(Pageable paginacao) {

        Page<SubCategoria> subCategorias = subCategoriaRepository.findAll(paginacao);

        return subCategorias;
    }


}
