package br.com.zup.desafios.casadocodigo.cliente;

import br.com.zup.desafios.casadocodigo.localizacao.estado.Estado;
import br.com.zup.desafios.casadocodigo.localizacao.pais.Pais;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String sobrenome;
    @Column(unique=true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String documento;
    @Column(nullable = false)
    private String endereco;
    @Column(nullable = false)
    private String complemento;
    @Column(nullable = false)
    private String cidade;
    @ManyToOne
    private Estado estado;
    @ManyToOne(optional = false)
    private Pais pais;
    @Column(nullable = false)
    private String telefone;
    @Column(nullable = false)
    private String cep;

    public Cliente(String email, String nome, String sobrenome, String documento, String endereco, String complemento, String cidade, Estado estado, Pais pais, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.telefone = telefone;
        this.cep = cep;
    }

    @Deprecated
    public Cliente() {

    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public Pais getPais() {
        return pais;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }
}
