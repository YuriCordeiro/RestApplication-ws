package br.com.compasso.aplicacao.service.impl;

import br.com.compasso.aplicacao.dto.CityDTO;
import br.com.compasso.aplicacao.repository.CityRepository;
import br.com.compasso.aplicacao.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cityService")
public class CityServiceImpl implements CityService {

    @Autowired
    public CityRepository cityRepository;

    @Override
    public CityDTO insertNewCity(CityDTO city) {
        return cityRepository.save(city);
    }

    @Override
    public List<CityDTO> findAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public List<CityDTO> findCitiesByName(String name) {
        return cityRepository.findByNameIgnoreCase(name);
    }

    @Override
    public List<CityDTO> findCitiesByProvince(String province) {
        return cityRepository.findByProvinceIgnoreCase(province);
    }
}
