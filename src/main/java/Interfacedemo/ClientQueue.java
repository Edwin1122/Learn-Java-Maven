package Interfacedemo;

import java.util.ArrayList;

public class ClientQueue {
    private ArrayList clients = new ArrayList();
    private ArrayList listeners = new ArrayList();

    public void addClientListener(ClientListener listener) {//注册ClientListener
        listeners.add(listener);
    }

    public void addClient(Client client) {//定义加入成员时候的操作
        clients.add(client);//将client加入队列

        ClientEvent event = new ClientEvent(client);//把通知信息封装为ClientEvent

        for (int i = 0; i< listeners.size(); i++) {
            ClientListener listener = (ClientListener) listeners.get(i);
            listener.clientAdded(event); //逐一取出ClientListener通知
        }

    }

    public void removeClient(Client client) {
        clients.remove(client);
        ClientEvent event = new ClientEvent(client);
        for (int i=0; i<listeners.size(); i++) {
            ClientListener listener = (ClientListener) listeners.get(i);
            listener.clientRemoved(event);
        }

    }
}
