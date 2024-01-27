package nelsonssoares.ecomproductsapi.entrypoints;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import static nelsonssoares.ecomproductsapi.commons.constants.ControllersConstants.*;

import nelsonssoares.ecomproductsapi.domain.dtos.SubCategoriaDTO;
import nelsonssoares.ecomproductsapi.domain.entities.SubCategoria;
import nelsonssoares.ecomproductsapi.services.SubCategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = API_TAG_SUBCATEGORY, description = API_DESCRIPTION)
@RequiredArgsConstructor
@RestController
@RequestMapping(value = SUBCATEGORY, produces = API_PRODUCES)
public class SubCategoryController {


    private final SubCategoryService subCategoryService;

    @Operation(summary = "Metodo para buscar todas subcategorias", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso!!"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos!"),
            @ApiResponse(responseCode = "401", description = "Usuário não autenticado!"),
            @ApiResponse(responseCode = "403", description = "Não Autorizado!"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválido"),
            @ApiResponse(responseCode = "500", description = "Erro ao atualizar usuário!"),
    })
    @GetMapping
    public ResponseEntity<Page<SubCategoria>> getListAllSubCategories(Pageable paginacao) {
        return subCategoryService.getAll(paginacao);
    }



    @Operation(summary = "Metodo para buscar subcategoria por ID de categoria", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuário cadstrado com sucesso!!"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos!"),
            @ApiResponse(responseCode = "401", description = "Usuário não autenticado!"),
            @ApiResponse(responseCode = "403", description = "Não Autorizado!"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválido"),
            @ApiResponse(responseCode = "500", description = "Erro ao atualizar usuário!"),
    })
    @GetMapping("/{id}")
    public ResponseEntity<SubCategoria> findBySubCategoriaId(@PathVariable("id") Integer id) {
        return subCategoryService.findBySubCategoryById(id);
    }



    @Operation(summary = "Metodo para cadastrar nova subcategoria", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Subcategoria cadastrada com sucesso!!"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos!"),
            @ApiResponse(responseCode = "401", description = "Usuário não autenticado!"),
            @ApiResponse(responseCode = "403", description = "Não Autorizado!"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválido"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor!"),
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<SubCategoria> save(@RequestBody @Valid SubCategoriaDTO subDto) {
        return subCategoryService.save(subDto);
    }



    @Operation(summary = "Metodo para atualizar subcategoria", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Subcategoria atualizada com sucesso!!"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos!"),
            @ApiResponse(responseCode = "401", description = "Usuário não autenticado!"),
            @ApiResponse(responseCode = "403", description = "Não Autorizado!"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválido"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor!"),
    })
    @PutMapping(SUBCATEGORY_ID)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<SubCategoria> updateSubCategoria(@PathVariable("id") Integer id,@RequestBody SubCategoriaDTO subCatDto) {

        return subCategoryService.updateSubCategory(id, subCatDto);
    }



    @Operation(summary = "Metodo para deletar subcategoria", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Subcategoria deletada com sucesso!!"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos!"),
            @ApiResponse(responseCode = "401", description = "Usuário não autenticado!"),
            @ApiResponse(responseCode = "403", description = "Não Autorizado!"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválido"),
            @ApiResponse(responseCode = "500", description = "Erro ao atualizar usuário!"),
    })
    @DeleteMapping(SUBCATEGORY_ID)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<SubCategoria> delete(@PathVariable("id") Integer id) {
        return subCategoryService.delete(id);
    }


}
