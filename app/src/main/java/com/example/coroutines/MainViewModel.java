package com.example.coroutines;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

public class MainViewModel {

    private final MutableLiveData<String> liveData;
    private final Repository repository;
    private final  DataCallback callback = new DataCallback() {
        @Override
        public void returnValue(@NonNull String value) {
            liveData.postValue(value);
        }
    };

    public MainViewModel(Repository repository) {
        this.repository = repository;
        this.liveData = new MutableLiveData<>();
    }

    public void observe(LifecycleOwner owner, Observer<String> observer) {
        liveData.observe(owner, observer);
    }

    public void load() {
        repository.load(callback);
        System.out.println("");
    }
}
