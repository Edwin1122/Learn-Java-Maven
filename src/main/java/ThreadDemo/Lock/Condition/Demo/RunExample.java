package ThreadDemo.Lock.Condition.Demo;

public class RunExample {
    public static void main(String[] args) {
        DemoCondition condition = new DemoCondition();

        AJob a = new AJob(condition);
        BJob b = new BJob(condition);
        CJob c = new CJob(condition);


        new Thread(b).start();
        new Thread(a).start();
        new Thread(a).start();
        new Thread(b).start();
        new Thread(c).start();
        new Thread(a).start();
        new Thread(c).start();
        new Thread(a).start();
        new Thread(c).start();
        new Thread(c).start();
    }

}
