package com.senai.api.dtos;

public class SenhaDto {

    private String senhaatual;
    private String senhanova;
    private String senhanovaconfirmar;

    public String getSenhaatual() {
        return senhaatual;
    }

    public String getSenhanova() {
        return senhanova;
    }

    public String getSenhanovaconfirmar() {
        return senhanovaconfirmar;
    }

    public void setSenhaatual(String senhaatual) {
        this.senhaatual = senhaatual;
    }

    public void setSenhanova(String senhanova) {
        this.senhanova = senhanova;
    }

    public void setSenhanovaconfirmar(String senhanovaconfirmar) {
        this.senhanovaconfirmar = senhanovaconfirmar;
    }

    @Override
    public String toString() {
        return "SenhaDto{" +
                "senhaatual='" + senhaatual + '\'' +
                ", senhanova='" + senhanova + '\'' +
                ", senhanovaconfirmar='" + senhanovaconfirmar + '\'' +
                '}';
    }
}
