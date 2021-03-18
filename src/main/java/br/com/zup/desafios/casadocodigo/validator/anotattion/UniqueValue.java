package br.com.zup.desafios.casadocodigo.validator.anotattion;

import br.com.zup.desafios.casadocodigo.validator.UniqueValueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueValueValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UniqueValue {

    String message() default "Esse valor deve ser único, já existe no banco um registro com esse valor";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    Class<?> clazz();

    String field();

}
