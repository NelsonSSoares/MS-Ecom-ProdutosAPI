package nelsonssoares.ecomproductsapi.usecases.subcategory;

import lombok.RequiredArgsConstructor;
import nelsonssoares.ecomproductsapi.domain.dtos.SubCategoriaDTO;
import nelsonssoares.ecomproductsapi.domain.entities.SubCategoria;
import nelsonssoares.ecomproductsapi.domain.repository.SubCategoriaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateSubCategory {

    private final SubCategoriaRepository subCategoriaRepository;

    @Transactional
    public SubCategoria executeUpdateSubCategory(Integer id, SubCategoriaDTO subCategoria) {

       Optional<SubCategoria> subCategoriaOptional = subCategoriaRepository.findById(id);

         if(subCategoriaOptional.isEmpty()){
              throw new ResponseStatusException(HttpStatus.NOT_FOUND, "SubCategoria não encontrada");
         }

            SubCategoria subCategoriaAtualizada = subCategoriaOptional.get();
            subCategoriaAtualizada.setId(id);
            subCategoriaAtualizada.setNomeSubCategoria(subCategoria.nomeSubCategoria());
            subCategoriaAtualizada.setDescricao(subCategoria.descricao());

            subCategoriaRepository.save(subCategoriaAtualizada);
            return subCategoriaAtualizada;

    }
}
