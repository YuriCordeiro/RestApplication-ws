package br.com.compasso.aplicacao.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Utilities Class
 */
public class Utils {

    /**
     * It should returns the object mapped to Json in String type
     *
     * @param object any object
     * @return formatted json
     * @throws JsonProcessingException
     */
    public static String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }

}
