package ThreadDemo.Lock.Condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    final Lock lock = new ReentrantLock();
    final Condition condition = lock.newCondition();

    public static void main(String[] args) {
        ConditionTest test = new ConditionTest();

        Producer producer = test.new Producer();
        Consumer consumer = test.new Consumer();

        consumer.start();
        producer.start();
    }

    class Consumer extends Thread {
        @Override
        public void run() {
            consume();
        }

        private void consume() {
            try {
                lock.lock();
                System.out.println("我在等一个新信号" + Thread.currentThread().getName());
                condition.await();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("拿到一个信号" + Thread.currentThread().getName());
                lock.unlock();
            }

        }
    }

    class Producer extends Thread {
        @Override
        public void run() {
            produce();
        }

        private void produce() {
            try {
                lock.lock();
                System.out.println("我拿到锁" + Thread.currentThread().getName());
                condition.signalAll();

                System.out.println("我发出了一个信号：" + Thread.currentThread().getName());
            } finally {
                lock.unlock();
            }
        }
    }

}
