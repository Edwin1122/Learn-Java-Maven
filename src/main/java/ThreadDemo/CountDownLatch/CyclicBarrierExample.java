package ThreadDemo.CountDownLatch;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExample {

    interface runnableTest {
        void test(int param);
    }

//    class runExample implements Runnable {
//
//        @Override
//        public void run() {
//
//        }
//    }


    public static void main(String[] args) throws InterruptedException {
        final int totalThread = 10;

        CyclicBarrier cyclicBarrier = new CyclicBarrier(totalThread);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < totalThread; i++) {
            executorService.execute(
                    () -> {
                        System.out.println("before.." + Thread.currentThread().getName());
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        try {
                            cyclicBarrier.await();
                        } catch (InterruptedException | BrokenBarrierException e) {
                            e.printStackTrace();
                        }
                        System.out.print("after..");
                    }
            );
        }

//        Thread.sleep(1);
        System.out.println("outside");

        executorService.shutdown();
    }
}
