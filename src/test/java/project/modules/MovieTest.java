package project.modules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MovieTest {
    static Movie test;

    @BeforeEach
    public void setup() {
        test = new Movie("The Imitation Game", 8);
    }

    @Test
    public void testConstructor() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Movie("Ex Machina", 0);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Movie("", 3);
        });
        Assertions.assertEquals("The Imitation Game", test.getTitle());
        Assertions.assertEquals(8, test.getLength());
    }

    @Test
    public void testMethods() {
        Assertions.assertEquals(test, Movie.getMovie("The Imitation Game"));
    }
}


