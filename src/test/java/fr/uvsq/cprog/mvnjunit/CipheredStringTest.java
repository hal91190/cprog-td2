package fr.uvsq.cprog.mvnjunit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class CipheredStringTest {
    @Test
    public void shouldCreateACipheredString() {
        CipheredString cs = new CipheredString("", 3);
        fail("Not yet implemented");
    }
}
