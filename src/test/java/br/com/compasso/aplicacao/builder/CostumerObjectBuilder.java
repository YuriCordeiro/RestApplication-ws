package br.com.compasso.aplicacao.builder;

import br.com.compasso.aplicacao.dto.CityDTO;
import br.com.compasso.aplicacao.dto.CostumerDTO;
import br.com.compasso.aplicacao.enums.Gender;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class CostumerObjectBuilder {

    public static List<CostumerDTO> buildCostumersList() {
        //Instantiate new Costumer Object
        CostumerDTO yuri = new CostumerDTO();
        yuri.setId(1);
        yuri.setCompleteName("Yuri Cordeiro");
        yuri.setAge(22);
        yuri.setGender(Gender.Masculino);

        //Adding some Birth Date to object
        Date yurisBday = new GregorianCalendar(1998, Calendar.MARCH, 12).getTime();
        yuri.setBirthDate(yurisBday);

        //Adding some City to object
        CityDTO yurisCity = CityObjectBuilder.buildCityObject();
        yuri.setCity(yurisCity);

        //Instantiate new Costumer Object
        CostumerDTO isabela = new CostumerDTO();
        isabela.setId(2);
        isabela.setCompleteName("Isabella Lagartera");
        isabela.setAge(20);
        isabela.setGender(Gender.Feminino);

        //Adding some Birth Date to object
        Date isabelasBday = new GregorianCalendar(1998, Calendar.MARCH, 12).getTime();
        isabela.setBirthDate(isabelasBday);

        //Adding some City to object
        CityDTO isabelasCity = CityObjectBuilder.buildCityObject();
        isabela.setCity(isabelasCity);

        return Arrays.asList(yuri, isabela);
    }

    public static List<CostumerDTO> buildCostumersWithSameCompleteName() {
        //Instantiate new Costumer Object
        CostumerDTO yuri = new CostumerDTO();
        yuri.setId(1);
        yuri.setCompleteName("Yuri Cordeiro");
        yuri.setAge(22);
        yuri.setGender(Gender.Masculino);

        //Adding some Birth Date to object
        Date yuriBday = new GregorianCalendar(1996, Calendar.DECEMBER, 11).getTime();
        yuri.setBirthDate(yuriBday);

        //Adding some City to object
        CityDTO yurisCity = CityObjectBuilder.buildCityObject();
        yuri.setCity(yurisCity);

        //Instantiate new Costumer Object
        CostumerDTO yuriCordeiro = new CostumerDTO();
        yuriCordeiro.setId(2);
        yuriCordeiro.setCompleteName("Yuri Cordeiro");
        yuriCordeiro.setAge(32);
        yuriCordeiro.setGender(Gender.Masculino);

        //Adding some Birth Date to object
        Date yuriCordeirosBday = new GregorianCalendar(1986, Calendar.DECEMBER, 11).getTime();
        yuriCordeiro.setBirthDate(yuriCordeirosBday);

        //Adding some City to object
        CityDTO yuriCordeirosCity = CityObjectBuilder.buildCityObject();
        yuriCordeiro.setCity(yuriCordeirosCity);

        return Arrays.asList(yuri, yuriCordeiro);
    }

    public static CostumerDTO buildCostumerObject() {
        //Instantiate new Costumer Object
        CostumerDTO paula = new CostumerDTO();
        paula.setId(1);
        paula.setCompleteName("Paula Mancuso");
        paula.setAge(20);
        paula.setGender(Gender.Feminino);

        //Adding some Birth Date to object
        Date paulasBday = new GregorianCalendar(1998, Calendar.AUGUST, 31).getTime();

        paula.setBirthDate(paulasBday);

        //Adding some City to object
        CityDTO paulasCity = CityObjectBuilder.buildCityObject();
        paula.setCity(paulasCity);

        return paula;
    }

    public static Optional<CostumerDTO> getEmptyCostumer() {
        return Optional.empty();
    }

    public static CostumerDTO getDTOFromOptional(Optional optionalObject) {
        return ((CostumerDTO) optionalObject.get());
    }

    public static CostumerDTO mapToObject(String object) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        objectMapper.setDateFormat(df);
        objectMapper.setTimeZone(TimeZone.getTimeZone("GMT-03:00"));

        return objectMapper.readValue(object, CostumerDTO.class);
    }
}
