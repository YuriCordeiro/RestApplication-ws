package br.com.compasso.aplicacao.rest;

import br.com.compasso.aplicacao.dto.CostumerDTO;
import br.com.compasso.aplicacao.service.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.*;


/**
 * CostumerRestController Class (Rest Controller)
 */
@RestController
@RequestMapping("/api/costumer")
public class CostumerRestController {

    @Autowired
    private CostumerService costumerService;

    /**
     * Should return a json containing all costumers data registered
     * @return formatted json
     */
    @RequestMapping(value = "/all", method = GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody ResponseEntity<Object> findAllCostumers() {
        return new ResponseEntity<>(costumerService.findAllCostumers(), HttpStatus.OK);
    }

    /**
     * Should insert a new Costumer Object
     * @param costumerDTO new costumer
     * @return persisted costumer objetc
     */
    @RequestMapping(value = "/insert", method = POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody ResponseEntity<CostumerDTO> insertNewCostumer(@RequestBody CostumerDTO costumerDTO) {
        return new ResponseEntity<>(costumerService.insertNewCostumer(costumerDTO), HttpStatus.CREATED);
    }

    /**
     * Should return a list of costumers using completeName as param
     *
     * @param costumerName <code>String</code> costumer's name
     * @return
     */
    @RequestMapping(value = "/findByCompleteName/{costumerName}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody ResponseEntity<Object> findCostumerByName(@PathVariable String costumerName) {
        return new ResponseEntity<>(costumerService.findCostumerByCompleteName(costumerName), HttpStatus.OK);
    }

    /**
     * Should return a list of costumers using part of name as param
     *
     * @param costumersNamePart costumer's part name
     * @return list of costumers
     */
    @RequestMapping(value="/findByNameContaining/{costumersNamePart}")
    public @ResponseBody ResponseEntity<Object> findCostumerByNameLike(@PathVariable String costumersNamePart){
        return new ResponseEntity<>(costumerService.findCostumersByNameContaining(costumersNamePart), HttpStatus.OK);
    }

    /**
     * Should return a costumer using id as param
     *
     * @param costumerId costumer's id
     * @return a costumer
     */
    @RequestMapping(value = "/findById/{costumerId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody ResponseEntity<Object> findCostumerById(@PathVariable Integer costumerId) {
        return new ResponseEntity<>(costumerService.findCostumerById(costumerId), HttpStatus.OK);
    }

    /**
     * Should remove a costumer. It receives id as param.
     *
     * @param costumerId costumer's id.
     * @return <code>void</code>
     */
    @RequestMapping(value = "/remove/{costumerId}", method = DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody void removeCostumer(@PathVariable Integer costumerId) {
        costumerService.removeCostumer(costumerId);
    }

    /**
     * Should update a costumer's complete name
     *
     * @param costumerId   costumer's id
     * @param costumerName costumer's new complete name
     * @return uodated object
     */
    @RequestMapping(value = "/update/{costumerId}/{costumerName}",  method = PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody ResponseEntity<Object> updateCostumerName(@PathVariable Integer costumerId, @PathVariable String costumerName) {
        return new ResponseEntity<>(costumerService.updateCostumersName(costumerName, costumerId), HttpStatus.ACCEPTED);
    }


}
