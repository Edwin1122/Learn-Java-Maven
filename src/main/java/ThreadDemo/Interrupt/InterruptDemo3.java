package ThreadDemo.Interrupt;

public class InterruptDemo3 {


    private static class MyThread1 extends Thread {
//        @Override
//        public void run() {
//
//            try {
//                Thread.sleep(2000);
//                System.out.println("Thread run inside");//这句不会被执行了, 因为从sleep处程序已经被中断了
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//                Thread.currentThread().interrupt();
//            }
//
//            System.out.println("Thread run outside");//而这句会被执行
//        }

        @Override
        public void run() {

            while (true) {
                // 响应中断
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("内部线程被中断，程序退出。");
                    return;
                }

                try {
                    //内部线程睡3s
                    Thread.sleep(3000);
                    System.out.println("Thread run inside");//这句不会被执行了, 因为从sleep处程序已经被中断了

                } catch (InterruptedException e) {
                    //睡眠被中断，并清除中断标志位
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }

                System.out.println("Thread run outside");//而这句会被执行
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new MyThread1();
        thread1.start();

        //主线程先睡1s
        Thread.sleep(1000);

        thread1.interrupt();
        System.out.println("Main run");
    }
}
