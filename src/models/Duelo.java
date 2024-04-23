// Duelo.java
package models;

import java.util.function.Supplier;

import errors.InsufficientLevel;
import errors.NotEnoughLife;
import racas.Personagens;

public interface Duelo {
  String combate(Personagens atacante, Supplier<Integer> ataque) throws NotEnoughLife, InsufficientLevel;
}
