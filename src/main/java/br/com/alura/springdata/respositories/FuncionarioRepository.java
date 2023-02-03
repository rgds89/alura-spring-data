package br.com.alura.springdata.respositories;

import br.com.alura.springdata.entities.Funcionario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {
    List<Funcionario> findByNomeLike(String nome);
}
