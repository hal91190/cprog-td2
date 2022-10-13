package fr.uvsq.cprog.mvnjunit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CipheredStringTest {
    public static final String MESSAGE = "HAL";
    public static final String CIPHERED_MESSAGE = "IBM";
    public static final int SHIFT = 1;

    private CipheredString cs;

    @BeforeEach
    public void setup() {
        cs = CipheredString.fromClear(MESSAGE, SHIFT);
    }

    @Test
    public void shouldReturnTheClearString() {
        assertEquals(MESSAGE, cs.decipher());
    }

    @Test
    public void shouldReturnTheCipheredString() {
        assertEquals(CIPHERED_MESSAGE, cs.cipher());
    }

    @ParameterizedTest
    @CsvSource({
      "HAL, 1, 'HAL, 1 ->'",
      "'', 1, ', 1 ->'",
      "null, 1, 'null, 1 ->'"
    })
    public void shouldCreateACipheredStringFromClearMessage(String message, int shift, String expected) {
        CipheredString cs = CipheredString.fromClear(message, shift);
        assertEquals(expected, cs.toString());
    }

    @ParameterizedTest
    @CsvSource({
      "IBM, 1, 'HAL, 1 ->'",
      "'', 1, ', 1 ->'",
      "null, 1, 'null, 1 ->'"
    })
    public void shouldCreateACipheredStringFromCipheredMessage(String message, int shift, String expected) {
        CipheredString cs = CipheredString.fromCiphered(message, shift);
        assertEquals(expected, cs.toString());
    }
}
