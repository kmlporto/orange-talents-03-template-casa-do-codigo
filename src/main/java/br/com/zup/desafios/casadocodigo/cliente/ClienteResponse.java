package br.com.zup.desafios.casadocodigo.cliente;

public class ClienteResponse {
    private String email;
    private String nome;
    private String sobrenome;
    private String documento;
    private String endereco;
    private String complemento;
    private String cidade;
    private Long estado_id;
    private Long pais_id;
    private String telefone;
    private String cep;

    public ClienteResponse(Cliente cliente) {
        this.email = cliente.getEmail();
        this.nome = cliente.getNome();
        this.sobrenome = cliente.getSobrenome();
        this.documento = cliente.getDocumento();
        this.endereco = cliente.getEndereco();
        this.complemento = cliente.getComplemento();
        this.cidade = cliente.getCidade();
        this.estado_id = cliente.getEstado().getId();
        this.pais_id = cliente.getPais().getId();
        this.telefone = cliente.getTelefone();
        this.cep = cliente.getCep();
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

    public Long getEstado_id() {
        return estado_id;
    }

    public Long getPais_id() {
        return pais_id;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public static ClienteResponse convert(Cliente cliente) {
        return new ClienteResponse(cliente);
    }

}
