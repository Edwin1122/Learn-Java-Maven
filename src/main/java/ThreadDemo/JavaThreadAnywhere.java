package ThreadDemo;

public class JavaThreadAnywhere {

    public static void main(String[] args) {
        Thread currentThread = Thread.currentThread();

        String currentThreadName =  currentThread.getName();

        System.out.printf("The main method was executed by thread: %s \n", currentThreadName);
        Helper helper = new Helper("Java Thread Anywhere");
        helper.run();
    }

    static class Helper implements Runnable {
        private final String message;

        public Helper(String message) {
            this.message = message;
        }

        private void doSomething(String message) {

            //get current thread
            Thread currentThread = Thread.currentThread();
            //get current thread name
            String currentThreadName = currentThread.getName();

            System.out.printf("The doSomething method was excuted by thread: %s \n", currentThreadName);
            System.out.println("Do something with" + message);
        }

        @Override
        public void run() {
            doSomething(message);
        }
    }
}
