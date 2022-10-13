package fr.uvsq.cprog.mvnjunit;

import java.util.stream.Collector;

/**
 * La classe <code>CipheredString</code> représente une chaîne chiffrée.
 *
 * @author hal
 * @version 2022
 */
public class CipheredString {
  private final String ciphered;
  private final int shift;

  private CipheredString(String message, int shift) {
    this.ciphered = shiftString(message, shift);
    this.shift = shift;
  }

  public static CipheredString fromClear(String message, int shift) {
    return new CipheredString(message, shift);
  }

  public static CipheredString fromCiphered(String message, int shift) {
    String clearMessage = shiftString(message, -shift);
    return new CipheredString(clearMessage, shift);
  }

  @Override
  public String toString() {
    return shiftString(ciphered, -shift) + ", " + shift + " ->";
  }

  public String decipher() {
    return shiftString(ciphered, -shift);
  }

  public String cipher() {
    return ciphered;
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
    return (c < 'A' || c > 'Z') ? c : (char) (((c - 'A' + shift) % 26) + 'A');
  }

  /**
   * Décale les caractères d'une chaîne.
   *
   * @param s la chaîne
   * @param shift le décalage à appliquer
   * @return la chaîne décalée
   */
  private static String shiftString(String s, int shift) {
    return s.chars()
      .mapToObj(c -> shiftChar((char) c, shift))
      .collect(Collector.of(StringBuilder::new,
        StringBuilder::append,
        StringBuilder::append,
        StringBuilder::toString));
  }
}
