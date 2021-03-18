package br.com.zup.desafios.casadocodigo.validator.anotattion;

import br.com.zup.desafios.casadocodigo.validator.EmailUnicoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EmailUnicoValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailUnico {
    String message() default "E-mail já cadastrado";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
