package ThreadDemo.Interrupt.Cancelling;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class PrimeProducer extends Thread {
    private final BlockingQueue<BigInteger> queue;

    PrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            while (!Thread.currentThread().isInterrupted())
                queue.put(p = p.nextProbablePrime());
        } catch (InterruptedException e) {
//            e.printStackTrace();
            /* Allow thread to exit */
        }
    }

    public void cancel() {
        Thread.currentThread().interrupt();
    }

    public synchronized BlockingQueue<BigInteger> get() {//同步锁, 监视器为当前类对象
        return queue;
    }
}