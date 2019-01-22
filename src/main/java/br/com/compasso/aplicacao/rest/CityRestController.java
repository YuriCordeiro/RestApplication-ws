package br.com.compasso.aplicacao.rest;

import br.com.compasso.aplicacao.dto.CityDTO;
import br.com.compasso.aplicacao.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/api/city")
public class CityRestController {

    @Autowired
    private CityService cityService;

    @RequestMapping("/all")
    public List<CityDTO> findAllCities() {
        return cityService.findAllCities();
    }

    @RequestMapping(value = "/insert", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = POST)
    public @ResponseBody CityDTO insertCity(@RequestBody CityDTO cityDTO) {
        return cityService.insertNewCity(cityDTO);
    }

    @RequestMapping(value = "/findByName/{cityName}")
    public @ResponseBody List<CityDTO> findCitiesByName(@PathVariable String cityName) {
        return cityService.findCitiesByName(cityName);
    }

    @RequestMapping(value = "/findByProvince/{province}")
    public @ResponseBody List<CityDTO> findCitiesByProvince(@PathVariable String province) {
        return cityService.findCitiesByProvince(province);
    }

}
