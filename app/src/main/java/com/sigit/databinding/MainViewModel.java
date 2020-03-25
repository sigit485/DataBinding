package com.sigit.databinding;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {

    private MutableLiveData<List<User>> user = new MutableLiveData<>();
    private MainNavigator navigator;

    public void setNavigator(MainNavigator navigator) {
        this.navigator = navigator;
    }

    public MutableLiveData<List<User>> getUser() {
        setUser();
        return user;
    }

    public void setUser() {
        List<User> users = new ArrayList<>();
        users.add(new User("Sigit", "sgt@gmail.com"));
        users.add(new User("Sigit Hardianto", "sgt@gmail.com"));
        users.add(new User("Sigit Hardianto 2", "sgt@gmail.com"));
        users.add(new User("Hardianto", "sgt@gmail.com"));
        users.add(new User("Hardianto 1", "sgt@gmail.com"));
        users.add(new User("Hardianto 3", "sgt@gmail.com"));

        this.user.setValue(users);
    }

    public void itemClick(User user) {
        navigator.onItemClick(user);
    }
}
