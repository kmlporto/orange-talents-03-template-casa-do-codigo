package br.com.zup.desafios.casadocodigo.validator.anotattion;

import br.com.zup.desafios.casadocodigo.validator.ValidStateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidStateValidator.class)
@Target(value = {ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidState {
    String message() default "Estado inválido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
