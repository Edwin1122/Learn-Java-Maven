package ThreadDemo.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockUseCase {

    public void lock() {
        Lock lock = new ReentrantLock();
        lock.lock();

        try {

        } finally {
            lock.unlock();
        }
    }

//    final boolean nonfairTryAcquire(int acquires) {
//        final Thread current = Thread.currentThread();
//        int c = getState();
//        if (c == 0) {
//            if (compareAndSetState(0, acquires)) {
//                setExclusiveOwnerThread(current);
//                return true;
//            }
//        } else if (current == getExclusiveOwnerThread()) {
//            int nextc = c + acquires;
//            if (nextc < 0) throw new Error("Maximum lock count exceeded");
//            setState(nextc);
//            return true;
//        }
//        return false;
//    }
}
