package br.com.zup.desafios.casadocodigo.config.validacao;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ErroValidacaoHandler {

    private final MessageSource messageSource;

    public ErroValidacaoHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidationErrorOutDto handle(MethodArgumentNotValidException exception){
        List<ObjectError> globalErrors = exception.getBindingResult().getGlobalErrors();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        return buildValidationError(globalErrors, fieldErrors);
    }

    private ValidationErrorOutDto buildValidationError(List<ObjectError> globalErrors, List<FieldError> fieldErrors){
        ValidationErrorOutDto validationErrors = new ValidationErrorOutDto();
        globalErrors.forEach(error -> validationErrors.addError(getErrorMessage(error)));
        fieldErrors.forEach(error -> validationErrors.addFieldError(error.getField(), getErrorMessage(error)));

        return validationErrors;
    }
    private String getErrorMessage(ObjectError error){
        return messageSource.getMessage(error, LocaleContextHolder.getLocale());
    }

}
