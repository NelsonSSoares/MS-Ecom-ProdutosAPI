package nelsonssoares.ecomproductsapi.commons;

import nelsonssoares.ecomproductsapi.domain.dtos.CategoriaDTO;
import nelsonssoares.ecomproductsapi.domain.entities.Categoria;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CategoryConstants {

    public static final Categoria VALID_CATEGORY = new Categoria(1,"Eletronicos");

    public static final CategoriaDTO VALID_CATEGORYDTO = new CategoriaDTO("Eletronicos");

    public static final CategoriaDTO INVALID_CATEGORYDTO = new CategoriaDTO("");

    public static final ResponseEntity<Categoria> VALID_CATEGORY_RESPONSE = ResponseEntity.status(HttpStatus.CREATED).body(VALID_CATEGORY);

    public static final ResponseEntity<Categoria> VALID_CATEGORY_BADREQUEST = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Categoria());


}
