package ThreadDemo.Interrupt.Cancelling;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.*;

class PrimeProducerTest {

    @Test
    void testPrimeProducer() throws InterruptedException {
        BlockingQueue<BigInteger> queue = null;

        PrimeProducer primeProducer = new PrimeProducer(queue);
        primeProducer.start();


        try {
//            SECONDS.sleep(1);
            MILLISECONDS.sleep(100);
        } finally {
            primeProducer.cancel();
        }

//        SECONDS.sleep(1);
//        primeProducer.cancel();
        System.out.println(primeProducer.get());

    }
}