package fr.uvsq.cprog.mvnjunit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CipheredStringTest {
    public static final String MESSAGE = "HAL";
    public static final int SHIFT = 1;
    public static final String TOSTRING = "HAL, 1 ->";

    @ParameterizedTest
    @CsvSource({
      "HAL, 1, 'HAL, 1 ->'",
      "'', 1, ', 1 ->'",
      "null, 1, 'null, 1 ->'"
    })
    public void shouldCreateACipheredString(String message, int shift, String expected) {
        CipheredString cs = new CipheredString(message, shift);
        assertEquals(expected, cs.toString());
    }
}
