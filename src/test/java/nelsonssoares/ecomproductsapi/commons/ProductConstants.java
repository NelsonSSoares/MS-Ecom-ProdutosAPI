package nelsonssoares.ecomproductsapi.commons;

import nelsonssoares.ecomproductsapi.domain.dtos.ProdutoDTO;
import nelsonssoares.ecomproductsapi.domain.entities.Produto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProductConstants {

    public static final ProdutoDTO VALID_PRODUCTDTO = new ProdutoDTO("Samsung A34", "8GB RAM 256SSD", 1, 1);

    public static final Produto VALID_PRODUCT = new Produto(1,1,1,"Samsung A34", "8GB RAM 256SSD",12345, LocalDate.now(), BigDecimal.valueOf(1900), 20 );

    public static final Produto INVALID_PRODUCT = new Produto(null,null,1,"", "8GB RAM 256SSD",12345, LocalDate.now(), BigDecimal.valueOf(1900), 20 );

    public static final ProdutoDTO INVALID_PRODUCTDTO = new ProdutoDTO("", "", 1, 1);

    //REPONSES
    public static final ResponseEntity<ProdutoDTO> VALID_PRODUCTDTO_RESPONSE = ResponseEntity.ok(VALID_PRODUCTDTO);

    public static final ResponseEntity<Produto> VALID_PRODUCT_RESPONSE = ResponseEntity.status(HttpStatus.CREATED).body(VALID_PRODUCT);

    public static final ResponseEntity<Produto> INVALID_PRODUCT_BADREQUESTRESPONSE = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(INVALID_PRODUCT);
}
