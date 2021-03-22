package br.com.zup.desafios.casadocodigo.config.validacao;

public class FieldErrorOutDto {

    private String field;
    private String message;


    public FieldErrorOutDto(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}
