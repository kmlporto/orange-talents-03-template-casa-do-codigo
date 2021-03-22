package br.com.zup.desafios.casadocodigo.validator;

import br.com.zup.desafios.casadocodigo.cliente.ClientePersist;
import br.com.zup.desafios.casadocodigo.localizacao.estado.EstadoRepository;
import br.com.zup.desafios.casadocodigo.localizacao.pais.Pais;
import br.com.zup.desafios.casadocodigo.localizacao.pais.PaisRepository;
import br.com.zup.desafios.casadocodigo.validator.anotattion.ValidState;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class ValidStateValidator implements ConstraintValidator<ValidState, ClientePersist> {
    private final PaisRepository paisRepository;
    private final EstadoRepository estadoRepository;

    public ValidStateValidator(PaisRepository paisRepository, EstadoRepository estadoRepository) {
        this.paisRepository = paisRepository;
        this.estadoRepository = estadoRepository;
    }

    @Override
    public void initialize(ValidState validState) {
    }

    @Override
    public boolean isValid(ClientePersist persist, ConstraintValidatorContext constraintValidatorContext) {
        if(!paisRepository.existsById(persist.getPais_id()))
            return false;
        Pais pais = paisRepository.getOne(persist.getPais_id());
        if(Objects.isNull(pais.getEstados()) && Objects.isNull(persist.getEstado_id()))
            return true;
        return estadoRepository.existsByIdAndPais_Id(persist.getEstado_id(), persist.getPais_id());
    }
}
