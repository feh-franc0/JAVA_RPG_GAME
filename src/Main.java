import arena.Arena;
import racas.Anoes;
import racas.Elfos;

public class Main {
  public static void main(String[] args) {
    Elfos elfo = new Elfos("Legolas", 200, 50, 25, 20, 30, 1);
    Anoes anao = new Anoes("Gimli", 250, 20, 10, 15, 25, 1);

    Arena arena = new Arena(elfo, anao);

    // Ajuste aqui para chamar o método correto

    System.out.println(arena.combate(elfo, elfo::cancaoDaNatureza));
    System.out.println(arena.combate(anao, anao::avalancheDeMachados));
    System.out.println(arena.combate(elfo, elfo::cancaoDaNatureza));
    System.out.println(arena.combate(elfo, elfo::soproDaFloresta));
    System.out.println(arena.combate(anao, anao::avalancheDeMachados));
    System.out.println(arena.combate(elfo, elfo::cancaoDaNatureza));

    System.out.println(arena.combate(elfo, elfo::cancaoDaNatureza));
    System.out.println(arena.combate(anao, anao::avalancheDeMachados));
    System.out.println(arena.combate(elfo, elfo::cancaoDaNatureza));
    System.out.println(arena.combate(elfo, elfo::soproDaFloresta));
    System.out.println(arena.combate(anao, anao::avalancheDeMachados));
    System.out.println(arena.combate(elfo, elfo::cancaoDaNatureza));
  }
}
