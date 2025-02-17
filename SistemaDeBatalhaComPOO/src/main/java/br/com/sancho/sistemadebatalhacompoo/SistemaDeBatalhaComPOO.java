package br.com.sancho.sistemadebatalhacompoo;

import br.com.sancho.sistemadebatalhacompoo.entities.*;

public class SistemaDeBatalhaComPOO {

    public static void main(String[] args) {

        Arma emeraldSword = new Arma("Emerald Sword", 5);
        Arma CajadoDoMagoBranco = new Arma("Cajado do Mago Branco", 8);
        Arma arcoElfico = new Arma("Arco Élfico", 7);

        Guerreiro guerreiro = new Guerreiro("Conan", "Guerreiro", 100, 5, 25, 8);
        Mago mago = new Mago("Gandalf", "Mago", 100, 5, 30, 3);
        Arqueiro arqueiro = new Arqueiro("Robbin Hood", "Arqueiro", 100, 5, 16, 10);

        guerreiro.equiparArma(emeraldSword);
        mago.equiparArma(CajadoDoMagoBranco);
        arqueiro.equiparArma(arcoElfico);

        SistemaBatalha batalha = new SistemaBatalha(mago, arqueiro);
        batalha.iniciarBatalha();
    }
}
