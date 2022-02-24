package ThreadDemo.ThreadJoinDemo;

public class InterruptExample {

    private static class MyThread1 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                System.out.println("Thread run");//这句不会被执行了, 因为从sleep处程序已经被中断了

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread run");//这句会被执行
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        Thread thread1 = new MyThread1();
//        thread1.start();
//        thread1.interrupt();
//        System.out.println("Main run");

        test4();
    }

    private static void test4() throws InterruptedException {
        Thread thread = new Thread(() -> {

            while (true) {

                // 响应中断
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Java技术栈线程被中断1，程序退出。");
                    return;
                }


                try {
                    System.out.println("Running...");

                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.out.println("Java技术栈线程休眠被中断2，程序退出。");
//                    Thread.currentThread().interrupt();
                }

            }

        });

        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }

}