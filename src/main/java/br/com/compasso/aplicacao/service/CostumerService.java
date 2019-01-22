package br.com.compasso.aplicacao.service;

import br.com.compasso.aplicacao.dto.CostumerDTO;

import java.util.List;
import java.util.Optional;

public interface CostumerService {

    /**
     * It should insert a new costumer and return itself
     *
     * @param costumerDTO a new costumer
     * @return the persisted objetc
     */
    CostumerDTO insertNewCostumer(CostumerDTO costumerDTO);

    /**
     * should return all costumers registered
     *
     * @return a list of costumers
     */
    List<CostumerDTO> findAllCostumers();

    /**
     * Should return a list of costumers using <code>completeName</code> as param
     *
     * @param costumerName costumer's completeName
     * @return a list of costumers
     */

    List<CostumerDTO> findCostumerByCompleteName(String costumerName);

    /**
     * Should return a costumer using <code>id</code> as param
     *
     * @param id costumer's id
     * @return a costumer
     */

    Optional<CostumerDTO> findCostumerById(Integer id);

    /**
     * Should find for a costumer by id and delete it
     *
     * @param costumerId costumer's id
     */
    void removeCostumer(Integer costumerId);

    /**
     * Should find a costumer by id and updates <code>completeName</code>
     *
     * @param costumerName costumer's new name
     * @param costumerId   costumer's id
     * @return a costumer
     */

    Optional<CostumerDTO> updateCostumersName(String costumerName, Integer costumerId);

    /**
     * Should find all costumers containing <code>nomePart</code> as part of <code>completeName</code>
     *
     * @param namePart part of costumer's name
     * @return a list of costumers
     */
    List<CostumerDTO> findCostumersByNameContaining(String namePart);
}
