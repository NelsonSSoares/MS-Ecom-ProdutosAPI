package nelsonssoares.ecomproductsapi.services.impl;

import lombok.RequiredArgsConstructor;
import nelsonssoares.ecomproductsapi.domain.dtos.ProdutoDTO;
import nelsonssoares.ecomproductsapi.domain.entities.Produto;
import nelsonssoares.ecomproductsapi.services.ProductService;
import nelsonssoares.ecomproductsapi.usecases.product.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

        private final SaveProduct saveProduct;
        private final GetProductById getProductById;
        private final GetAllProducts getAllProducts;
        private final GetProductsByName getProductsByName;
        private final UpdateProduct updateProduct;
        private final DeleteProduct deleteProduct;


        @Override
        public ResponseEntity<Produto> save(ProdutoDTO prodDto) {

            Produto produto = saveProduct.executeSaveProduct(prodDto);

            return ResponseEntity.ok(produto);
        }

        @Override
        public ResponseEntity<Produto> getById(Integer id) {

            Produto produto = getProductById.executeFindProductById(id);

            return produto != null ? ResponseEntity.ok(produto) : ResponseEntity.notFound().build();
        }

        @Override
        public ResponseEntity<Page<ProdutoDTO>> getAllProducts(Pageable paginacao) {

            Page<ProdutoDTO> produtos = getAllProducts.executeGetAllProducts(paginacao);

            return produtos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(produtos);
        }

        @Override
        public ResponseEntity<List<ProdutoDTO>> getByName(String nome) {

            List<ProdutoDTO> produtos = getProductsByName.executeGetProductsByName(nome);

            return null;
        }

        @Override
        public ResponseEntity<Produto> updateProduct(Integer id, ProdutoDTO prodDto) {

            Produto produto = updateProduct.executeUpadteProduct(id, prodDto);

            return produto != null ? ResponseEntity.ok(produto) : ResponseEntity.notFound().build();
        }

        @Override
        public ResponseEntity<Produto> deleteProduct(Integer id) {

            deleteProduct.executeDeleteProduct(id);

            return ResponseEntity.noContent().build();
        }
}
