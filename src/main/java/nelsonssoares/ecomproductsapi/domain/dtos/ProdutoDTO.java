package nelsonssoares.ecomproductsapi.domain.dtos;


import java.math.BigDecimal;

public record ProdutoDTO(String nomeProduto, String descricao, Integer subCategoriaId, Integer categoriaId, BigDecimal valorUnitario, Integer sku, Integer quantidadeEstoque){
}

