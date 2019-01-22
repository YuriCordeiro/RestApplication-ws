package br.com.compasso.aplicacao.rest;

import br.com.compasso.aplicacao.dto.CostumerDTO;
import br.com.compasso.aplicacao.service.CostumerService;
import br.com.compasso.aplicacao.builder.CostumerObjectBuilder;
import br.com.compasso.aplicacao.util.Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * CostumerRestController class JUnit test <br/>
 * <i>Using mocks not depends on real databases data neither real HTTP Requests</i>
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CostumerRestController.class)
public class CostumerRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CostumerService costumerService;

    private final String api_base_url = "/api/costumer";

    @Test
    public void findAllCostumers() throws Exception {

        //Instantiate new CostumerDTO List
        List<CostumerDTO> costumersList = CostumerObjectBuilder.buildCostumersList();

        //API URI
        String uri = api_base_url.concat("/all");

        //Tell mockito "When findAllCostumers method is called, it should returns costumersList object"
        when(costumerService.findAllCostumers()).thenReturn(costumersList);
        //Building RequestBuilder to call costumer's api uri
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(uri);
        //Building the Request and getting the mock response
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        //Getting response from MvcResult
        MockHttpServletResponse response = result.getResponse();

        //Getting response content
        String outputJson = response.getContentAsString();
        //Validation
        assertEquals(outputJson, Utils.mapToJson(costumersList));

    }

    @Test
    public void insertNewCostumer() throws Exception {
        //Instantiate new CostumerDTO Object and building object through my CostumerObjectBuilder class
        CostumerDTO costumerDTO = CostumerObjectBuilder.buildCostumerObject();

        //Creating a String input Json from costumerDTO object
        String inputJson = Utils.mapToJson(costumerDTO);

        //API URI
        String uri = api_base_url.concat("/insert");

        //Tell mockito "When insertNewCostumer method is called, it should insert a new CostumerDTO object and returns itself"
        Mockito.when(costumerService.insertNewCostumer(Mockito.any(CostumerDTO.class))).thenReturn(costumerDTO);

        //Building RequestBuilder to call Costumer's api uri by using POST method and jsonInput as content
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(uri)
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

        //Building the Request and getting the mock response
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        //Getting response from MvcResult
        MockHttpServletResponse response = result.getResponse();
        //Getting String response content
        String outputJson = response.getContentAsString();

        //Validation
        assertEquals(outputJson, inputJson);
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void findCostumerByCompleteName() throws Exception {
        //Instantiate new CostumerDTO List and building objects through my CostumerObjectBuilder class
        List<CostumerDTO> costumersList = CostumerObjectBuilder.buildCostumersWithSameCompleteName();

        //API URI and Param
        String uri = api_base_url.concat("/findByCompleteName/{CostumerName}");
        String uriParam = "Yuri Cordeiro";

        //Tell mockito "When findCostumerByCompleteName('Yuri') method is called, it should return all costumers named by 'Yuri Cordeiro'"
        Mockito.when(costumerService.findCostumerByCompleteName(Mockito.anyString())).thenReturn(costumersList);

        //Building RequestBuilder to call Costumer's api uri by using GET method + uriParam
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(uri, uriParam);

        //Building the Request and getting the mock response
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        //Getting response from MvcResult
        MockHttpServletResponse response = result.getResponse();
        //Getting response content
        String outputJson = response.getContentAsString();

        //Validation
        assertEquals(outputJson, Utils.mapToJson(costumersList));
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void findCostumerById() throws Exception {
        //Instantiate new CostumerDTO List and building objects through my CostumerObjectBuilder class
        Optional costumer = CostumerObjectBuilder.getEmptyCostumer();

        //API URI and Param
        String uri = api_base_url.concat("/findById/{costumerId}");
        Integer costumerIdParam = 99;

        //Tell mockito "When findCostumerById(99) method is called, it should return a costumer that contains id = 99 (it's not registered)
        Mockito.when(costumerService.findCostumerById(Mockito.anyInt())).thenReturn(costumer);

        //Building RequestBuilder to call costumer's api uri by using GET method + costumerIdParam
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(uri, costumerIdParam);

        //Building the Request and getting the mock response
        MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
        //Getting response from MvcResult
        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void removeCostumer() throws Exception {
        //API URI and Param
        String uri = api_base_url.concat("/remove/{costumerIdParam}/");
        Integer costumerIdParam = 99;

        //Building RequestBuilder to call Costumer's api uri by using GET method + costumerIdParam
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(uri, costumerIdParam);

        //Building the Request and getting the mock response
        MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();

        //Getting response from MvcResult
        MockHttpServletResponse response = result.getResponse();

        //Validation
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void updateCostumerName() throws Exception {
        //Instantiate new CostumerDTO Object and building object through my CostumerObjectBuilder class
        CostumerDTO costumerDTO = CostumerObjectBuilder.buildCostumerObject();
        Optional costumerOptional = Optional.of(costumerDTO);

        //API URI
        String uri = api_base_url.concat("/update/{costumerId}/{costumerName}");
        Integer costumerIdParam = 1;
        String costumersCompleteNameParam = "Fulana de Tal";

        // Updating Costumer's name
        CostumerObjectBuilder.getDTOFromOptional(costumerOptional).setCompleteName(costumersCompleteNameParam);

        //Tell mockito "When insertNewCostumer method is called, it should insert a new CostumerDTO object and returns itself"
        Mockito.when(costumerService.updateCostumersName(Mockito.anyString(), Mockito.anyInt())).thenReturn(costumerOptional);

        //Building RequestBuilder to call Costumer's api uri by using POST method and jsonInput as content
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put(uri, costumerIdParam, costumerIdParam)
                .content(MediaType.APPLICATION_JSON_UTF8_VALUE);

        //Building the Request and getting the mock response
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        //Getting response from MvcResult
        MockHttpServletResponse response = result.getResponse();
        //Getting String response content
        String outputJson = response.getContentAsString();

        //Validations
        assertEquals(HttpStatus.OK.value(), response.getStatus());

        //Mapping InputInfo and Output response as object
        CostumerDTO outputCostumer = CostumerObjectBuilder.mapToObject(outputJson);
        CostumerDTO inputCostumer = CostumerObjectBuilder.buildCostumerObject();

        //Validating is the same object
        assertEquals(outputCostumer.getId(), inputCostumer.getId());
        assertEquals(outputCostumer.getAge(), inputCostumer.getAge());
        assertEquals(outputCostumer.getBirthDate().getTime(), inputCostumer.getBirthDate().getTime());
        assertEquals(outputCostumer.getGender(), inputCostumer.getGender());

        //Validating costumer's city info
        assertEquals(outputCostumer.getCity().getId(), inputCostumer.getCity().getId());
        assertEquals(outputCostumer.getCity().getName(), inputCostumer.getCity().getName());
        assertEquals(outputCostumer.getCity().getProvince(), inputCostumer.getCity().getProvince());

        //Validating Different Complete Names
        assertNotEquals(outputCostumer.getCompleteName(), inputCostumer.getCompleteName());

    }

    @Test
    public void findCostumerByNameLike() throws Exception {
        //Instantiate new CostumerDTO List and building objects through my CostumerObjectBuilder class
        List<CostumerDTO> costumersList = CostumerObjectBuilder.buildCostumersWithSameCompleteName();

        //API URI and Param
        String uri = api_base_url.concat("/findByNameContaining/{costumersNamePart}");
        String uriParam = "Cordeiro";

        //Tell mockito "When findCostumerByCompleteName('Yuri') method is called, it should return all costumers named by 'Yuri Cordeiro'"
        Mockito.when(costumerService.findCostumersByNameContaining(Mockito.anyString())).thenReturn(costumersList);

        //Building RequestBuilder to call Costumer's api uri by using GET method + uriParam
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(uri, uriParam);

        //Building the Request and getting the mock response
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        //Getting response from MvcResult
        MockHttpServletResponse response = result.getResponse();
        //Getting response content
        String outputJson = response.getContentAsString();

        //Validation
        assertEquals(outputJson, Utils.mapToJson(costumersList));
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }
}