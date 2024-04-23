package arena;

import racas.Personagens;

// import java.lang.reflect.InvocationTargetException;
// import java.lang.reflect.Method;
import java.util.function.Supplier;

import errors.InsufficientLevel;
import errors.NotEnoughLife;
import models.Duelo;

public class Arena implements Duelo {
  private Personagens jogadorX;
  private Personagens jogadorY;
  private Personagens proximoJogador;

  public Arena(Personagens jogadorX, Personagens jogadorY) {
    this.jogadorX = jogadorX;
    this.jogadorY = jogadorY;
    this.proximoJogador = jogadorX;
  }

  public String combate(Personagens atacante, Supplier<Integer> ataque)
      throws NotEnoughLife, InsufficientLevel {

    // Verifica se a vida do personagem é menor que 50
    if (jogadorX.getVida() < 50 || jogadorY.getVida() < 50) {
      throw new NotEnoughLife("Você está com menos de 50 de vida e não pode duelar!");
    }

    // Verifica se o nível do personagem é menor que 10
    if (jogadorX.getLevel() < 10 || jogadorY.getLevel() < 10) {
      throw new InsufficientLevel("Apenas personagens de nível 10 ou superior podem duelar na arena!");
    }

    // Verifica se a vida de um dos jogadores já é menor ou igual a zero
    if (jogadorX.getVida() <= 0 || jogadorY.getVida() <= 0) {
      // Verifica quem foi o vencedor
      Personagens vencedor = (jogadorX.getVida() <= 0) ? jogadorY : jogadorX;
      return "A partida acabou! O vencedor é: " + vencedor.getNome();
    }

    // de quem é a vez
    if (atacante != proximoJogador) {
      return "Aguarde o seu turno!";
    }

    // quem é o oponente
    Personagens oponente = (atacante == jogadorX) ? jogadorY : jogadorX;

    // Realiza o ataque
    int dano = ataque.get();
    oponente.receberDano(dano);

    // Verifica se o oponente foi derrotado
    if (oponente.getVida() <= 0) {
      // Encerra a partida e declara o vencedor
      return oponente.getNome() + " foi derrotado! A partida acabou com a vitória de " + atacante.getNome() + "!";
    }

    // Alterna o próximo jogador
    proximoJogador = (proximoJogador == jogadorX) ? jogadorY : jogadorX;

    // Retorna o resultado do ataque
    return atacante.getNome() + " atacou " + oponente.getNome() + " com a magia causando " + dano
        + " de dano. Próximo turno: " + proximoJogador.getNome();
  }
}
