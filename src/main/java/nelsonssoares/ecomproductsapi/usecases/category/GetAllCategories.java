package nelsonssoares.ecomproductsapi.usecases.category;


import lombok.RequiredArgsConstructor;
import nelsonssoares.ecomproductsapi.domain.entities.Categoria;
import nelsonssoares.ecomproductsapi.domain.repository.CategoriaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAllCategories {

    private final CategoriaRepository categoriaRepository;

    public Page<Categoria> executeFindAllCategories(Pageable paginacao) {
        return categoriaRepository.findAll(paginacao).getContent();
    }

}
