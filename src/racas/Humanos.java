package racas;

public class Humanos extends Personagens {

  public Humanos(String nome, int vida, int forca, int magia, int agilidade, int inteligencia, int level) {
    super(nome, vida, forca, magia, agilidade, inteligencia, level);
  }

  // criando as magias e ataques:

  public int espadaFlamejante() {
    return getForca() * 2;
  }

  public int flechaDaJustica() {
    return (getForca() * 3) + (getAgilidade() * 2);
  }

  public int impactoArcano() {
    return (int) (getForca() * 1.5 + getInteligencia() * 0.5);
  }

  public int golpeDecisivo() {
    return getAgilidade() * 3;
  }

  public int dancaDasLaminas() {
    return getMagia() * 2;
  }

  public String ataque(int dano) {
    return "Anão ataca causando " + dano + " de dano.";
  }

}
