package racas;

public class Anoes extends Personagens {

  public Anoes(String nome, int vida, int forca, int magia, int agilidade, int inteligencia, int level) {
    super(nome, vida, forca, magia, agilidade, inteligencia, level);
  }

  public int marteloDePedra() {
    return getForca() * 2;
  }

  public int avalancheDeMachados() {
    return (getForca() * 3) + (getAgilidade() * 2);
  }

  public int golpeSismico() {
    return (int) (getForca() * 1.5 + getInteligencia() * 0.5);
  }

  public int rebentamentoDeTerra() {
    return getAgilidade() * 3;
  }

  public int investidaAna() {
    return getMagia() * 2;
  }

  public String ataque(int dano) {
    return "Anão ataca causando " + dano + " de dano.";
  }

}
