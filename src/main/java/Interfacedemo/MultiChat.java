package Interfacedemo;

import static java.lang.System.out;

public class MultiChat {
    public static void main(String[] args) {

        Client c1 = new Client("127.0.0.1", "Caterpillar");//初始化一个新的client对象
        Client c2 = new Client("192.168.0.2", "Justin");

        ClientQueue queue = new ClientQueue();//初始化一个client队列

        queue.addClientListener(new ClientListener() {//操作（定义）添加listener时候的内容
            @Override
            public void clientAdded(ClientEvent event) {
                out.printf("%s login from %s %n", event.getName(), event.getIp());
            }

            @Override
            public void clientRemoved(ClientEvent event) {
                out.printf("%s login form %s %n", event.getName(), event.getIp());
            }
        });

        queue.addClient(c1);//加入队列，1.用arrayList将c1加入
        queue.addClient(c2);
        queue.removeClient(c1);
        queue.removeClient(c2);
    }
}
