package br.com.zup.desafios.casadocodigo.livro;

import br.com.zup.desafios.casadocodigo.Categoria.Categoria;
import br.com.zup.desafios.casadocodigo.Categoria.CategoriaRepository;
import br.com.zup.desafios.casadocodigo.autor.Autor;
import br.com.zup.desafios.casadocodigo.autor.AutorRepository;
import br.com.zup.desafios.casadocodigo.validator.anotattion.UniqueValue;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class LivroPersist {
    @NotBlank
    @UniqueValue(clazz = Livro.class, field = "titulo")
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    @NotBlank
    @Size(max = 500)
    private String sumario;
    @NotNull
    @Min(20)
    private Double preco;
    @NotNull
    @Min(100)
    private Integer nPaginas;
    @NotBlank
    @UniqueValue(clazz = Livro.class, field = "isbn")
    private String isbn;
    @NotNull
    @Future
    private LocalDateTime dataPublicacao;
    @NotNull
    private Long categoria_id;
    @NotNull
    private Long autor_id;

    public Livro convert(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
        Autor autor = autorRepository.getOne(autor_id);
        Categoria categoria = categoriaRepository.getOne(categoria_id);

        return new Livro(titulo, resumo, sumario, preco, nPaginas, isbn, dataPublicacao, autor, categoria);
    }

    public LivroPersist(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank @Size(max = 500) String sumario, @NotNull @Min(20) Double preco, @NotNull @Min(100) Integer nPaginas, @NotBlank String isbn, @NotNull @Future LocalDateTime dataPublicacao, @NotNull Long categoria_id, @NotNull Long autor_id) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.nPaginas = nPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria_id = categoria_id;
        this.autor_id = autor_id;
    }

    public Long getCategoria_id() {
        return categoria_id;
    }
    public Long getAutor_id() {
        return autor_id;
    }
}
