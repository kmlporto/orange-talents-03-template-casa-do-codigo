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

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getDescricaoAutor() {
        return descricaoAutor;
    }

    public void setDescricaoAutor(String descricaoAutor) {
        this.descricaoAutor = descricaoAutor;
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
}
