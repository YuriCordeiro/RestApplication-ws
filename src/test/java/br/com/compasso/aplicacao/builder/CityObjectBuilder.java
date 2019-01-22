package br.com.compasso.aplicacao.builder;

import br.com.compasso.aplicacao.dto.CityDTO;

import java.util.Arrays;
import java.util.List;

public class CityObjectBuilder {

    public static List<CityDTO> buildCitiesFromSpProvinceList() {
        //Instantiate new CityDTO Objects
        CityDTO campinas = new CityDTO();
        campinas.setId(1);
        campinas.setName("Campinas");
        campinas.setProvince("SP");

        CityDTO bauru = new CityDTO();
        campinas.setId(2);
        campinas.setName("Bauru");
        campinas.setProvince("SP");

        return Arrays.asList(campinas, bauru);
    }

    public static List<CityDTO> buildCitiesNamedBomJesusList() {
        //Instantiate new CityDTO Objects
        CityDTO bomJesusRn = new CityDTO();
        bomJesusRn.setId(1);
        bomJesusRn.setName("Bom Jesus");
        bomJesusRn.setProvince("RN");

        CityDTO bomJesusPb = new CityDTO();
        bomJesusPb.setId(2);
        bomJesusPb.setName("Bom Jesus");
        bomJesusPb.setProvince("PB");

        CityDTO bomJesusPi = new CityDTO();
        bomJesusPi.setId(3);
        bomJesusPi.setName("Bom Jesus");
        bomJesusPi.setProvince("PI");

        return Arrays.asList(bomJesusRn, bomJesusPb, bomJesusPi);
    }

    public static List<CityDTO> buildCitiesFromRsProvinceList() {
        //Instantiate new CityDTO Objects
        CityDTO aguaSanta = new CityDTO();
        aguaSanta.setId(1);
        aguaSanta.setName("Água Santa");
        aguaSanta.setProvince("RS");

        CityDTO agudo = new CityDTO();
        agudo.setId(2);
        agudo.setName("Agudo");
        agudo.setProvince("RS");

        CityDTO itapuca = new CityDTO();
        itapuca.setId(3);
        itapuca.setName("Itapuca");
        itapuca.setProvince("RS");

        CityDTO ibiaca = new CityDTO();
        ibiaca.setId(4);
        ibiaca.setName("Ibiaca");
        ibiaca.setProvince("RS");

        return Arrays.asList(aguaSanta, agudo, itapuca, ibiaca);
    }

    public static CityDTO buildCityObject() {
        //Instantiate new CityDTO Object
        CityDTO cityDTO = new CityDTO();
        cityDTO.setId(1);
        cityDTO.setName("Americana");
        cityDTO.setProvince("SP");

        return cityDTO;
    }
}
