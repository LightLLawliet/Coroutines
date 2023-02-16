package com.example.coroutines;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

public class MainViewModel {

    private final MutableLiveData<String> liveData;
    private final Repository repository;

    private String cached = "";
    private final DataCallback callback = value -> cached = value;

    public MainViewModel(Repository repository) {
        this.repository = repository;
        this.liveData = new MutableLiveData<>();
    }

    public void observe(LifecycleOwner owner, Observer<String> observer) {
        liveData.observe(owner, observer);
    }

    public void load() {
        new Thread(() -> {
            repository.load(callback);
            //wait!
            while ("".equals(cached)) {
                //theoretically
                //
                //temporary solution, cause we don't have
                // coroutines in Java
            }
            liveData.postValue(cached);
        }).start();
    }
}
