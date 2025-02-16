package br.com.sancho.sistemadebatalhacompoo.entities;

import java.util.Random;

public class Personagem {

    private String nome;
    private String classe;
    private int vida;
    private int ataqueMin;
    private int ataqueMax;
    private int defesa;
    private Arma armaEquipada;

    public Personagem(String nome, String classe, int vida, int ataqueMin, int ataqueMax, int defesa) {
        this.nome = nome;
        this.classe = classe;
        this.vida = vida;
        this.ataqueMin = ataqueMin;
        this.ataqueMax = ataqueMax;
        this.defesa = defesa;
        this.armaEquipada = null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaqueMin() {
        return ataqueMin;
    }

    public void setAtaqueMin(int ataqueMin) {
        this.ataqueMin = ataqueMin;
    }

    public int getAtaqueMax() {
        return ataqueMax;
    }

    public void setAtaqueMax(int ataqueMax) {
        this.ataqueMax = ataqueMax;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public boolean verificaVivo() {
        return vida > 0;
    }

    public void atacar(Personagem inimigo) {
        if(!this.verificaVivo() || !inimigo.verificaVivo()) {
            System.out.println("Um dos personagens está morto");
            return;
        }

        int danoBase = (int) (Math.random() * (ataqueMax - ataqueMin + 1) + ataqueMin);

        int danoComArma = calcularDanoTotal(danoBase);

        int danoReduzido = Math.max(1, danoBase - inimigo.getDefesa());

        inimigo.receberDano(danoReduzido);

        System.out.println(this.nome + " atacou " + inimigo.getNome());
        System.out.println("Dano base: " + danoBase + " | Defesa: " + inimigo.getDefesa() + " | dano final: " + danoReduzido);
        System.out.println("Vida restante de " + inimigo.getNome() + ": " + inimigo.getVida());
    }

    public void receberDano(int dano) {
        this.vida = Math.max(0, this.vida - dano);
    }

    public void equiparArma(Arma arma) {
        if (arma == null) {
            System.out.println(this.nome = "desequipou" + (this.armaEquipada != null ? this.armaEquipada.getNome() : "a arma"));
        } else {
            System.out.println(this.nome + " equipou " + arma.getNome() + " (+" + arma.getDanoExtra() + " de dano");
        }
        this.armaEquipada = arma;
    }

    private int calcularDanoTotal(int danoBase) {
        int danoTotal = danoBase;
        if (armaEquipada != null) {
            danoTotal += armaEquipada.getDanoExtra();
        }
        return danoTotal;
    }
}
