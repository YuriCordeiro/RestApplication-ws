package br.com.compasso.aplicacao.rest;

import br.com.compasso.aplicacao.dto.CityDTO;
import br.com.compasso.aplicacao.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
    public @ResponseBody ResponseEntity<Object> findAllCities() {
        return new ResponseEntity<>(cityService.findAllCities(), HttpStatus.OK);
    }

    /**
     * Should insert a new city
     * @param cityDTO
     * @return persisted cityDTO object
     */
    @RequestMapping(value = "/insert", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = POST)
    public @ResponseBody ResponseEntity<Object> insertCity(@RequestBody CityDTO cityDTO) {
        return new ResponseEntity<>(cityService.insertNewCity(cityDTO), HttpStatus.CREATED);
    }

    /**
     * Should find cities by name
     *
     * @param cityName
     * @return a list of cities
     */
    @RequestMapping(value = "/findByName/{cityName}")
    public @ResponseBody ResponseEntity<Object> findCitiesByName(@PathVariable String cityName) {
        return new ResponseEntity<>(cityService.findCitiesByName(cityName), HttpStatus.OK);
    }

    /**
     * Should return a list of cities using Province as param
     *
     * @param province
     * @return a list of cities
     */
    @RequestMapping(value = "/findByProvince/{province}")
    public @ResponseBody ResponseEntity<Object> findCitiesByProvince(@PathVariable String province) {
        return new ResponseEntity<>(cityService.findCitiesByProvince(province), HttpStatus.OK);
    }

}
