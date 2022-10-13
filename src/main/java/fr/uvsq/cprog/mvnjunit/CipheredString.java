package fr.uvsq.cprog.mvnjunit;

import java.util.stream.Collector;

/**
 * La classe <code>CipheredString</code> représente une chaîne chiffrée.
 *
 * @author hal
 * @version 2022
 */
public class CipheredString {
  private final String clear;
  private final int shift;

  public CipheredString(String message, int shift) {
    this.clear = message;
    this.shift = shift;
  }

  @Override
  public String toString() {
    return clear + ", " + shift + " ->";
  }

  public String decipher() {
    return clear;
  }

  public String cipher() {
    return clear.chars()
      .mapToObj(c -> shiftChar((char)c, shift))
      .collect(Collector.of(StringBuilder::new,
        StringBuilder::append,
        StringBuilder::append,
        StringBuilder::toString));
  }

  /**
   * Décale un caractère majuscule.
   * Les lettres en majuscule ('A' - 'Z') sont décalés de <code>shift</code>
   * caractères de façon circulaire. Les autres caractères ne sont pas modifiés.
   *
   * @param c le caractère à décaler
   * @param shift le décalage à appliquer
   * @return le caractère décalé
   */
  private static char shiftChar(char c, int shift) {
    return (c < 'A' || c > 'Z')? c : (char)(((c - 'A' + shift) % 26) + 'A');
  }
}
