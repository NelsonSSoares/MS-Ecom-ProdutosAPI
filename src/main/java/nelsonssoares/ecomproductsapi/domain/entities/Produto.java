package nelsonssoares.ecomproductsapi.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Categoria deve ser informada")
    @Column(name = "categoria_id")
    private Integer categoriaId;

    @NotNull(message = "SubCategoria deve ser informada")
    @Column(name = "subcategoria_id")
    private Integer subCategoriaId;

    @NotEmpty(message = "Nome do produto deve ser informado")
    @Column(name = "nome_produto")
    private String  nomeProduto;

    @NotEmpty(message = "Descrição do produto deve ser informada")
    @Column(length = 255)
    private String  descricao;

    @NotNull(message = "SKU deve ser informado")
    @Column(unique = true)
    private Integer sku;


    @NotNull(message = "Data de cadastro deve ser informada")
    private LocalDate dataCadastro;

    @PositiveOrZero(message = "Valor unitário deve ser maior que zero")
    @NotNull(message = "Valor unitário deve ser informado")
    private BigDecimal valorUnitario;

    @PositiveOrZero(message = "Quantidade em estoque deve ser maior que zero")
    @NotNull(message = "Quantidade em estoque deve ser informada")
    private Integer quantidadeEstoque;

}
