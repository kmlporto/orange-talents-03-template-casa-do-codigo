package br.com.zup.desafios.casadocodigo.Categoria;

import br.com.zup.desafios.casadocodigo.validator.anotattion.UniqueValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class CategoriaPersist {
    @UniqueValue(clazz = Categoria.class, field = "nome")
    @NotBlank
    private String nome;

    public Categoria convert() {
        return new Categoria(nome);
    }

    @JsonCreator
    public CategoriaPersist(@JsonProperty("nome") @NotBlank String nome) {
        this.nome = nome;
    }
}
