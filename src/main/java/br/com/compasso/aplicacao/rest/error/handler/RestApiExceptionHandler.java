package br.com.compasso.aplicacao.rest.error.handler;

import br.com.compasso.aplicacao.rest.error.RestApiMessageError;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.NoResultException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * RestApiExceptionHandler should handle all mapped exceptions
 */
@RestControllerAdvice
public class RestApiExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String DATE_PATTERN = "dd/MM/yyyy HH:mm:ss";

    /**
     * Should hangle <code>NoResultException</code>
     *
     * @param ex the exception thrown
     * @param request
     * @return a ResponseEntity with a custom message
     */
    @ExceptionHandler(NoResultException.class)
    public ResponseEntity<Object> handleNoResultException(NoResultException ex, WebRequest request) {

        String developersErrorMessage = ex.getLocalizedMessage();

        if (developersErrorMessage == null) {
            developersErrorMessage = ex.toString();
        }


        RestApiMessageError apiError = new RestApiMessageError();
        apiError.setDateTimeError(new SimpleDateFormat(DATE_PATTERN).format(new Date()));
        apiError.setStatus(HttpStatus.NO_CONTENT.value());
        apiError.setDeveloperMessage(developersErrorMessage);
        apiError.setUserMessage("Nenhuma entidade encontrada.");

        return new ResponseEntity<>(apiError, new HttpHeaders(), HttpStatus.valueOf(apiError.getStatus()));
    }

    /**
     *
     * @param ex the exception thrown
     * @param request
     * @return a ResponseEntity with a custom message
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {

        String developersErrorMessage = ex.getLocalizedMessage();

        if (developersErrorMessage == null) {
            developersErrorMessage = ex.toString();
        }

        RestApiMessageError apiError = new RestApiMessageError();
        apiError.setDateTimeError(new SimpleDateFormat(DATE_PATTERN).format(new Date()));
        apiError.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        apiError.setDeveloperMessage(developersErrorMessage);
        apiError.setUserMessage("Ocorreu um erro ao tentar inserir os dados solicitados no banco de dados. " +
                "Favor entrar em contato com analista responsável.");

        return new ResponseEntity<>(apiError, new HttpHeaders(), HttpStatus.valueOf(apiError.getStatus()));
    }

}
