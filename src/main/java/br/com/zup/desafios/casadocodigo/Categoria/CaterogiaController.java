package br.com.zup.desafios.casadocodigo.Categoria;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CaterogiaController {

    private final CategoriaRepository categoriaRepository;

    public CaterogiaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping
    public ResponseEntity<CategoriaResponse> cadastra(@RequestBody @Valid CategoriaPersist categoriaPersist){
        Categoria categoria = categoriaRepository.save(categoriaPersist.convert());

        return new ResponseEntity<>(CategoriaResponse.convert(categoria), HttpStatus.OK);
    }
}
