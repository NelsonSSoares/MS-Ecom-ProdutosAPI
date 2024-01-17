package nelsonssoares.ecomproductsapi.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "subcategoria")
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
    private Long categoriaId;
}
