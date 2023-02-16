package com.example.coroutines;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

public class MainViewModel extends AbstractViewModel<String> {

    private final MutableLiveData<String> liveData;
    private final Repository repository;

    public MainViewModel(Repository repository) {
        this.repository = repository;
        this.liveData = new MutableLiveData<>();
    }

    public void observe(LifecycleOwner owner, Observer<String> observer) {
        liveData.observe(owner, observer);
    }

    public void load() {
        super.load(repository, liveData::postValue);
    }
}
