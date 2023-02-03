package br.com.alura.springdata.respositories;

import br.com.alura.springdata.entities.Unidade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeRepository extends CrudRepository<Unidade, Long> {
}
