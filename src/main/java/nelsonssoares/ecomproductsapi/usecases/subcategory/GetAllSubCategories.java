package nelsonssoares.ecomproductsapi.usecases.subcategory;


import lombok.RequiredArgsConstructor;
import nelsonssoares.ecomproductsapi.domain.entities.SubCategoria;
import nelsonssoares.ecomproductsapi.domain.repository.SubCategoriaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllSubCategories {
    private final SubCategoriaRepository subCategoriaRepository;

    public List<SubCategoria> executeFindAllSubCategories(Pageable paginacao) {

        List<SubCategoria> subCategorias = subCategoriaRepository.findAll(paginacao).toList();

        return subCategorias;
    }
}
