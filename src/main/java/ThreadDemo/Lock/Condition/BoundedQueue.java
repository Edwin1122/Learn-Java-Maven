package ThreadDemo.Lock.Condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedQueue<T> {

    private Object[]  items;

    // 添加的下标，删除的下标 和 数组当前数量
    private int       addIndex, removeIndex, count;

    private Lock lock     = new ReentrantLock();
    //未空
    private Condition notEmpty = lock.newCondition();

    //未满
    private Condition notFull  = lock.newCondition();

    public BoundedQueue(int size) {
        items = new Object[size];
    }

    // 添加一个元素，如果数组满，则添加线程进入等待状态，直到有“空位”
    public void add(T t) throws InterruptedException {
        lock.lock();
        try {
            //数组满了, 未满条件为假, 进入等待, 阻塞在这个地方, 被释放后才执行后面的语句
            while (count == items.length)
                notFull.await();

            items[addIndex] = t;
            if (++addIndex == items.length)
                addIndex = 0;
            ++count;

            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    // 由头部删除一个元素，如果数组空，则删除线程进入等待状态，直到有新添加元素
    @SuppressWarnings("unchecked")
    public T remove() throws InterruptedException {
        lock.lock();
        try {
            //数组为空, 未空条件为假, 进入等待, 阻塞在这个地方, 被释放后才执行后面的语句
            while (count == 0)
                notEmpty.await();

            Object x = items[removeIndex];
            if (++removeIndex == items.length)
                removeIndex = 0;

            --count;
            notFull.signal();
            return (T) x;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BoundedQueue<Integer> queue = new BoundedQueue<Integer>(5);

        queue.add(2);
        queue.add(20);
        queue.add(100);
        queue.add(10);
        queue.add(222);
        queue.add(2222);
        queue.add(111);

        System.out.println(queue);

    }

}
