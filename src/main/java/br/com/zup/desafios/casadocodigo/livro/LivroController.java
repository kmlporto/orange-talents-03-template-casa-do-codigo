package br.com.zup.desafios.casadocodigo.livro;

import br.com.zup.desafios.casadocodigo.Categoria.CategoriaRepository;
import br.com.zup.desafios.casadocodigo.autor.AutorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

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

        return ResponseEntity.ok(LivroResponse.convert(livro));
    }

    @GetMapping
    public ResponseEntity<Page<LivroItemResponse>> lista(Pageable pageable){
        Page<Livro> autorPage = livroRepository.findAll(pageable);

        return ResponseEntity.ok(LivroItemResponse.convert(autorPage));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDetailResponse> consulta(@PathVariable Long id){
        Optional<Livro> optionalLivro = livroRepository.findById(id);
        if(!optionalLivro.isPresent()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(LivroDetailResponse.convert(optionalLivro.get()));
    }
}
