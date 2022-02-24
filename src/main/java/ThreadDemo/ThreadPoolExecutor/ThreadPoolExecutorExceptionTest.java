package ThreadDemo.ThreadPoolExecutor;

import java.io.IOException;
import java.util.concurrent.*;

public class ThreadPoolExecutorExceptionTest {

    public static void main(String[] args) throws InterruptedException, IOException {

        //线程里的异常没有被自己处理, 一直向上抛出, 直到被main()抛出
        //主线程无法感知到异常, 输出到控制台, 正常情况下这种情况应当进行逻辑处理或日志记录
        Thread threadTest = new Thread(() -> {
            System.out.println(1 / 0);
        });
        threadTest.start();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

//        executeThreadPoolExecutor(executor);
        Thread.sleep(100);

        submitThreadPoolExecutorWithOutGet(executor);
        Thread.sleep(100);

        submitThreadPoolExecutorAndGet(executor);
        Thread.sleep(100);

        executor.shutdown();
    }


    // Runnable子线程没有捕获异常
    static void executeThreadPoolExecutor(ThreadPoolExecutor executor) {
        System.out.println("\n*****executeThreadPoolExecutor*****");
        executor.execute(() -> {
            System.out.println(1 / 0);
        });
    }


    // Callable不获取返回值
    static void submitThreadPoolExecutorWithOutGet(ThreadPoolExecutor executor) {
        System.out.println("\n*****submitThreadPoolExecutorWithOutGet*****");
        executor.submit(() -> {
            System.out.println(1 / 0);
        });
    }


    // Callable获取返回值
    static void submitThreadPoolExecutorAndGet(ThreadPoolExecutor executor) {
        System.out.println("\n*****submitThreadPoolExecutorAndGet*****");
        Future<?> future = executor.submit(() -> {
            System.out.println(1 / 0);
        });

        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("catched exception in main thread by future");
            e.printStackTrace();
        }
    }


}

