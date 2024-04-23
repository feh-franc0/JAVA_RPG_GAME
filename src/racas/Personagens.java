package racas;

import java.util.ArrayList;
import java.util.List;

import models.Lutador;

public class Personagens implements Lutador {
  private String nome;
  private int vida = 1800;
  private int forca = 10;
  private int magia = 20;
  private int agilidade = 15;
  private int inteligencia = 50;
  private int level = 1;
  private int xp = 0;
  public ArrayList<String> mochila;

  public Personagens(String nome, int vida, int forca, int magia, int agilidade, int inteligencia, int level) {
    this.nome = nome;
    this.vida = vida;
    this.forca = forca;
    this.magia = magia;
    this.agilidade = agilidade;
    this.inteligencia = inteligencia;
    this.level = level;
    this.mochila = new ArrayList<String>();
  }

  // Ataque basico
  public int ataque_basico() {
    return this.getForca() * 2;
  }

  // Getters and Setters
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getVida() {
    return vida;
  }

  public int getForca() {
    return forca;
  }

  public int getMagia() {
    return magia;
  }

  public int getAgilidade() {
    return agilidade;
  }

  public int getInteligencia() {
    return inteligencia;
  }

  public int getLevel() {
    return level;
  }

  // ToString para mostrar os atributos
  @Override
  public String toString() {

    return " > " + "Nome: " + this.nome + " | " +
        "Vida: " + this.vida + " | " +
        "Forca: " + this.forca + " | " +
        "Magia: " + this.magia + " | " +
        "Agilidade: " + this.agilidade + " | " +
        "Inteligência: " + this.inteligencia + " | " +
        "Level: " + this.level + " < ";
    // return "Nome: " + this.nome + "\n" +
    // "Vida: " + this.vida + "\n" +
    // "Forca: " + this.forca + "\n" +
    // "Magia: " + this.magia + "\n" +
    // "Agilidade: " + this.agilidade + "\n" +
    // "Inteligência: " + this.inteligencia + "\n" +
    // "Level: " + this.level;
  }

  // @Override
  public int atacar(int dano) {
    return dano;
  }

  // @Override
  public void receberDano(int dano) {
    this.vida = this.vida - dano;
  }

  public void imprimirMochila() {
    System.out.println("Itens na mochila:");
    for (int i = 0; i < mochila.size(); i++) {
      System.out.println("[" + i + "] " + mochila.get(i));
    }
  }

  public void imprimirItem(int posicao) {
    try {
      String item = mochila.get(posicao);
      System.out.println("Item na posição " + posicao + ": " + item);
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Posição inválida! Não há item na posição " + posicao);
    }
  }

  public void ganharExperiencia(int xp) {
    this.xp += xp;
    while (this.xp >= calcularXPProximoNivel()) {
      this.xp -= calcularXPProximoNivel();
      subirNivel();
    }
  }

  private void subirNivel() {
    this.level++;
    System.out.println("Parabéns! " + this.nome + " subiu para o nível " + this.level + "!");
  }

  private int calcularXPProximoNivel() {
    // Cálculo simples para a quantidade de XP necessária para o próximo nível
    return (int) Math.pow(this.level, 2) * 100;
  }

}
