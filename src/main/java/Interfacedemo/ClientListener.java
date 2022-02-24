package Interfacedemo;

public interface ClientListener {
    void clientAdded(ClientEvent event); //called when add client
    void clientRemoved(ClientEvent event); //called when remove client
}
