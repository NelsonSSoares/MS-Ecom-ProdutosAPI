package nelsonssoares.ecomproductsapi.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class SubCategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Nome da subcategoria deve ser informado")
    @Column(name = "nome_subcategoria")
    private String nomeSubCategoria;

    @NotEmpty(message = "Descrição da subcategoria deve ser informada")
    private String descricao;

    @NotNull(message = "ID da " +
            "Categoria deve ser informada")
    private Integer categoriaId;
}
