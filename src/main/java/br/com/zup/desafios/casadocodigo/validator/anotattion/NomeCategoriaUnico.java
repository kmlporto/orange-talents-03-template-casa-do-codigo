package br.com.zup.desafios.casadocodigo.validator.anotattion;

import br.com.zup.desafios.casadocodigo.validator.NomeCategoriaUnicoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = NomeCategoriaUnicoValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NomeCategoriaUnico {
    String message() default "Já existe categoria com esse nome";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
