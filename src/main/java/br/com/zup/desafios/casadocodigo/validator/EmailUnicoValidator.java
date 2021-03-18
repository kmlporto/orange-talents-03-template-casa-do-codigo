package br.com.zup.desafios.casadocodigo.validator;

import br.com.zup.desafios.casadocodigo.autor.AutorRepository;
import br.com.zup.desafios.casadocodigo.validator.anotattion.EmailUnico;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailUnicoValidator implements ConstraintValidator<EmailUnico, String> {

    private final AutorRepository repository;

    public EmailUnicoValidator(AutorRepository repository) {
        this.repository = repository;
    }

    @Override
    public void initialize(EmailUnico constraintAnnotation) {

    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return !repository.existsByEmail(email);
    }
}
