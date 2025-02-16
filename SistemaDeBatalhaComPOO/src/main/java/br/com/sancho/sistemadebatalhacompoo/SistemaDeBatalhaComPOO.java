package br.com.sancho.sistemadebatalhacompoo;

import br.com.sancho.sistemadebatalhacompoo.entities.*;

public class SistemaDeBatalhaComPOO {

    public static void main(String[] args) {

        Arma espadaLonga = new Arma("Espada Longa", 5);
        Arma cajadoArcano = new Arma("Cajado Arcano", 8);
        Arma arcoElfico = new Arma("Arco Élfico", 7);

        Guerreiro guerreiro = new Guerreiro("Conan", "Guerreiro", 100, 5, 25, 8);
        Mago mago = new Mago("Gandalf", "Mago", 100, 5, 30, 3);
        Arqueiro arqueiro = new Arqueiro("Legolas", "Arqueiro", 100, 5, 16, 10);

        guerreiro.equiparArma(espadaLonga);
        mago.equiparArma(cajadoArcano);
        arqueiro.equiparArma(arcoElfico);

        SistemaBatalha batalha = new SistemaBatalha(mago, arqueiro);
        batalha.iniciarBatalha();
    }
}
