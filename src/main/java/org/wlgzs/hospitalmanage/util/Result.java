package org.wlgzs.hospitalmanage.util;

import java.io.Serializable;

public class Result implements Serializable {
    private int code;
    private String msg;
    private Object data;
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Result(ResultCode resultCode, Object data) {
        this(resultCode);
        this.data = data;
    }
    public Result(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }
    public Result(ResultCode resultCode,String msg){
        this.code=resultCode.getCode();
        this.msg=msg;
    }
    public Result(ResultCode resultCode,String msg,int count,Object data){
        this.code=resultCode.getCode();
        this.msg=msg;
        this.data=data;
        this.count=count;
    }

    public Result(ResultCode resultCode,Object data,String msg) {
        this.code = resultCode.getCode();
        this.data = data;
        this.msg = msg;
    }

    public Result(ResultCode resultCode, int count) {
        this.code = resultCode.getCode();
        this.count = count;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
