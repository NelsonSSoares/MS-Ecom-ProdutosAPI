package nelsonssoares.ecomproductsapi.usecases.subcategory;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import nelsonssoares.ecomproductsapi.domain.dtos.SubCategoriaDTO;
import nelsonssoares.ecomproductsapi.domain.entities.Categoria;
import nelsonssoares.ecomproductsapi.domain.entities.SubCategoria;
import nelsonssoares.ecomproductsapi.domain.repository.SubCategoriaRepository;
import nelsonssoares.ecomproductsapi.usecases.category.GetCategoryById;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SaveSubCategory {
    private final SubCategoriaRepository subCategoriaRepository;
    private final GetCategoryById getCategoryById;
    private final ObjectMapper objectMapper;
    public SubCategoria executeSaveSubCategory(SubCategoriaDTO subCategoriaDto) {


        SubCategoria subCategoria = objectMapper.convertValue(subCategoriaDto, SubCategoria.class);

        Optional<Categoria> categoria = Optional.ofNullable(getCategoryById.executeFindCategoryById(subCategoria.getCategoriaId()));

        if(categoria.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada!");
        }


        return subCategoriaRepository.save(subCategoria);
    }
}
