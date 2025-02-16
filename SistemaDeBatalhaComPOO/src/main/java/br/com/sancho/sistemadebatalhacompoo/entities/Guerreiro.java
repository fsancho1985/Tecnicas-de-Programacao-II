package br.com.sancho.sistemadebatalhacompoo.entities;

public class Guerreiro extends Personagem {

    public Guerreiro(String nome, String classe, int vida, int ataqueMin, int ataqueMax, int defesa) {
        super(nome, "Guerreiro", vida, ataqueMin, ataqueMax, defesa);
    }

    public void golpePoderoso(Personagem inimigo) {
        if (!this.verificaVivo() || !inimigo.verificaVivo()) {
            System.out.println("Um dos personagem está derrotado");
            return;
        }

        int danoBase = (int) (Math.random() * (getAtaqueMax() - getAtaqueMin() + 1) + getAtaqueMin());
        int danoAumentado = (int) (danoBase * 1.3);

        int danoFinal = (int) (danoAumentado - inimigo.getDefesa());

        inimigo.receberDano(danoFinal);

        System.out.println(getNome() + " usou Golpe Poderoso em " + inimigo.getNome());
        System.out.println("Dano base: " + danoBase + " | Dano aumentado: " + danoAumentado + " | Defesa: " + inimigo.getDefesa() + " | Dano final: " + danoFinal);
        System.out.println("Vida restante de " + inimigo.getNome() + ": " + inimigo.getVida());
    }
}
