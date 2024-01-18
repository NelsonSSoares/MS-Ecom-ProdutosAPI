package nelsonssoares.ecomproductsapi.usecases.subcategory;

import lombok.RequiredArgsConstructor;
import nelsonssoares.ecomproductsapi.domain.repository.SubCategoriaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteSubCategory {

    private final SubCategoriaRepository subCategoriaRepository;

    public boolean executeDeleteSubCategory(Integer id) {

        subCategoriaRepository.deleteById(id);
        return true;
    }
}
