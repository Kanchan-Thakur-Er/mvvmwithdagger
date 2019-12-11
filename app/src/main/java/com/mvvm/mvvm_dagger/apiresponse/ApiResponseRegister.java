package com.mvvm.mvvm_dagger.apiresponse;

public class ApiResponseRegister
{
    private String msg;

    private ApiResponseRegisterObj obj;

    private String success;

    public String getMsg ()
    {
        return msg;
    }

    public void setMsg (String msg)
    {
        this.msg = msg;
    }

    public ApiResponseRegisterObj getObj ()
    {
        return obj;
    }

    public void setObj (ApiResponseRegisterObj obj)
    {
        this.obj = obj;
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
        return "ClassPojo [msg = "+msg+", obj = "+obj+", success = "+success+"]";
    }
}