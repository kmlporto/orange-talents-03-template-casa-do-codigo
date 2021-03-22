package br.com.zup.desafios.casadocodigo.autor;

import br.com.zup.desafios.casadocodigo.validator.anotattion.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorPersist {
    @NotBlank
    private String nome;
    @Email
    @NotBlank
    @UniqueValue(clazz = Autor.class, field = "email")
    private String email;
    @NotBlank
    @Size(max = 200)
    private String descricao;

    public Autor convert() {
        return new Autor(nome, email, descricao);
    }

    public AutorPersist(@NotBlank String nome, @Email @NotBlank String email, @NotBlank @Size(max = 200) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }
}
