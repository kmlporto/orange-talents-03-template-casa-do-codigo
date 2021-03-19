package br.com.zup.desafios.casadocodigo.localizacao.pais;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {

    private final PaisRepository paisRepository;

    public PaisController(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @PostMapping
    public ResponseEntity<PaisResponse> cadastra(@RequestBody @Valid PaisPersist paisPersist){
        Pais pais = paisRepository.save(paisPersist.convert());

        return new ResponseEntity<>(PaisResponse.convert(pais), HttpStatus.OK);
    }
}
