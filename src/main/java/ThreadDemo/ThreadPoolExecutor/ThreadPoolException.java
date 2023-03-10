package ThreadDemo.ThreadPoolExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolException {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        executorService.submit(new task());

        executorService.execute(new task());

    }

    static class task implements Runnable {
//        public void run() {
//            try {
//                System.out.println("entered task!");
//                int i = 1 / 0;
//            } catch (Exception e) {
//                System.out.println("Caught exception with try catch: " + e);
//            }
//        }


        public void run() {

            System.out.println("entered task!");
            int i = 1 / 0;
        }
    }
}


//https://mp.weixin.qq.com/s/Ha_Jbs26zHvn-ZqMu5n5Sg