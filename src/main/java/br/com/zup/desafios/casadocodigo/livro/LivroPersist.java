package br.com.zup.desafios.casadocodigo.livro;

import br.com.zup.desafios.casadocodigo.Categoria.Categoria;
import br.com.zup.desafios.casadocodigo.Categoria.CategoriaRepository;
import br.com.zup.desafios.casadocodigo.autor.Autor;
import br.com.zup.desafios.casadocodigo.autor.AutorRepository;
import br.com.zup.desafios.casadocodigo.validator.anotattion.UniqueValue;
import org.springframework.beans.factory.annotation.Autowired;

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

    public LivroPersist() {
    }

    public Livro convert(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
        Autor autor = autorRepository.getOne(autor_id);
        Categoria categoria = categoriaRepository.getOne(categoria_id);

        return new Livro(titulo, resumo, sumario, preco, nPaginas, isbn, dataPublicacao, autor, categoria);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getnPaginas() {
        return nPaginas;
    }

    public void setnPaginas(Integer nPaginas) {
        this.nPaginas = nPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDateTime getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDateTime dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Long getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(Long categoria_id) {
        this.categoria_id = categoria_id;
    }

    public Long getAutor_id() {
        return autor_id;
    }

    public void setAutor_id(Long autor_id) {
        this.autor_id = autor_id;
    }
}
