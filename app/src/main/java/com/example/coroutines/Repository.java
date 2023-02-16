package com.example.coroutines;

public interface Repository {

    void load(DataCallback callback);

    class Base implements Repository {
        @Override
        public void load(DataCallback callback) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                        callback.returnValue(System.currentTimeMillis() + "");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
    }
}
