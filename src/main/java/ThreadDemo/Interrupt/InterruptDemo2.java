package ThreadDemo.Interrupt;

public class InterruptDemo2 {

//    public static void main(String[] args) throws InterruptedException {
//        Thread t = new CustomizedThread();
//
//        t.start();
//
//        // 自己先睡1毫秒
//        Thread.sleep(1);
//
//        // 通知t线程中断，打扰一下
//        t.interrupt();
//
//        //t.join() means waiting for this thread to die
//        // 等待t死亡
//        t.join();
//
//        //主线程打印结束标记
//        System.out.println("end");// join等到t线程结束才执行
//    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {

            while (true) {
                // 响应中断
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("内部线程被中断，程序退出。");
                    return;
                }

                try {
                    //内部线程的业务就是睡 3s
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    //内部线程睡眠中会被打断，然后抛出InterruptedException, 然后清除Interrupt 标记
                    System.out.println("内部线程  休眠  被中断，程序退出。");
//                    Thread.currentThread().interrupt();
                }
            }

        });

        thread.start();

        //让当前主线程睡眠2s
        Thread.sleep(2000);

        //然后去中断内部线程
        thread.interrupt();
    }
}

class CustomizedThread extends Thread {
    public void run() {
        int n = 0;
        while (! isInterrupted()) {
            n ++;
            System.out.println(n + " hello!");
        }
    }
}
