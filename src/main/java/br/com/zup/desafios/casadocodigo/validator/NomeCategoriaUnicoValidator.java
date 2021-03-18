package br.com.zup.desafios.casadocodigo.validator;

import br.com.zup.desafios.casadocodigo.Categoria.CategoriaRepository;
import br.com.zup.desafios.casadocodigo.validator.anotattion.NomeCategoriaUnico;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NomeCategoriaUnicoValidator implements ConstraintValidator<NomeCategoriaUnico, String> {

    private final CategoriaRepository repository;

    public NomeCategoriaUnicoValidator(CategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void initialize(NomeCategoriaUnico constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return !repository.existsByNome(s);
    }
}
