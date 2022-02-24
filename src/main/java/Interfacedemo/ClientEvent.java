package Interfacedemo;

public class ClientEvent {//封装clientEvent事件，包含client对象和返回对象信息的方法
    private Client client;

    public ClientEvent(Client client) {
        this.client = client;
    }

    public String getName() {
        return client.name;
    }

    public String getIp() {
        return client.ip;
    }
}
