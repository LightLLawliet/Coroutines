package com.example.coroutines;

public class AbstractViewModel<T> {

    private T cached = null;
    private final DataCallback<T> callback = value -> cached = value;

    protected void load(Load<T> load, DataCallback<T> datacallback) {
        new Thread(() -> {
            load.load(callback);
            while (cached == null) {
                //just theoretically
                //because we don't have coroutines in Java
            }
            datacallback.returnValue(cached);
        }).start();
    }
}

interface Load<T> {
    void load(DataCallback<T> callback);
}
