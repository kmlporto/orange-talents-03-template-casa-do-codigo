package br.com.zup.desafios.casadocodigo.localizacao.estado;

import br.com.zup.desafios.casadocodigo.localizacao.pais.Pais;
import br.com.zup.desafios.casadocodigo.validator.anotattion.UniqueValue;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoPersist {
    @NotBlank
    @UniqueValue(clazz = Estado.class, field = "nome")
    private String nome;
    @NotNull
    private Long pais_id;

    public Estado convert(Pais pais) {
        return new Estado(nome, pais);
    }

    public Long getPais_id() {
        return pais_id;
    }

    public EstadoPersist(@NotBlank String nome, @NotNull Long pais_id) {
        this.nome = nome;
        this.pais_id = pais_id;
    }
}
