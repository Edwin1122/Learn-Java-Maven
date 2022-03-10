package ThreadDemo.Lock.InterruptibleTryLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    public Lock lock;

    public Account() {
        this.lock = new ReentrantLock();
    }

    //取钱
    void debit(DeadlockAvoidance.DollarAmount d) {
    }

    //存钱
    void credit(DeadlockAvoidance.DollarAmount d) {
    }

    DeadlockAvoidance.DollarAmount getBalance() {
        return null;
    }
}
