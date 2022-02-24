package ThreadDemo;

import cc.openhome.ThreadDemo.Util.Tools;

public class RaceConditionDemo {
    public static void main(String [] args) throws Exception {
        //Client thread number
        int numberOfThreads = args.length > 0 ? Short.valueOf(args[0]) : Runtime.getRuntime().availableProcessors();

        //一次性new一个线程数组出来
        Thread[] workThreads = new Thread[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            workThreads[i] = new WorkerThread(i, 10);//new自定义的内嵌类
        }

        // 待所有线程创建完毕后，再一次性将其启动，以便这些线程能够尽可能地在同一时间内运行
        for (Thread ct : workThreads) {
            ct.start();
        }
    }


    //静态内部类 俗称内嵌类
    static class WorkerThread extends Thread {
        private final int requestCount; //成员变量存储请求数量

        public WorkerThread(int id, int requestCount) {

            //指定父类构造函数执行，传入参数为线程名(worker-id)
            // Thread(String name): Allocates a new Thread object
            super("worker-" + id);

            this.requestCount = requestCount;
        }
        @Override
        public void run() {//Thread类线程逻辑
            int i = requestCount;
            String requestID;
            RequestIDGenerator requestIDGen = RequestIDGenerator.getInstance();
            while (i-- > 0) {
                requestID = requestIDGen.nextID();
                processRequest(requestID);
            }
        }
        //Stimulate handle request
        private void processRequest(String requestID) {
            // Stimulate request time cost
            Tools.randomPause(50);
            System.out.printf("%s got requestID: %s %n", Thread.currentThread().getName(), requestID);
        }
    }


}


