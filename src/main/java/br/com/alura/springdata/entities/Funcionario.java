package br.com.alura.springdata.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="funcionarios")
@Getter
@Setter
@NoArgsConstructor
public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpfCnpj;
    private BigDecimal salario;
    private LocalDate dataContratacao;

    @ManyToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "unidade_id")
    private Unidade unidade;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    public Funcionario(String nome, String cpfCnpj, BigDecimal salario, LocalDate dataContratacao, Cargo cargo, Unidade unidade, Endereco endereco) {
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.salario = salario;
        this.dataContratacao = dataContratacao;
        this.cargo = cargo;
        this.unidade = unidade;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpfCnpj='" + cpfCnpj + '\'' +
                ", salario=" + salario +
                ", dataContratacao=" + dataContratacao +
                ", cargo=" + cargo +
                ", unidade=" + unidade +
                ", endereco=" + endereco +
                '}';
    }
}
