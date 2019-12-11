package com.mvvm.mvvm_dagger.apirequests;

public class ApiLoginRequestArgs {
    private String password;

    private String user_name;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Override
    public String toString() {
        return "ClassPojo [password = " + password + ", user_name = " + user_name + "]";
    }
}
