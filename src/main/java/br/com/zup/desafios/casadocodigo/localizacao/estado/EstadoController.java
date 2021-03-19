package br.com.zup.desafios.casadocodigo.localizacao.estado;

import br.com.zup.desafios.casadocodigo.localizacao.pais.Pais;
import br.com.zup.desafios.casadocodigo.localizacao.pais.PaisRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    private final EstadoRepository estadoRepository;
    private final PaisRepository paisRepository;

    public EstadoController(EstadoRepository estadoRepository, PaisRepository paisRepository) {
        this.estadoRepository = estadoRepository;
        this.paisRepository = paisRepository;
    }

    @PostMapping
    public ResponseEntity<EstadoResponse> cadastra(@RequestBody @Valid EstadoPersist estadoPersist){
        if(!paisRepository.existsById(estadoPersist.getPais_id())){
            return ResponseEntity.notFound().build();
        }
        Pais pais = paisRepository.getOne(estadoPersist.getPais_id());
        Estado estado = estadoRepository.save(estadoPersist.convert(pais));

        return new ResponseEntity<>(EstadoResponse.convert(estado), HttpStatus.OK);
    }
}
