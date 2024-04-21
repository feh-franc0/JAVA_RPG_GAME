package racas;

public class Elfos extends Personagens {
  public Elfos(String nome, int vida, int forca, int magia, int agilidade, int inteligencia, int level) {
    super(nome, vida, forca, magia, agilidade, inteligencia, level);
  }

  // criando as magias e ataques:

  public int flechaEstelar() {
    return getForca() * 2;
  }

  public int soproDaFloresta() {
    return (getForca() * 3) + (getAgilidade() * 2);
  }

  public int laminaDaLuaCrescente() {
    return (int) (getForca() * 1.5 + getInteligencia() * 0.5);
  }

  public int raioDeLuzElfico() {
    return getAgilidade() * 3;
  }

  public int cancaoDaNatureza() {
    return getMagia() * 2;
  }

  public String ataque(int dano) {
    return "Anão ataca causando " + dano + " de dano.";
  }

}
