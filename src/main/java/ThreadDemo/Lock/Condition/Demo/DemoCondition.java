package ThreadDemo.Lock.Condition.Demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DemoCondition {
    private int signal;

    private static final int A_SIGNAL = 0;
    private static final int B_SIGNAL = 1;
    private static final int C_SIGNAL = 2;

    private Lock lock = new ReentrantLock();

    private Condition a = lock.newCondition();
    private Condition b = lock.newCondition();
    private Condition c = lock.newCondition();

    //每个命名的方法, 用有对应名字的condition来作区分, 做到条件的精细控制
    public void a() {
        lock.lock();

        while (signal != A_SIGNAL) {
            try {
                a.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("a" + signal);

        signal++;
        b.signal();
        lock.unlock();
    }

    public void b() {
        lock.lock();
        while (signal != B_SIGNAL) {
            try {
                b.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("b" + signal);
        signal++;

        c.signal();
        lock.unlock();
    }

    public void c() {

        lock.lock();
        while (signal != C_SIGNAL) {
            try {
                c.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("c" + signal);
        signal = 0;
        a.signal();
        lock.unlock();
    }

}

