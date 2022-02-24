package ThreadDemo.Lock;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FairAndUnfairTest {

    @Test
    void fair() {
//        FairAndUnfair.fair();
        FairAndUnfair fair = new FairAndUnfair();
        fair.fair();
    }

    @Test
    void unfair() {
    }
}