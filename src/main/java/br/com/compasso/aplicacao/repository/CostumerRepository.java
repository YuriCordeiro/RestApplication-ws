package br.com.compasso.aplicacao.repository;

import br.com.compasso.aplicacao.dto.CostumerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * CostumerRepository Class (Persistence)
 */
@Repository
@Transactional
public interface CostumerRepository extends JpaRepository<CostumerDTO, Integer> {

    /**
     * Should return a list of costumers using <code>completeName</code> as param
     *
     * @param costumerName costumer's completeName
     * @return a list of costumers
     */
    List<CostumerDTO> findByCompleteName(String costumerName);

    /**
     * Should find a costumer by id and updates <code>completeName</code>
     *
     * @param costumerName costumer's new name
     * @param costumerId   costumer's id
     * @return a costumer
     */
    @Modifying
    @Query("update CostumerDTO c set completeName = ?1 where id = ?2")
    void updateCostumer(String completeName, Integer costumerId);

    /**
     * Should find all costumers containing <code>nomePart</code> as part of <code>completeName</code>
     *
     * @param namePart part of costumer's name
     * @return a list of costumers
     */

    List<CostumerDTO> findByCompleteNameContaining(String namePart);

}
