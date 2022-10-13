package fr.uvsq.cprog.mvnjunit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CipheredStringTest {
    public static final String MESSAGE = "HAL";
    public static final int SHIFT = 1;
    public static final String TOSTRING = "HAL, 1 ->";

    @Test
    public void shouldCreateACipheredString() {
        CipheredString cs = new CipheredString(MESSAGE, SHIFT);
        assertEquals(TOSTRING, cs.toString());
    }
}
