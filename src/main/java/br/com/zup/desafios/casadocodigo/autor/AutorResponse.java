package br.com.zup.desafios.casadocodigo.autor;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AutorResponse implements Serializable {
    private Long id;
    private String nome;
    private String email;
    private String descricao;
    private LocalDateTime dataCriacao;

    public AutorResponse(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
        this.dataCriacao = autor.getDataCriacao();
    }

    public static AutorResponse convert(Autor autor){
        return new AutorResponse(autor);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}
