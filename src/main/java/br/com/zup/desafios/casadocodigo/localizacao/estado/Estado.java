package br.com.zup.desafios.casadocodigo.localizacao.estado;

import br.com.zup.desafios.casadocodigo.localizacao.pais.Pais;

import javax.persistence.*;

@Entity
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String nome;
    @ManyToOne
    private Pais pais;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }

    @Deprecated
    public Estado() {

    }

    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

}
