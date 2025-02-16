package br.com.sancho.sistemadebatalhacompoo.entities;

// Classe para gerenciar as batalhas entre personagens
public class SistemaBatalha {
    private Personagem personagem1;
    private Personagem personagem2;
    private int turno;
    private boolean batalhaConcluida;

    // Construtor que recebe os dois personagens que irão duelar
    public SistemaBatalha(Personagem personagem1, Personagem personagem2) {
        this.personagem1 = personagem1;
        this.personagem2 = personagem2;
        this.turno = 1;
        this.batalhaConcluida = false;
    }

    // Método para iniciar a batalha
    public void iniciarBatalha() {
        System.out.println("\n=== INÍCIO DA BATALHA ===");
        System.out.println(personagem1.getNome() + " VS " + personagem2.getNome());
        mostrarStatusPersonagens();

        // Loop principal da batalha
        while (!batalhaConcluida) {
            System.out.println("\n=== TURNO " + turno + " ===");

            // Turno do primeiro personagem
            if (executarTurno(personagem1, personagem2)) {
                break;
            }

            // Turno do segundo personagem
            if (executarTurno(personagem2, personagem1)) {
                break;
            }

            turno++;
        }

        // Anuncia o vencedor
        anunciarVencedor();
    }

    // Método para executar um turno de ataque
    private boolean executarTurno(Personagem atacante, Personagem defensor) {
        System.out.println("\nVez de " + atacante.getNome() + " atacar!");

        // Verifica se o personagem pode usar ataque especial (a cada 3 turnos)
        if (turno % 3 == 0) {
            executarAtaqueEspecial(atacante, defensor);
        } else {
            atacante.atacar(defensor);
        }

        // Verifica se a batalha terminou
        if (!defensor.verificaVivo()) {
            batalhaConcluida = true;
            return true;
        }

        mostrarStatusPersonagens();
        return false;
    }

    // Método para executar ataque especial baseado na classe do personagem
    private void executarAtaqueEspecial(Personagem atacante, Personagem defensor) {
        System.out.println("!!! ATAQUE ESPECIAL DISPONÍVEL !!!");

        if (atacante instanceof Guerreiro) {
            ((Guerreiro) atacante).golpePoderoso(defensor);
        } else if (atacante instanceof Mago) {
            ((Mago) atacante).bolaDeFogo(defensor);
        } else if (atacante instanceof Arqueiro) {
            ((Arqueiro) atacante).flechaDupla(defensor);
        }
    }

    // Método para mostrar o status atual dos personagens
    private void mostrarStatusPersonagens() {
        System.out.println("\n--- Status dos Personagens ---");
        mostrarStatusPersonagem(personagem1);
        mostrarStatusPersonagem(personagem2);
    }

    // Método auxiliar para mostrar status de um personagem
    private void mostrarStatusPersonagem(Personagem personagem) {
        System.out.println(personagem.getNome() + " (" + personagem.getClasse() + "):");
        System.out.println("Vida: " + personagem.getVida());
        if (personagem.getVida() <= 0) {
            System.out.println(">>> DERROTADO <<<");
        }
    }

    // Método para anunciar o vencedor da batalha
    private void anunciarVencedor() {
        System.out.println("\n=== FIM DA BATALHA ===");
        System.out.println("Batalha concluída em " + turno + " turnos!");

        Personagem vencedor = personagem1.verificaVivo() ? personagem1 : personagem2;
        System.out.println("\n🏆 VENCEDOR: " + vencedor.getNome() + " 🏆");
        System.out.println("Vida restante: " + vencedor.getVida());
    }
}
