package nelsonssoares.ecomproductsapi.usecases.product;

import lombok.RequiredArgsConstructor;
import nelsonssoares.ecomproductsapi.domain.entities.Produto;
import nelsonssoares.ecomproductsapi.domain.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetProductById {

    private final ProdutoRepository produtoRepository;

    public Produto executeFindProductById(Integer id) {
        return produtoRepository.findById(id).orElse(null);
    }
}
