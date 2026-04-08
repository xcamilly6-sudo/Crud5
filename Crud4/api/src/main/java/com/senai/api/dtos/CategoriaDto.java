package com.senai.api.dtos;

public class CategoriaDto {

    private long id;
    private String nomecat;

    public CategoriaDto() {
    }

    public long getId() {
        return id;
    }

    public String getNomecat() {
        return nomecat;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNomecat(String nomecat) {
        this.nomecat = nomecat;
    }
}
