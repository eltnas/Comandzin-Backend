package br.com.eltnas.comandzin.entities;

import br.com.eltnas.comandzin.entities.enums.TipoProdutoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, nullable = false)
    private String produto;

    @Column(precision = 10, scale = 2)
    private BigDecimal preco;

    @Column(name = "unidade_medida", length = 20, nullable = false)
    private String unidadeMedida;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_produto", length = 30, nullable = false)
    private TipoProdutoEnum tipoProduto = TipoProdutoEnum.SIMPLES;

    @Column(name = "disponivel_venda", nullable = false)
    private Boolean disponivelVenda = true;

    @ManyToOne
    @JoinColumn(name = "setor_id")
    private Setor setor;

    @ManyToOne
    @JoinColumn(name = "produto_pai_id")
    private Produto produtoPai;

    @Column(name = "quantidade_fator", precision = 10, scale = 3)
    private BigDecimal quantidadeFator;

    @CreationTimestamp
    @Column(name = "data_criacao", updatable = false)
    private LocalDateTime dataCriacao;
}
