package nelsonssoares.ecomproductsapi.usecases.product;

import lombok.RequiredArgsConstructor;
import nelsonssoares.ecomproductsapi.domain.entities.Produto;
import nelsonssoares.ecomproductsapi.domain.repository.ProdutoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeleteProduct {

    private final ProdutoRepository produtoRepository;

    public void executeDeleteProduct(Integer id) {

        Optional<Produto> produto = produtoRepository.findById(id);
        if(produto.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado");
        }

        produtoRepository.deleteById(id);
    }

}
