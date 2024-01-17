package nelsonssoares.ecomproductsapi.services.impl;

import lombok.RequiredArgsConstructor;
import nelsonssoares.ecomproductsapi.domain.dtos.ProdutoDTO;
import nelsonssoares.ecomproductsapi.domain.entities.Produto;
import nelsonssoares.ecomproductsapi.services.ProductService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

        @Override
        public ResponseEntity<Produto> save(ProdutoDTO prodDto) {
            return null;
        }

        @Override
        public ResponseEntity<Produto> getById(Integer id) {
            return null;
        }

        @Override
        public ResponseEntity<List<ProdutoDTO>> getAllProducts(Pageable paginacao) {
            return null;
        }

        @Override
        public ResponseEntity<List<ProdutoDTO>> getByName(String nome) {
            return null;
        }

        @Override
        public ResponseEntity<Produto> updateProduct(Integer id, ProdutoDTO prodDto) {
            return null;
        }

        @Override
        public ResponseEntity<Produto> deleteProduct(Integer id) {
            return null;
        }
}
