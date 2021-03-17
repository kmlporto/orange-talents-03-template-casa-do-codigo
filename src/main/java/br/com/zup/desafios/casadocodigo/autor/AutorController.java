package br.com.zup.desafios.casadocodigo.autor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/autores")
public class AutorController {

    private final AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping
    public ResponseEntity<AutorResponse> cadastra(@RequestBody @Valid AutorPersist autorPerist){
        Autor autor = autorRepository.save(autorPerist.convert());
        return new ResponseEntity<>(AutorResponse.convert(autor), HttpStatus.OK);
    }
}
