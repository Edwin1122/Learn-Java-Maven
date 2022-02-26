package ThreadDemo.Lock.Condition.Demo;

import ThreadDemo.Lock.Condition.Demo.DemoCondition;

public class CJob implements Runnable {
    private DemoCondition condition;

    public CJob(DemoCondition condition) {
        this.condition = condition;
    }

    @Override
    public void run() {
        while(true){
            condition.c();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}