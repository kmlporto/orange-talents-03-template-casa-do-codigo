package br.com.zup.desafios.casadocodigo.localizacao.pais;

import br.com.zup.desafios.casadocodigo.validator.anotattion.UniqueValue;

import javax.validation.constraints.NotBlank;

public class PaisPersist {
    @NotBlank
    @UniqueValue(clazz = Pais.class, field = "nome")
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Pais convert() {
        return new Pais(nome);
    }

}
