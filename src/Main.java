import arena.Arena;
import aventura.Aventura;
import racas.Anoes;
import racas.Elfos;
import racas.Monstro;
import racas.Personagens;

public class Main {
  public static void main(String[] args) {
    Personagens jogador = new Personagens("Herói", 4000, 30, 40, 20, 25, 1);
    Monstro monstro = new Monstro("Dragão", 100, 50, 10, 15, 20, 1);

    // Iniciando a aventura com o jogador
    Aventura aventura = new Aventura(jogador);

    // Realizando a batalha até que um dos personagens seja derrotado
    while (jogador.getVida() > 0 && monstro.getVida() > 0) {
      // Jogador ataca o monstro
      aventura.lutar_contra_monstro(monstro);
      // Monstro ataca o jogador
      aventura.lutaEpica(monstro);
    }

    // Verificando quem venceu a batalha
    if (jogador.getVida() <= 0) {
      System.out.println("Você foi derrotado na batalha!");
    } else {
      System.out.println("Você derrotou o " + monstro.getNome() + "!");
    }
  }
}
