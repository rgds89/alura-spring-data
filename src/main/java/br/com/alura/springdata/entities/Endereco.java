package br.com.alura.springdata.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="enderecos")
@Getter
@Setter
@NoArgsConstructor
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logadouro;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(String logadouro, String numero, String complemento, String cidade, String uf) {
        this.logadouro = logadouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", logadouro='" + logadouro + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", uf='" + uf + '\'' +
                '}';
    }
}
