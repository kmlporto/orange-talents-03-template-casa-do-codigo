package br.com.zup.desafios.casadocodigo.autor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique=true)
    private String email;
    private String descricao;
    private LocalDateTime dataCriacao = LocalDateTime.now();

    public Autor() {
    }

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
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
