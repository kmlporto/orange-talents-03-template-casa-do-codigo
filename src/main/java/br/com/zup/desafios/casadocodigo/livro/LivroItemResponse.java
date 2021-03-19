package br.com.zup.desafios.casadocodigo.livro;

import org.springframework.data.domain.Page;

public class LivroItemResponse {
    private Long id;
    private String nome;

    public LivroItemResponse(Livro livro) {
        this.id = livro.getId();
        this.nome = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static Page<LivroItemResponse> convert(Page<Livro> autorPage) {
        return autorPage.map(LivroItemResponse::new);
    }
}
