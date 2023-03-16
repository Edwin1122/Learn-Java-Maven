package ThreadDemo.ThreadPractice;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class WaitNotify {

    static boolean flag = true;

    //以类一级的静态变量来做锁(也可以改为以类WaitNotify.class来上锁), 从而保证锁句柄变量唯一
    static final Object lock = new Object();

    public static void main(String[] args) throws Exception {
        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();

        TimeUnit.SECONDS.sleep(1);

        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();
    }


    static class Wait implements Runnable {
        public void run() {

            // 以同步代码块的方式加锁，拥有lock的Monitor
            synchronized (lock) {

                // 当条件不满足时，继续wait，同时释放了lock的锁
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread() + " flag is true. wait @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));

                        //当前线程等待在这个对象锁上, 直到被通知, 并且释放锁给别的线程去修改
                        lock.wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // 条件满足时，完成工作
                System.out.println(Thread.currentThread() + " flag is false. finished @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }


    static class Notify implements Runnable {

        public void run() {
            // 加锁，拥有lock的Monitor
            synchronized (lock) {
                // 获取lock的锁，然后进行通知，通知时不会释放lock的锁，
                // 直到当前线程释放了lock后，WaitThread才能从wait方法中返回
                System.out.println(Thread.currentThread() + " hold lock. notify @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));

                //通知等待在锁上的线程(lock.notify()也可以)
                lock.notifyAll();

                flag = false;
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            // 再次加锁
//            synchronized (lock) {
//                System.out.println(Thread.currentThread() + " hold lock again. sleep @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
//                try {
//                    TimeUnit.SECONDS.sleep(5);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }


        }
    }
}
