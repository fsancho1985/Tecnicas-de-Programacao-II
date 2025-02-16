package br.com.sancho.sistemadebatalhacompoo.entities;

public class Arqueiro extends Personagem {
    public Arqueiro(String nome, String classe, int vida, int ataqueMin, int ataqueMax, int defesa) {
        super(nome, "Arqueiro", vida, ataqueMin, ataqueMax, defesa);
    }

    public void flechaDupla(Personagem inimigo) {
        if (!this.verificaVivo() || !inimigo.verificaVivo()) {
            System.out.println("Um dos personagens já foi derrotado");
            return;
        }

        int danoBase = getAtaqueMin();
        int danoFinal = Math.max(1, danoBase - inimigo.getDefesa());

        inimigo.receberDano(danoFinal);
        int danoTotal = danoFinal;

        if (inimigo.verificaVivo()) {
            int danoFinal2 = Math.max(1, danoBase - inimigo.getDefesa());
            inimigo.receberDano(danoFinal2);
            danoTotal += danoFinal2;
        }

        System.out.println(getNome() + " atacou utilizando Flecha Dupla em " + inimigo.getNome());
        System.out.println("Dano base por flecha: " + danoBase + " | Defesa: " + inimigo.getDefesa() + " | Dano total após defesa: " + danoTotal);
        System.out.println("Vida restante do " + inimigo.getNome() + ": " + inimigo.getVida());
    }
}
