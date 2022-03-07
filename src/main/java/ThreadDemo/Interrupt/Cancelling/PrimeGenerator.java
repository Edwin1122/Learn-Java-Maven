package ThreadDemo.Interrupt.Cancelling;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;


public class PrimeGenerator implements Runnable {
    private static ExecutorService exec = Executors.newCachedThreadPool();
    private final List<BigInteger> primes = new ArrayList<BigInteger>();

    private volatile boolean cancelled;//要线程安全

    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!cancelled) {
            p = p.nextProbablePrime();

            synchronized (this) {//同步锁, 监视器为当前类对象
                primes.add(p);
            }
        }
    }

    public void cancel() {
        cancelled = true;
    }

    public synchronized List<BigInteger> get() {//同步锁, 监视器为当前类对象
        return new ArrayList<BigInteger>(primes);
    }

    static List<BigInteger> aSecondOfPrimes() throws InterruptedException {
        PrimeGenerator generator = new PrimeGenerator();
        exec.execute(generator);

        try {
//            SECONDS.sleep(1);
            MILLISECONDS.sleep(100);
        } finally {
            generator.cancel();
        }

        return generator.get();
    }
}
