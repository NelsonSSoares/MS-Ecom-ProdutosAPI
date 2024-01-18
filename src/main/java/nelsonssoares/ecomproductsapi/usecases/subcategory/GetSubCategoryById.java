package nelsonssoares.ecomproductsapi.usecases.subcategory;


import lombok.RequiredArgsConstructor;
import nelsonssoares.ecomproductsapi.domain.entities.SubCategoria;
import nelsonssoares.ecomproductsapi.domain.repository.SubCategoriaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetSubCategoryById {

    private final SubCategoriaRepository subCategoriaRepository;

    public SubCategoria executeFindSubCategoryById(Integer id) {

        return subCategoriaRepository.findById(id).orElse(null);
    }

}
