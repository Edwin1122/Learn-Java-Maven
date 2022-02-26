package ThreadDemo.Lock.Condition.Demo;

import ThreadDemo.Lock.Condition.Demo.DemoCondition;

public class BJob implements Runnable {
    private DemoCondition condition;

    public BJob(DemoCondition condition) {
        this.condition = condition;
    }

    public void run() {
        while(true){
            condition.b();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    };
}
