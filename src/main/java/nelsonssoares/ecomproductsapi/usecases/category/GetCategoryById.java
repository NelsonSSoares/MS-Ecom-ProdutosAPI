package nelsonssoares.ecomproductsapi.usecases.category;

import lombok.RequiredArgsConstructor;
import nelsonssoares.ecomproductsapi.domain.entities.Categoria;
import nelsonssoares.ecomproductsapi.domain.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetCategoryById {

    private final CategoriaRepository categoriaRepository;

    public Categoria executeFindCategoryById(Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.orElse(null);
    }

}
