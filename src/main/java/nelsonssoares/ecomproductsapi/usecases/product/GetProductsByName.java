package nelsonssoares.ecomproductsapi.usecases.product;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import nelsonssoares.ecomproductsapi.domain.dtos.ProdutoDTO;
import nelsonssoares.ecomproductsapi.domain.entities.Produto;
import nelsonssoares.ecomproductsapi.domain.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetProductsByName {

    private final ProdutoRepository produtoRepository;
    private final ObjectMapper objectMapper;

    public List<ProdutoDTO> executeGetProductsByName(String name) {

        List<Produto> produto = produtoRepository.findByName(name);
        List<ProdutoDTO> produtoDto = objectMapper.convertValue(produto, new TypeReference<List<ProdutoDTO>>() {});

        return produtoDto;
    }


}
