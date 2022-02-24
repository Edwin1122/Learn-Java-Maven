package DesignPattern.Adapter2;

import java.util.concurrent.Callable;

public class AdapterDemo {

    public static void main(String[] args) {
        Callable<Long> callable = new Task(12345000L);
        Thread thread = new Thread(new RunnableAdapter(callable));
        thread.start();
    }
}

class RunnableAdapter implements Runnable
{
    private Callable<?> callable;

    public RunnableAdapter(Callable<?> callable) {
        this.callable = callable;
    }


    @Override
    public void run() {
        try {
            callable.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}