package br.com.alura.springdata.respositories;

import br.com.alura.springdata.entities.Cargo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Long> {
    @Transactional
    @Modifying
    @Query("update Cargo c set c.descricao = :descricao where c.id = :id")
    int updateDescricaoById(@Param("descricao") String descricao, @Param("id") Long id);
}
