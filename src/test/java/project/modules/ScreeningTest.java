package project.modules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ScreeningTest {
    Screening test;
    Movie movie = new Movie("The Imitation Game", 8);
    Theatre theatre = new Theatre("Test", 50);

    @BeforeEach
    public void setup() {
        test = new Screening(movie, 0, theatre);
    }
    
    @Test
    public void testConstructor() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Screening(movie, -1, theatre);
        });
    }

    @Test
    public void testMethods() {
        Assertions.assertEquals(test, Screening.findScreening(movie, ""));
    }
}
