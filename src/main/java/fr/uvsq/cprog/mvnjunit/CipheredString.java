package fr.uvsq.cprog.mvnjunit;

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
}
