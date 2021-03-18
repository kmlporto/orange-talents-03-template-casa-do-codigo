package br.com.zup.desafios.casadocodigo.Categoria;

import br.com.zup.desafios.casadocodigo.validator.anotattion.NomeCategoriaUnico;

import javax.validation.constraints.NotBlank;

public class CategoriaPersist {
    @NomeCategoriaUnico
    @NotBlank
    private String nome;

    public Categoria convert() {
        return new Categoria(nome);
    }

    public String getNome() {
        return nome;
    }

}
