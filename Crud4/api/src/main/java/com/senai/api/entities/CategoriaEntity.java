package com.senai.api.entities;

public class CategoriaEntity {

    private long id;
    private String nomecat;

    public CategoriaEntity() {
        this.id = id;
        this.nomecat = nomecat;
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

    @Override
    public String toString() {
        return "CategoriaEntity{" +
                "id=" + id +
                ", nomecat='" + nomecat + '\'' +
                '}';
    }
}
