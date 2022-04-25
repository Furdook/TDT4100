package project.modules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TheatreTest {
    static Theatre test;

    @BeforeEach
    public void setup() {
        test = new Theatre("Sal 1", 100);
    }

    @Test
    public void testConstructor() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Theatre("", 1);
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Theatre("Name", -1);
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Theatre("Name", 200);
        });
    }

    @Test
    public void testMethods() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            test.setTaken(-1, 12);
        });

        test.setTaken(0, 12);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            test.setTaken(0, 8);
        });
        
    }

}
