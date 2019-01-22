package br.com.compasso.aplicacao.rest;

import br.com.compasso.aplicacao.dto.CostumerDTO;
import br.com.compasso.aplicacao.service.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.*;


@RestController
@RequestMapping("/api/costumer")
public class CostumerRestController {

    @Autowired
    private CostumerService costumerService;

    @RequestMapping(value = "/all", method = GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<CostumerDTO> findAllCostumers() {
        return costumerService.findAllCostumers();
    }

    @RequestMapping(value = "/insert", method = POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody CostumerDTO insertNewCostumer(@RequestBody CostumerDTO costumerDTO) {
        return costumerService.insertNewCostumer(costumerDTO);
    }

    @RequestMapping(value = "/findByCompleteName/{costumerName}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody List<CostumerDTO> findCostumerByName(@PathVariable String costumerName) {
        return costumerService.findCostumerByCompleteName(costumerName);
    }

    @RequestMapping(value="/findByNameContaining/{costumersNamePart}")
    public @ResponseBody List<CostumerDTO> findCostumerByNameLike(@PathVariable String costumersNamePart){
        return costumerService.findCostumersByNameContaining(costumersNamePart);
    }

    @RequestMapping(value = "/findById/{costumerId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody Optional<CostumerDTO> findCostumerById(@PathVariable Integer costumerId) {
        return costumerService.findCostumerById(costumerId);
    }

    @RequestMapping(value = "/remove/{costumerId}", method = DELETE)
    public @ResponseBody String removeCostumer(@PathVariable Integer costumerId) {
        costumerService.removeCostumer(costumerId);
        return "Success!";
    }

    @RequestMapping(value = "/update/{costumerId}/{costumerName}",  method = PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody Optional<CostumerDTO> updateCostumerName(@PathVariable Integer costumerId, @PathVariable String costumerName) {
        return costumerService.updateCostumersName(costumerName, costumerId);
    }


}
