package ThreadDemo.ProducerConsumer;

class Clerk {

    private int productCount = 0;

    public synchronized void  produceProduct() {
        if(productCount < 20 ) {
            productCount++;
            System.out.println(Thread.currentThread().getName() + ":Start produce product No." + productCount);

            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumeProduct() {
        if(productCount > 0 ) {
            System.out.println(Thread.currentThread().getName() + ":Start consume product No." + productCount);
            productCount--;

            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread {

    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        //
        System.out.println(getName() + ":Start produce ...");

        while (true) {

            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduct();
        }
    }
}

class Consumer extends Thread {

    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        //
        System.out.println(getName() + ":Start produce ...");

        while (true) {

            try {
                sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }
}



public class ProductTest {
    public  static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer p1 = new Producer(clerk);
        p1.setName("Producer1");

        Consumer c1 = new Consumer(clerk);
        c1.setName("Consumer1");

        p1.start();
        c1.start();
    }



}
