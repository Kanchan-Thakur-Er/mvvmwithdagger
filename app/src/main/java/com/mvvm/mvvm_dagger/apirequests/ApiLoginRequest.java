package com.mvvm.mvvm_dagger.apirequests;

public class ApiLoginRequest {
    private String wsfunction;

    private ApiLoginRequestArgs args;

    private String success;

    public String getWsfunction() {
        return wsfunction;
    }

    public void setWsfunction(String wsfunction) {
        this.wsfunction = wsfunction;
    }

    public ApiLoginRequestArgs getArgs() {
        return args;
    }

    public void setArgs(ApiLoginRequestArgs args) {
        this.args = args;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "ClassPojo [wsfunction = " + wsfunction + ", args = " + args + ", success = " + success + "]";
    }
}
