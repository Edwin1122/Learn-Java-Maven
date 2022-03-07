package ThreadDemo.Interrupt.Cancelling;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrimeGeneratorTest {

    @Test
    void aSecondOfPrimes() throws InterruptedException {
        List<BigInteger> res = PrimeGenerator.aSecondOfPrimes();
        System.out.println(res);
    }
}