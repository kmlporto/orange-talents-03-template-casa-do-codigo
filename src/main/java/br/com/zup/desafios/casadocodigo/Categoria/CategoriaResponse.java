package br.com.zup.desafios.casadocodigo.Categoria;

public class CategoriaResponse {
    private Long id;
    private String nome;

    public CategoriaResponse(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }

    public static CategoriaResponse convert(Categoria categoria) {
        return new CategoriaResponse(categoria);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
