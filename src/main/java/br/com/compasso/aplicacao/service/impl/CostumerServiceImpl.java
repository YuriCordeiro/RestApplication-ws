package br.com.compasso.aplicacao.service.impl;

import br.com.compasso.aplicacao.dto.CostumerDTO;
import br.com.compasso.aplicacao.repository.CostumerRepository;
import br.com.compasso.aplicacao.service.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("costumerService")
public class CostumerServiceImpl implements CostumerService {

    @Autowired
    private CostumerRepository costumerRepository;

    @Override
    public CostumerDTO insertNewCostumer(CostumerDTO costumerDTO) {
        return costumerRepository.save(costumerDTO);
    }

    @Override
    public List<CostumerDTO> findAllCostumers() {
        return costumerRepository.findAll();
    }

    @Override
    public List<CostumerDTO> findCostumerByCompleteName(String costumerName) {
        return costumerRepository.findByCompleteName(costumerName);
    }

    @Override
    public Optional<CostumerDTO> findCostumerById(Integer id) {
        return costumerRepository.findById(id);
    }

    @Override
    public void removeCostumer(Integer costumerId) {
        Optional<CostumerDTO> costumer = findCostumerById(costumerId);
        if (costumer.isPresent()) {
            costumerRepository.delete(costumer.get());
        }
    }

    @Override
    public Optional<CostumerDTO> updateCostumersName(String costumerName, Integer costumerId) {
        costumerRepository.updateCostumer(costumerName, costumerId);
        return findCostumerById(costumerId);
    }

    @Override
    public List<CostumerDTO> findCostumersByNameContaining(String namePart) {
        return costumerRepository.findByCompleteNameContaining(namePart);
    }
}
