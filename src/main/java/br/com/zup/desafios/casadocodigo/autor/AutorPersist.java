package br.com.zup.desafios.casadocodigo.autor;

import br.com.zup.desafios.casadocodigo.validator.anotattion.EmailUnico;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorPersist {
    @NotBlank
    private String nome;
    @Email
    @NotBlank
    @EmailUnico
    private String email;
    @NotBlank
    @Size(max = 200)
    private String descricao;

    public Autor convert() {
        return new Autor(nome, email, descricao);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
