package project.modules;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketTest {
    Movie movie;
    Theatre theatre;
    Screening screening;
    Tickets ticket;

    @BeforeEach 
    public void setup() throws IOException {
        movie = new Movie("Test Film", 5);
        theatre = new Theatre("Test Theatre", 50);
        screening = new Screening(movie, 0, theatre);
        ticket = new Tickets(movie, screening, 1, true, "John");
    }

    @Test
    public void testConstructor() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Tickets(movie, screening, 4, true, "John");
        });

        Assertions.assertThrows(NullPointerException.class, () -> {
            new Tickets(movie, null, 2, true, "John");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Tickets(movie, screening, 200, true, "John");
        });
    }
    
}
