package br.com.zup.desafios.casadocodigo.livro;

import br.com.zup.desafios.casadocodigo.Categoria.CategoriaRepository;
import br.com.zup.desafios.casadocodigo.autor.AutorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroRepository livroRepository;
    private final CategoriaRepository categoriaRepository;
    private final AutorRepository autorRepository;

    public LivroController(LivroRepository livroRepository, CategoriaRepository categoriaRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.categoriaRepository = categoriaRepository;
        this.autorRepository = autorRepository;
    }

    @PostMapping
    public ResponseEntity<LivroResponse> cadastra(@RequestBody @Valid LivroPersist livroPersist){
        if(!autorRepository.existsById(livroPersist.getAutor_id()) || !categoriaRepository.existsById(livroPersist.getCategoria_id())){
            return ResponseEntity.badRequest().build();
        }

        Livro livro = livroRepository.save(livroPersist.convert(autorRepository, categoriaRepository));

        return new ResponseEntity<>(LivroResponse.convert(livro), HttpStatus.OK);
    }

}
