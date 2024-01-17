package nelsonssoares.ecomproductsapi.usecases.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import nelsonssoares.ecomproductsapi.domain.dtos.ProdutoDTO;
import nelsonssoares.ecomproductsapi.domain.entities.Produto;
import nelsonssoares.ecomproductsapi.domain.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class SaveProduct {

    private final ProdutoRepository produtoRepository;
    private final ObjectMapper objectMapper;

    @Transactional
    public Produto executeSaveProduct(ProdutoDTO produtoDto) {
        return null;
    }


}
