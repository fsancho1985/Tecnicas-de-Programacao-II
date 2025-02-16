package br.com.sancho.sistemadebatalhacompoo.entities;

public class Mago extends Personagem {

    public Mago(String nome, String classe, int vida, int ataqueMin, int ataqueMax, int defesa) {
        super(nome, "Mago", vida, ataqueMin, ataqueMax, defesa);
    }

    public void bolaDeFogo(Personagem inimigo) {
        if (!this.verificaVivo() || !inimigo.verificaVivo()) {
            System.out.println("Um dos personagem já está derrotado");
            return;
        }

        int dano = getAtaqueMax();

        inimigo.receberDano(dano);

        System.out.println(getNome() + " lançou golpe especial Bola de fogo em " + inimigo.getNome() + " causando " + dano + " de dano.");
        System.out.println("Vida restante de " + inimigo.getNome() + ": " + inimigo.getVida());
    }
}
