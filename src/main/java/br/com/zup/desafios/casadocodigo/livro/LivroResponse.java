package br.com.zup.desafios.casadocodigo.livro;

import java.time.LocalDateTime;

public class LivroResponse {
    private Long id;
    private String titulo;
    private String resumo;
    private String sumario;
    private Double preco;
    private Integer nPaginas;
    private String isbn;
    private LocalDateTime dataPublicacao;
    private Long categoria_id;
    private Long autor_id;

    public LivroResponse(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.nPaginas = livro.getnPaginas();
        this.isbn = livro.getIsbn();
        this.dataPublicacao = livro.getDataPublicacao();
        this.categoria_id = livro.getCategoria().getId();
        this.autor_id = livro.getAutor().getId();
    }

    public static LivroResponse convert(Livro livro) {
        return new LivroResponse(livro);
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getnPaginas() {
        return nPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDateTime getDataPublicacao() {
        return dataPublicacao;
    }

    public Long getCategoria_id() {
        return categoria_id;
    }

    public Long getAutor_id() {
        return autor_id;
    }
}
