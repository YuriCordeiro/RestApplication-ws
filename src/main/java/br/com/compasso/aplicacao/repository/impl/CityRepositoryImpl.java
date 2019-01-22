package br.com.compasso.aplicacao.repository.impl;

import br.com.compasso.aplicacao.repository.CityRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("cityRepository")
@Transactional
public abstract class CityRepositoryImpl implements CityRepository {
}
