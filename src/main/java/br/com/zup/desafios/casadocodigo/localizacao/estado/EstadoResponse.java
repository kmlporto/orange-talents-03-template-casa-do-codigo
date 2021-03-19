package br.com.zup.desafios.casadocodigo.localizacao.estado;

public class EstadoResponse {
    private String nome;
    private Long pais_id;

    public EstadoResponse(Estado estado) {
        this.nome = estado.getNome();
        this.pais_id = estado.getPais().getId();
    }

    public static EstadoResponse convert(Estado estado) {
        return new EstadoResponse(estado);
    }

    public String getNome() {
        return nome;
    }

    public Long getPais_id() {
        return pais_id;
    }
}
