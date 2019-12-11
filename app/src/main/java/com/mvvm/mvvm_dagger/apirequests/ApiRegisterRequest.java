package com.mvvm.mvvm_dagger.apirequests;

public class ApiRegisterRequest {
    private ApiRegisterRequestAgrs args;

    private String wsfunction;

    public ApiRegisterRequestAgrs getArgs() {
        return args;
    }

    public void setArgs(ApiRegisterRequestAgrs args) {
        this.args = args;
    }

    public String getWsfunction() {
        return wsfunction;
    }

    public void setWsfunction(String wsfunction) {
        this.wsfunction = wsfunction;
    }

    @Override
    public String toString() {
        return "ClassPojo [args = " + args + ", wsfunction = " + wsfunction + "]";
    }
}