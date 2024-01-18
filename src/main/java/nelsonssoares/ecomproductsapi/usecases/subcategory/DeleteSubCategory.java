package nelsonssoares.ecomproductsapi.usecases.subcategory;

import lombok.RequiredArgsConstructor;
import nelsonssoares.ecomproductsapi.domain.repository.SubCategoriaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteSubCategory {

    private final SubCategoriaRepository subCategoriaRepository;

    @Transactional
    public boolean executeDeleteSubCategory(Integer id) {

        subCategoriaRepository.deleteById(id);
        return true;
    }
}
