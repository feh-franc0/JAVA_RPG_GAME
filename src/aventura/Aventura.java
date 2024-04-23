package aventura;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;

import racas.Monstro;
import racas.Personagens;

public class Aventura {
  public Personagens jogador;
  private Personagens proximoJogador;

  public Aventura(Personagens jogador) {
    this.jogador = jogador;
    this.proximoJogador = jogador;
  }

  // Método para simular a possibilidade de encontrar objetos mágicos
  public void encontrarObjetoMagico() {
    Random random = new Random();
    // Simula uma chance de 30% de encontrar um objeto mágico
    if (random.nextDouble() < 0.3) {
      String[] objetosMagicos = { "Varinha Mágica", "Anel do Poder", "Pergaminho Encantado" };
      String objetoEncontrado = objetosMagicos[random.nextInt(objetosMagicos.length)];
      jogador.mochila.add(objetoEncontrado);
      System.out.println("Você encontrou um objeto mágico: " + objetoEncontrado);
    } else {
      System.out.println("Você não encontrou nenhum objeto mágico desta vez.");
    }
  }

  // monstro batendo
  public Object lutar_contra_monstro(Monstro monstro) {
    return lutar_contra_monstro(monstro, monstro::ataque_basico);
  }

  // personagem batendo
  public Object lutar_contra_monstro(Monstro monstro, Supplier<Integer> ataque) {

    if (jogador.getVida() <= 0 || monstro.getVida() <= 0) {
      Personagens vencedor = (jogador.getVida() <= 0) ? monstro : jogador;
      return "A partida acabou! O vencedor é: " + vencedor.getNome();
    }

    // TODO: de quem é a vez
    if (monstro != proximoJogador) {
      return "Aguarde o seu turno!";
    }

    if (jogador == proximoJogador) {
      this.proximoJogador = monstro;
    }

    if (monstro == proximoJogador) {
      this.proximoJogador = jogador;
    }

    Personagens oponente = (this.proximoJogador == jogador) ? monstro : jogador;

    // Realiza o ataque
    int dano = ataque.get();
    oponente.receberDano(dano);

    if (oponente.getVida() <= 0) {
      // Encerra a partida e declara o vencedor
      return oponente.getNome() + " foi derrotado! A partida acabou com a vitória de " + proximoJogador.getNome() + "!";
    }

    String mensagem_do_combate = proximoJogador.getNome() + " atacou " + oponente.getNome() + " com a magia causando "
        + dano
        + " de dano. Próximo turno: " + proximoJogador.getNome();
    int experiencia = 100;

    Map<String, Object> resultado = new HashMap<>();
    resultado.put("mensagem", mensagem_do_combate);
    resultado.put("xp", experiencia);
    return resultado;

  }

  // Método para simular uma luta épica contra um monstro
  public void lutaEpica(Monstro monstro) {
    Random random = new Random();
    int xpGanho = random.nextInt(100) + 1; // XP ganha aleatoriamente até 100
    System.out.println("Você entrou em uma luta épica contra um " + monstro.getNome() + "!");
    System.out.println("Lutando...");

    // Simula a batalha até que o jogador ou o monstro seja derrotado
    while (jogador.getVida() > 0 && monstro.getVida() > 0) {
      // Simula o ataque do monstro ao jogador
      int danoMonstro = monstro.ataque_basico();
      jogador.receberDano(danoMonstro);
      System.out.println(monstro.getNome() + " atacou você! Você perdeu " + danoMonstro + " de vida.");

      if (jogador.getVida() <= 0) {
        System.out.println("Você foi derrotado na batalha!");
        return;
      }

      // Simula o ataque do jogador ao monstro
      int danoJogador = jogador.ataque_basico();
      monstro.receberDano(danoJogador);
      System.out.println("Você atacou " + monstro.getNome() + " e causou " + danoJogador + " de dano.");

      if (monstro.getVida() <= 0) {
        System.out.println("Você derrotou o " + monstro.getNome() + " e ganhou " + xpGanho + " pontos de experiência!");
        jogador.ganharExperiencia(xpGanho);
        return;
      }
    }
  }
}

// Aventura ->
// encontrar objs magicos
// adicionar no inventario do personagem

// -> na aventura pode encontrar monstros -> mecanismo de combate(personagem x
// monstro) -> se for o vencedor ganha experiência e sobe o lvl
