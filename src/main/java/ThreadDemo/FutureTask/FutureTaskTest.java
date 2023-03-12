package ThreadDemo.FutureTask;

import java.util.concurrent.*;

public class FutureTaskTest {
    private final ConcurrentMap<Object, Future<String>> taskCache = new ConcurrentHashMap<Object, Future<String>>();

    private String executionTask(final String taskName) throws ExecutionException, InterruptedException {

        while (true) {
            Future<String> future = taskCache.get(taskName);

            if (future == null) {
                Callable<String> task = new Callable<String>() {
                    public String call() throws InterruptedException {
                        return taskName;
                    }
                };

                FutureTask<String> futureTask = new FutureTask<String>(task);
                future = taskCache.putIfAbsent(taskName, futureTask);

                if (future == null) {
                    future = futureTask;
                    futureTask.run();
                }

            } try {
                return future.get();

            } catch (CancellationException e) {
                taskCache.remove(taskName, future);
            }
         }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTaskTest futureTaskTest = new FutureTaskTest();

        String res = futureTaskTest.executionTask("test");
        System.out.println(res);
    }


}
