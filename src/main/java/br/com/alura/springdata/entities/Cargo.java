package br.com.alura.springdata.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cargos")
@Getter
@Setter
@NoArgsConstructor
public class Cargo  implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;

    public Cargo(String descricao){
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Cargo { id= " + id + ", descricao= " + descricao + "}";
    }
}
