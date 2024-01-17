package nelsonssoares.ecomproductsapi.entrypoints;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import nelsonssoares.ecomproductsapi.domain.dtos.CategoriaDTO;
import nelsonssoares.ecomproductsapi.domain.entities.Categoria;
import nelsonssoares.ecomproductsapi.services.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static nelsonssoares.ecomproductsapi.commons.constants.ControllersConstants.*;

@Tag(name = API_TAG, description = API_DESCRIPTION)
@RequiredArgsConstructor
@RestController
@RequestMapping(value = API_BASE_URL, produces = API_PRODUCES)
public class CategoryController {

    private final CategoryService categoryService;

    @Operation(summary = "Metodo para cadastrar nova Categoria", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Categoria cadastrada com sucesso!!"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos!"),
            @ApiResponse(responseCode = "401", description = "Usuário não autenticado!"),
            @ApiResponse(responseCode = "403", description = "Não Autorizado!"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválido"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor!"),
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Categoria> save(@RequestBody @Valid CategoriaDTO catDto){
        return categoryService.save(catDto);
    }



    @Operation(summary = "Metodo para buscar todas as categorias", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso!!"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos!"),
            @ApiResponse(responseCode = "401", description = "Usuário não autenticado!"),
            @ApiResponse(responseCode = "403", description = "Não Autorizado!"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválido"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor!"),
    })
    @GetMapping
    public ResponseEntity<Page<Categoria>> getAll(Pageable paginacao){
        return categoryService.listAllCategories(paginacao);
    }



    @Operation(summary = "Metodo para buscar categoria por ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "busca realizada com sucesso!!"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos!"),
            @ApiResponse(responseCode = "401", description = "Usuário não autenticado!"),
            @ApiResponse(responseCode = "403", description = "Não Autorizado!"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválido"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor!"),
    })
    @GetMapping(CATEGORY_ID)
    public ResponseEntity<Categoria> getById(@PathVariable("id") Long id){
        return categoryService.getCategoryById(id);
    }



    @Operation(summary = "Metodo para Atualizar categoria", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Categoria atualizada com sucesso!!"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos!"),
            @ApiResponse(responseCode = "401", description = "Usuário não autenticado!"),
            @ApiResponse(responseCode = "403", description = "Não Autorizado!"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválido"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor!"),
    })
    @PutMapping(CATEGORY_ID)
    public ResponseEntity<CategoriaDTO> updateCategoria(@PathVariable("id") Long id, @RequestBody @Valid CategoriaDTO categoria){

        return categoryService.updateCategory(id, categoria);
    }


    @Operation(summary = "Metodo para deletar categoria", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Categoria deletada com sucesso!!"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos!"),
            @ApiResponse(responseCode = "401", description = "Usuário não autenticado!"),
            @ApiResponse(responseCode = "403", description = "Não Autorizado!"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválido"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor!"),
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Categoria> deleteCategoria(Long id) {

        return  categoryService.delete(id);
    }



}
