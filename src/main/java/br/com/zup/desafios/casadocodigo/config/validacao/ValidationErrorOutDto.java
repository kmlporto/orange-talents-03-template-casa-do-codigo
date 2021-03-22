package br.com.zup.desafios.casadocodigo.config.validacao;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorOutDto {
    private List<String> globalErrorMessages = new ArrayList<>();
    private List<FieldErrorOutDto> fieldErrors = new ArrayList<>();

    public void addError(String message){
        globalErrorMessages.add(message);
    }

    public void addFieldError(String field, String message){
        FieldErrorOutDto fieldError = new FieldErrorOutDto(field, message);
        fieldErrors.add(fieldError);
    }

    public List<String> getGlobalErrorMessages() {
        return globalErrorMessages;
    }

    public List<FieldErrorOutDto> getFieldErrors() {
        return fieldErrors;
    }
}
