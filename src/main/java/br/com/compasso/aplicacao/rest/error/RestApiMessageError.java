package br.com.compasso.aplicacao.rest.error;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A custom message error class
 */
public class RestApiMessageError {

    @JsonProperty(value = "date_time_error")
    private String dateTimeError;
    @JsonProperty(value = "status_code")
    private int status;
    @JsonProperty("developer_message")
    private String developerMessage;
    @JsonProperty("user_message")
    private String userMessage;

    public RestApiMessageError() {
    }

    public RestApiMessageError(String dateTimeError, int status, String developerMessage, String userMessage) {
        this.dateTimeError = dateTimeError;
        this.status = status;
        this.developerMessage = developerMessage;
        this.userMessage = userMessage;
    }

    public String getDateTimeError() {
        return dateTimeError;
    }

    public void setDateTimeError(String dateTimeError) {
        this.dateTimeError = dateTimeError;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }
}
