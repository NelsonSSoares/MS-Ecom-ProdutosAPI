package nelsonssoares.ecomproductsapi.entrypoints;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import nelsonssoares.ecomproductsapi.domain.dtos.ProdutoDTO;
import nelsonssoares.ecomproductsapi.domain.entities.Produto;
import nelsonssoares.ecomproductsapi.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static nelsonssoares.ecomproductsapi.commons.constants.ControllersConstants.*;

@Tag(name=API_TAG, description=API_DESCRIPTION)
@RequiredArgsConstructor
@RestController
@RequestMapping(value = API_BASE_URL, produces = API_PRODUCES)
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "Buscar todos os produtos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado!"),
            @ApiResponse(responseCode = "403", description = "Não Autorizado!"),
            @ApiResponse(responseCode = "500", description = "Erro ao buscar produto!")
    })
    @GetMapping
    public ResponseEntity<Page<ProdutoDTO>> getAll(Pageable paginacao){

        return productService.getAllProducts(paginacao);
    }

    @Operation(summary = "Busca produto cadastrado por ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado!"),
            @ApiResponse(responseCode = "403", description = "Não Autorizado!"),
            @ApiResponse(responseCode = "500", description = "Erro ao buscar Produto!")
    })
    @GetMapping(ID)
    public ResponseEntity<Produto> findById(@PathVariable("id") Integer id){
        return productService.getById(id);
    }

    @Operation(summary = "Busca produtos cadastrados por Nome", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso!"),
            @ApiResponse(responseCode = "403", description = "Não Autorizado!"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado!"),
            @ApiResponse(responseCode = "500", description = "Erro ao buscar produto!")
    })
    @GetMapping(NAME)
    public ResponseEntity<List<ProdutoDTO>> findByName(@PathVariable("name") String nome){
        return productService.getByName(nome);
    }

    @Operation(summary = "Metodo para cadastrar novo produto", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuário cadastrado com sucesso!!"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos!"),
            @ApiResponse(responseCode = "401", description = "Usuário não autenticado!"),
            @ApiResponse(responseCode = "403", description = "Não Autorizado!"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválido"),
            @ApiResponse(responseCode = "500", description = "Erro ao atualizar produto!"),
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Produto> save(@RequestBody @Valid ProdutoDTO prodDto){
        return productService.save(prodDto);
    }


    @Operation(summary = "Metodo para atualizar produto existente", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Produto atualizado com sucesso!!"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos!"),
            @ApiResponse(responseCode = "401", description = "Usuário não autenticado!"),
            @ApiResponse(responseCode = "403", description = "Não Autorizado!"),
            @ApiResponse(responseCode = "404", description = "Não encontrado!"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválido"),
            @ApiResponse(responseCode = "500", description = "Erro ao atualizar produto!"),
    })
    @PutMapping(ID)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Produto> update(@PathVariable("id") Integer id, @RequestBody @Valid ProdutoDTO prodDto){
        return productService.updateProduct(id, prodDto);
    }

    @Operation(summary = "Metodo para excluir usuário existente", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Produto excluido com sucesso!!"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos!"),
            @ApiResponse(responseCode = "403", description = "Não Autorizado!"),
            @ApiResponse(responseCode = "404", description = "Não encontrado!"),
            @ApiResponse(responseCode = "401", description = "Usuário não autenticado!"),
    })
    @DeleteMapping(ID)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Produto> delete(@PathVariable("id") Integer id){
        return productService.deleteProduct(id);
    }

}
