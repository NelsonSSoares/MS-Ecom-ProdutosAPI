package nelsonssoares.ecomproductsapi.domain.dtos;

public record ProdutoDTO(String nomeProduto, String descricao, Integer subCategoriaId, Integer categoriaId, Double preco,Integer SKU) {
}
