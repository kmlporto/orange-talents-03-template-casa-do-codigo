package br.com.zup.desafios.casadocodigo.cliente;

import br.com.zup.desafios.casadocodigo.cliente.tipo.ClienteGroupSequenceProdiver;
import br.com.zup.desafios.casadocodigo.cliente.tipo.PessoaFisica;
import br.com.zup.desafios.casadocodigo.cliente.tipo.PessoaJuridica;
import br.com.zup.desafios.casadocodigo.cliente.tipo.TipoPessoa;
import br.com.zup.desafios.casadocodigo.localizacao.estado.Estado;
import br.com.zup.desafios.casadocodigo.localizacao.pais.Pais;
import br.com.zup.desafios.casadocodigo.validator.anotattion.ValidState;
import br.com.zup.desafios.casadocodigo.validator.anotattion.UniqueValue;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ValidState
@GroupSequenceProvider(value = ClienteGroupSequenceProdiver.class)
public class ClientePersist {
    @NotBlank
    @Email
    @UniqueValue(clazz = Cliente.class, field = "email")
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotNull
    @UniqueValue(clazz = Cliente.class, field = "documento")
    @CPF(groups = PessoaFisica.class)
    @CNPJ(groups = PessoaJuridica.class)
    private String documento;
    @NotNull
    private TipoPessoa tipoPessoa;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    private Long estado_id;
    @NotNull
    private Long pais_id;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Long getEstado_id() {
        return estado_id;
    }

    public void setEstado_id(Long estado_id) {
        this.estado_id = estado_id;
    }

    public Long getPais_id() {
        return pais_id;
    }

    public void setPais_id(Long pais_id) {
        this.pais_id = pais_id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Cliente convert(Estado estado, Pais pais) {
        return new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, estado, pais, telefone, cep);
    }
}
