package ru.lobankov.net;

import ru.lobankov.exceptions.ConnectionLostException;

import java.util.Random;

public class ExampleConnector{
    public void register(){
        if(new Random().nextBoolean()) throw new RuntimeException();
        System.out.println("register connection");
    }
    public void unregister(){
        System.out.println("unregister connection");
    }
    public void makeConnect(Connection conn) throws ConnectionLostException {
        register();
        conn.nextString();
        unregister();
    }
}