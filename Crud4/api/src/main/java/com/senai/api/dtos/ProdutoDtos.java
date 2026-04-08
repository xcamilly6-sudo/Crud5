package com.senai.api.dtos;

public class ProdutoDtos {

    private long id;
    private String nomecat;
    private double preco;
    private long categoriaId;

    public ProdutoDtos() {
    }

    public long getId() {
        return id;
    }

    public String getNomecat() {
        return nomecat;
    }

    public double getPreco() {
        return preco;
    }

    public long getCategoriaId() {
        return categoriaId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNomecat(String nomecat) {
        this.nomecat = nomecat;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setCategoriaId(long categoriaId) {
        this.categoriaId = categoriaId;
    }


}
