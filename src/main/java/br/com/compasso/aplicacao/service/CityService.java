package br.com.compasso.aplicacao.service;

import br.com.compasso.aplicacao.dto.CityDTO;

import java.util.List;

public interface CityService {

    CityDTO insertNewCity(CityDTO city);

    List<CityDTO> findAllCities();

    List<CityDTO> findCitiesByName(String name);

    List<CityDTO> findCitiesByProvince(String province);
}
