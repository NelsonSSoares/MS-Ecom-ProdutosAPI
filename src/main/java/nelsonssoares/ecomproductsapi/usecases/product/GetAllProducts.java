package nelsonssoares.ecomproductsapi.usecases.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import nelsonssoares.ecomproductsapi.domain.dtos.ProdutoDTO;
import nelsonssoares.ecomproductsapi.domain.entities.Produto;
import nelsonssoares.ecomproductsapi.domain.repository.ProdutoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllProducts {

    private final ProdutoRepository produtoRepository;
    private final ObjectMapper objectMapper;

    public Page<ProdutoDTO> executeGetAllProducts(Pageable pageable) {
        Page<Produto> produtos = produtoRepository.findAll(pageable);
        return produtos.map(produto -> objectMapper.convertValue(produto, ProdutoDTO.class));
    }
}
