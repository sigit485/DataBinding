package com.sigit.databinding;

import androidx.databinding.ObservableBoolean;

public class User {
    public String name;
    public String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public ObservableBoolean isMark = new ObservableBoolean(false);
}
