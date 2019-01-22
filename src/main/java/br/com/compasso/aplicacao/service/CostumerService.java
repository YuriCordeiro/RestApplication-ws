package br.com.compasso.aplicacao.service;

import br.com.compasso.aplicacao.dto.CostumerDTO;

import java.util.List;
import java.util.Optional;

public interface CostumerService {

    CostumerDTO insertNewCostumer(CostumerDTO costumerDTO);

    List<CostumerDTO> findAllCostumers();

    List<CostumerDTO> findCostumerByCompleteName(String costumerName);

    Optional<CostumerDTO> findCostumerById(Integer id);

    void removeCostumer(Integer costumerId);

    Optional<CostumerDTO> updateCostumersName(String costumerName, Integer costumerId);

    List<CostumerDTO> findCostumersByNameContaining(String namePart);
}
