package br.com.compasso.aplicacao.repository.impl;

import br.com.compasso.aplicacao.service.CostumerService;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public abstract class CostumerRepositoryImpl implements CostumerService {
}
