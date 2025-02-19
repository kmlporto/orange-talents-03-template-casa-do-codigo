package br.com.zup.desafios.casadocodigo.localizacao.pais;

public class PaisResponse {
    private Long id;
    private String nome;

    public PaisResponse(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public static PaisResponse convert(Pais pais) {
        return new PaisResponse(pais.getId(), pais.getNome());
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
