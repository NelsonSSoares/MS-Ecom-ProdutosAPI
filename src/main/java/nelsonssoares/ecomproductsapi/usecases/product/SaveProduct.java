package nelsonssoares.ecomproductsapi.usecases.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import nelsonssoares.ecomproductsapi.domain.dtos.ProdutoDTO;
import nelsonssoares.ecomproductsapi.domain.entities.Categoria;
import nelsonssoares.ecomproductsapi.domain.entities.Produto;
import nelsonssoares.ecomproductsapi.domain.entities.SubCategoria;
import nelsonssoares.ecomproductsapi.domain.repository.ProdutoRepository;
import nelsonssoares.ecomproductsapi.usecases.category.GetCategoryById;
import nelsonssoares.ecomproductsapi.usecases.subcategory.GetSubCategoryById;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SaveProduct {

    private final ProdutoRepository produtoRepository;
    private final GetCategoryById getCategoryById;
    private final GetSubCategoryById getSubCategoryById;
    private final ObjectMapper objectMapper;

    @Transactional
    public Produto executeSaveProduct(ProdutoDTO produtoDto) {
        Optional<Categoria> categoria = Optional.ofNullable(getCategoryById.executeFindCategoryById(produtoDto.categoriaId()));
        if (categoria.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada");
        }

        Optional<SubCategoria> subCategoria = Optional.ofNullable(getSubCategoryById.executeFindSubCategoryById(produtoDto.subCategoriaId()));
        if (subCategoria.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "SubCategoria não encontrada");
        }

        Produto produto = objectMapper.convertValue(produtoDto, Produto.class);
        produto.setDataCadastro(LocalDate.now());
        produtoRepository.save(produto);

        return produto;
    }


}
