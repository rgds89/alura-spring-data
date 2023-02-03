package br.com.alura.springdata.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "unidades_trabalho")
@Getter
@Setter
@NoArgsConstructor
public class Unidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    public Unidade(String descricao, Endereco endereco) {
        this.descricao = descricao;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Unidade{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
