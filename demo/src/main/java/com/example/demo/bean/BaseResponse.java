package com.example.demo.bean;

/**
 *
 */
public class BaseResponse<Data> {

    private Data data;

    private String msg;

    private Integer code;

    public Data getData () {
        return data;
    }

    public void setData (Data data) {
        this.data = data;
    }

    public String getMsg () {
        return msg;
    }

    public void setMsg (String msg) {
        this.msg = msg;
    }

    public Integer getCode () {
        return code;
    }

    public void setCode (Integer code) {
        this.code = code;
    }

    public BaseResponse () {
    }

    public BaseResponse (boolean success) {
        if(success) {
            this.msg = "成功";
            this.code = 0;
        } else {
            this.msg = "系统忙";
            this.code = 500;
        }
    }

}
