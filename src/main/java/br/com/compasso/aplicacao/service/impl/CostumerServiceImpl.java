package br.com.compasso.aplicacao.service.impl;

import br.com.compasso.aplicacao.dto.CostumerDTO;
import br.com.compasso.aplicacao.repository.CostumerRepository;
import br.com.compasso.aplicacao.service.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

/**
 * CostumerService Implementation Class (Something like a Business Object)
 */
@Service("costumerService")
public class CostumerServiceImpl implements CostumerService {

    @Autowired
    private CostumerRepository costumerRepository;

    /**
     * It should insert a new costumer and return itself
     *
     * @param costumerDTO a new costumer
     * @return the persisted objetc
     */
    @Override
    public CostumerDTO insertNewCostumer(CostumerDTO costumerDTO) {
        return costumerRepository.save(costumerDTO);
    }

    /**
     * should return all costumers registered
     *
     * @return a list of costumers
     */
    @Override
    public List<CostumerDTO> findAllCostumers() {
        return costumerRepository.findAll();
    }

    /**
     * Should return a list of costumers using <code>completeName</code> as param
     *
     * @param costumerName costumer's completeName
     * @return a list of costumers
     */
    @Override
    public List<CostumerDTO> findCostumerByCompleteName(String costumerName) {
        List<CostumerDTO> resultList = costumerRepository.findByCompleteName(costumerName);
        if (null == resultList || resultList.size() == 0) {
            throw new NoResultException();
        } else {
            return resultList;
        }
    }

    /**
     * Should return a costumer using <code>id</code> as param
     *
     * @param id costumer's id
     * @return a costumer
     */
    @Override
    public Optional<CostumerDTO> findCostumerById(Integer id) {
        Optional<CostumerDTO> costumer = costumerRepository.findById(id);
        if (!costumer.isPresent()) {
            throw new NoResultException();
        } else {
            return costumer;
        }
    }

    /**
     * Should find for a costumer by id and delete it
     *
     * @param costumerId costumer's id
     */
    @Override
    public void removeCostumer(Integer costumerId) {
        Optional<CostumerDTO> costumer = findCostumerById(costumerId);
        if (costumer.isPresent()) {
            costumerRepository.delete(costumer.get());
        }
    }

    /**
     * Should find a costumer by id and updates <code>completeName</code>
     *
     * @param costumerName costumer's new name
     * @param costumerId   costumer's id
     * @return a costumer
     */
    @Override
    public Optional<CostumerDTO> updateCostumersName(String costumerName, Integer costumerId) {
        costumerRepository.updateCostumer(costumerName, costumerId);
        return findCostumerById(costumerId);
    }

    /**
     * Should find all costumers containing <code>nomePart</code> as part of <code>completeName</code>
     *
     * @param namePart part of costumer's name
     * @return a list of costumers
     */
    @Override
    public List<CostumerDTO> findCostumersByNameContaining(String namePart) {
        List<CostumerDTO> costumersList = costumerRepository.findByCompleteNameContaining(namePart);
        if (null == costumersList || costumersList.size() == 0) {
            throw new NoResultException();
        } else {
            return costumersList;
        }
    }
}
