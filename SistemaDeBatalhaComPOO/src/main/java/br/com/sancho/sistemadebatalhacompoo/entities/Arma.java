package br.com.sancho.sistemadebatalhacompoo.entities;

public class Arma {
    private String nome;
    private int danoExtra;

    public Arma(String nome, int danoExtra) {
        this.nome = nome;
        this.danoExtra = danoExtra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDanoExtra() {
        return danoExtra;
    }

    public void setDanoExtra(int danoExtra) {
        this.danoExtra = danoExtra;
    }
}

