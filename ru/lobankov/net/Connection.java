package ru.lobankov.net;

import ru.lobankov.exceptions.AlreadyClosedException;
import ru.lobankov.exceptions.ConnectionLostException;

import java.io.Closeable;

public class Connection implements Closeable {
    private final String path;
    private boolean close;

    public Connection(String path) {
        this.path = path;
        this.close = false;
    }

    public void close() {
        if (close){
            return;
        }
        this.close = true;
    }

    public boolean isOpen() {
        return !close;
    }

    public String nextString() throws ConnectionLostException {
        if (close){
            throw new AlreadyClosedException();
        }
        if (Math.random() > 0.5){
            return "test connection";
        }
        else {
            throw new ConnectionLostException();
        }
    }
}
