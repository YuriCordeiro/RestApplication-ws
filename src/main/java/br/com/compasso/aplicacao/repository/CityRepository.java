package br.com.compasso.aplicacao.repository;

import br.com.compasso.aplicacao.dto.CityDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<CityDTO, Integer> {

    List<CityDTO> findByNameIgnoreCase(String name);

    List<CityDTO> findByProvinceIgnoreCase(String province);
}
