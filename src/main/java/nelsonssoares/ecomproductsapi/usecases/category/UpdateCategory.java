package nelsonssoares.ecomproductsapi.usecases.category;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import nelsonssoares.ecomproductsapi.domain.dtos.CategoriaDTO;
import nelsonssoares.ecomproductsapi.domain.entities.Categoria;
import nelsonssoares.ecomproductsapi.domain.repository.CategoriaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateCategory {

    private final CategoriaRepository categoriaRepository;
    private final ObjectMapper objectMapper;

    @Transactional
    public CategoriaDTO executeUpdateCategory(Long id, CategoriaDTO nomeCategoria) {

        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if(categoria.isPresent()){
            Categoria categoriaAtualizada = categoria.get();
            categoriaAtualizada.setNomeCategoria(nomeCategoria.nomeCategoria());
            categoriaRepository.save(categoriaAtualizada);
            return objectMapper.convertValue(categoriaAtualizada, CategoriaDTO.class);
        }

        return null;
    }

}
