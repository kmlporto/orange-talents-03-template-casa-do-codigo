package br.com.zup.desafios.casadocodigo.livro;

import java.time.LocalDateTime;

public class LivroDetailResponse {

    private String titulo;
    private String resumo;
    private String sumario;
    private String nomeAutor;
    private String descricaoAutor;
    private Double preco;
    private Integer nPaginas;
    private String isbn;
    private LocalDateTime dataPublicacao;

    public LivroDetailResponse(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.nomeAutor = livro.getAutor().getNome();
        this.descricaoAutor = livro.getAutor().getDescricao();
        this.preco = livro.getPreco();
        this.nPaginas = livro.getnPaginas();
        this.isbn = livro.getIsbn();
        this.dataPublicacao = livro.getDataPublicacao();
    }

    public static LivroDetailResponse convert(Livro livro) {
        return new LivroDetailResponse(livro);
    }

    public LivroDetailResponse(String titulo, String resumo, String sumario, String nomeAutor, String descricaoAutor, Double preco, Integer nPaginas, String isbn, LocalDateTime dataPublicacao) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.nomeAutor = nomeAutor;
        this.descricaoAutor = descricaoAutor;
        this.preco = preco;
        this.nPaginas = nPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
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

    public String getNomeAutor() {
        return nomeAutor;
    }

    public String getDescricaoAutor() {
        return descricaoAutor;
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
}
