package nelsonssoares.ecomproductsapi.usecases.subcategory;

import lombok.RequiredArgsConstructor;
import nelsonssoares.ecomproductsapi.domain.dtos.SubCategoriaDTO;
import nelsonssoares.ecomproductsapi.domain.entities.SubCategoria;
import nelsonssoares.ecomproductsapi.domain.repository.SubCategoriaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateSubCategory {

    private final SubCategoriaRepository subCategoriaRepository;

    public SubCategoria executeUpdateSubCategory(Integer id, SubCategoriaDTO subCategoria) {

        SubCategoria subCategoriaAtualizada = subCategoriaRepository.findById(id).orElse(null);

        if(subCategoriaAtualizada != null){
            subCategoriaAtualizada.setNomeSubCategoria(subCategoria.nomeSubCategoria());
            subCategoriaAtualizada.setCategoriaId(subCategoria.categoriaId());
            return subCategoriaRepository.save(subCategoriaAtualizada);
        }
        return null;
    }
}
