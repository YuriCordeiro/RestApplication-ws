package br.com.compasso.aplicacao.rest;

import br.com.compasso.aplicacao.dto.CityDTO;
import br.com.compasso.aplicacao.service.CityService;
import br.com.compasso.aplicacao.builder.CityObjectBuilder;
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

import static org.junit.Assert.*;

/**
 * CityRestController class JUnit test <br/>
 * <i>Using mocks not depends on real databases data neither real HTTP Requests</i>
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = CityRestController.class)
public class CityRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CityService cityService;

    @Test
    public void findAllCities() throws Exception {
        //Instantiate new CityDTO List through my CityObjectBuilder class
        List<CityDTO> citiesList = CityObjectBuilder.buildCitiesFromSpProvinceList();

        //API URI
        String uri = "/api/city/all";

        //Tell mockito "When findAllCities method is called, it should returns citiesList object"
        Mockito.when(cityService.findAllCities()).thenReturn(citiesList);
        //Building RequestBuilder to call city's api uri
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(uri);
        //Building the Request and getting the mock response
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        //Getting response from MvcResult
        MockHttpServletResponse response = result.getResponse();

        //Getting response content
        String outputJson = response.getContentAsString();
        //Validation
        assertEquals(outputJson, Utils.mapToJson(citiesList));

    }

    @Test
    public void insertCity() throws Exception {
        //Instantiate new CityDTO Object and building object through my CityObjectBuilder class
        CityDTO cityDTO = CityObjectBuilder.buildCityObject();

        //Creating a String input Json from cityDTO object
        String inputJson = Utils.mapToJson(cityDTO);

        //API URI
        String uri = "/api/city/insert";

        //Tell mockito "When insertNewCity method is called, it should insert a new CityDTO object and returns itself"
        Mockito.when(cityService.insertNewCity(Mockito.any(CityDTO.class))).thenReturn(cityDTO);

        //Building RequestBuilder to call city's api uri by using POST method and jsonInput as content
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
    public void findCitiesByName() throws Exception {
        //Instantiate new CityDTO List and building objects through my CityObjectBuilder class
        List<CityDTO> citiesList = CityObjectBuilder.buildCitiesNamedBomJesusList();

        //API URI and Param
        String uri = "/api/city/findByName/{cityName}";
        String uriParam = "Bom Jesus";

        //Tell mockito "When findCitiesByName('Bom Jesus') method is called, it should return all cities named by 'Bom Jesus'"
        Mockito.when(cityService.findCitiesByName(Mockito.anyString())).thenReturn(citiesList);

        //Building RequestBuilder to call city's api uri by using GET method + uriParam
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(uri, uriParam);

        //Building the Request and getting the mock response
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        //Getting response from MvcResult
        MockHttpServletResponse response = result.getResponse();
        //Getting response content
        String outputJson = response.getContentAsString();

        //Validation
        assertEquals(outputJson, Utils.mapToJson(citiesList));
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void findCitiesByProvince() throws Exception {
        //Instantiate new CityDTO List
        List<CityDTO> citiesList = CityObjectBuilder.buildCitiesFromRsProvinceList();

        //API URI and Param
        String uri = "/api/city/findByProvince/{province}";
        String uriParam = "RS";

        //Tell mockito "When findCitiesByProvince(String) method is called, it should return all cities from [String passed] province"
        Mockito.when(cityService.findCitiesByProvince(Mockito.anyString())).thenReturn(citiesList);

        //Building RequestBuilder to call city's api uri by using GET method + uriParam
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(uri, uriParam);

        //Building the Request and getting the mock response
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        //Getting response from MvcResult
        MockHttpServletResponse response = result.getResponse();
        //Getting response content
        String outputJson = response.getContentAsString();

        //Validation
        assertEquals(outputJson, Utils.mapToJson(citiesList));
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

}