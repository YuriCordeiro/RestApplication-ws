package br.com.compasso.aplicacao.repository;

import br.com.compasso.aplicacao.dto.CostumerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CostumerRepository extends JpaRepository<CostumerDTO, Integer> {

    List<CostumerDTO> findByCompleteName(String costumerName);

    @Modifying
    @Query("update CostumerDTO c set completeName = ?1 where id = ?2")
    void updateCostumer(String completeName, Integer costumerId);

    List<CostumerDTO> findByCompleteNameContaining(String namePart);

}
