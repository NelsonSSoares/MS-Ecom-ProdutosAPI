package nelsonssoares.ecomproductsapi.usecases.category;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import nelsonssoares.ecomproductsapi.domain.dtos.CategoriaDTO;
import nelsonssoares.ecomproductsapi.domain.entities.Categoria;
import nelsonssoares.ecomproductsapi.domain.repository.CategoriaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaveCategory {

    private final CategoriaRepository categoryRepository;
    private final ObjectMapper objectMapper;

    @Transactional
    public Categoria executeSaveCategory(CategoriaDTO categoriaDto) {

        Categoria category = objectMapper.convertValue(categoriaDto, Categoria.class);

        List<Categoria> todasCategorias = categoryRepository.findAll();

        for (Categoria categoria : todasCategorias) {

            if (categoria.getNomeCategoria().toUpperCase().equals(category.getNomeCategoria().toUpperCase())) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Categoria já cadastrada!");
            }
        }

        return categoryRepository.save(category);
    }
}
