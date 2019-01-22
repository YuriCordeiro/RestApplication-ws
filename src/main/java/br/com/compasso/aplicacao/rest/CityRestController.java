package br.com.compasso.aplicacao.rest;

import br.com.compasso.aplicacao.dto.CityDTO;
import br.com.compasso.aplicacao.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * CityRestController class (Rest Controller)
 */
@RestController
@RequestMapping("/api/city")
public class CityRestController {

    @Autowired
    private CityService cityService;

    /**
     * Should return a list containing all cities registered
     *
     * @return a list of cities
     */
    @RequestMapping("/all")
    public List<CityDTO> findAllCities() {
        return cityService.findAllCities();
    }

    /**
     * Should insert a new city
     * @param cityDTO
     * @return persisted cityDTO object
     */
    @RequestMapping(value = "/insert", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = POST)
    public @ResponseBody CityDTO insertCity(@RequestBody CityDTO cityDTO) {
        return cityService.insertNewCity(cityDTO);
    }

    /**
     * Should find cities by name
     *
     * @param cityName
     * @return a list of cities
     */
    @RequestMapping(value = "/findByName/{cityName}")
    public @ResponseBody List<CityDTO> findCitiesByName(@PathVariable String cityName) {
        return cityService.findCitiesByName(cityName);
    }

    /**
     * Should return a list of cities using Province as param
     *
     * @param province
     * @return a list of cities
     */
    @RequestMapping(value = "/findByProvince/{province}")
    public @ResponseBody List<CityDTO> findCitiesByProvince(@PathVariable String province) {
        return cityService.findCitiesByProvince(province);
    }

}
