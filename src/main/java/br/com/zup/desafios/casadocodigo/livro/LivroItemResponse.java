package br.com.zup.desafios.casadocodigo.livro;

import org.springframework.data.domain.Page;

public class LivroItemResponse {
    private Long id;
    private String nome;

    public LivroItemResponse(Livro livro) {
        this.id = livro.getId();
        this.nome = livro.getTitulo();
    }

    public LivroItemResponse(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public static Page<LivroItemResponse> convert(Page<Livro> autorPage) {
        return autorPage.map(LivroItemResponse::new);
    }
}
