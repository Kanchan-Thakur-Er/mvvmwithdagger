package com.mvvm.mvvm_dagger.apiresponse;

public class ApiLoginResponse
{
    private String msg;

    private ApiLoginResponseObj args;

    private String success;

    public String getMsg ()
    {
        return msg;
    }

    public void setMsg (String msg)
    {
        this.msg = msg;
    }

    public ApiLoginResponseObj getArgs()
    {
        return args;
    }

    public void setArgs(ApiLoginResponseObj args)
    {
        this.args = args;
    }

    public String getSuccess ()
    {
        return success;
    }

    public void setSuccess (String success)
    {
        this.success = success;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [msg = "+msg+", args = "+ args +", success = "+success+"]";
    }
}
