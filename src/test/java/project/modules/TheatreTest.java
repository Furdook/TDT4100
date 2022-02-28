package project.modules;

import org.junit.jupiter.api.BeforeEach;

public class TheatreTest {
    static Theatre test;

    @BeforeEach
    public void setup() {
        test = new Theatre("Sal 1", 100);
    }

}
