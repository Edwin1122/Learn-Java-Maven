package Guava;

import com.google.common.util.concurrent.*;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GuavaFutureCallback {

    public static void main(String[] args) {
        //JDK所提供的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        //调用装饰器方法封装成带有监听回调功能的线程池
        ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(executorService);

        ListenableFuture<Integer> listenableFuture = listeningExecutorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                if (new Random().nextInt(3) == 2) {
                    throw new NullPointerException();
                }
                return 1;
            }
        });

        //定义回调内容
        FutureCallback<Integer> futureCallback = new FutureCallback<Integer>() {
            @Override
            public void onSuccess(Integer result) {
                System.out.println(result);
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println(t.getMessage());
            }
        };

        Futures.addCallback(listenableFuture, futureCallback, listeningExecutorService);
    }
}
